package ag.pdf.converter.validation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFormatValidator {

    private static final String EMPTY_JSON = "Json submitted for validation is empty.";

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    public ValidationResult validate(String json) {
        ValidationResult validationResult = new ValidationResult(true, EMPTY_LIST, EMPTY_LIST);

        if(json.isEmpty()) {
            validationResult = new ValidationResult(false, List.of(EMPTY_JSON), EMPTY_LIST);
        }

        return validationResult;
    }
}
