package ag.pdf.converter.validation;

import ag.pdf.converter.descriptor.ContainerDescriptor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFormatValidator {

    private static final String ERROR_EMPTY_JSON = "Json cannot be empty.";
    private static final String ERROR_INVALID_JSON = "Json structure is not valid.";

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    public ValidationResult validate(String json) {
        boolean isValid = true;
        List<String> errors = new ArrayList<>();


        if (json.isEmpty()) {
            isValid = false;
            errors.add(ERROR_EMPTY_JSON);
        } else if (!isValidJsonStructure(json, ContainerDescriptor.class)) {
            isValid = false;
            errors.add(ERROR_INVALID_JSON);
        }

        return new ValidationResult(isValid, errors, EMPTY_LIST);
    }

    private boolean isValidJsonStructure(String jsonStr, Class<?> valueType) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readValue(jsonStr, valueType);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
