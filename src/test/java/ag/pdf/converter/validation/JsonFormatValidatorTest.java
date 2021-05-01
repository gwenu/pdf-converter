package ag.pdf.converter.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonFormatValidatorTest {

    private static final String VALID_JSON = "{\"widget\": \"container\", "
            + "\"content\": [ {\"widget\": \"text\", \"value\": \"test content\","
            + "\"style\": {\"size\": \"10\",\"color\": \"red\"}}]}";

    private JsonFormatValidator validator = new JsonFormatValidator();

    @Test
    public void validate_ValidJson() {
        ValidationResult validationResult = validator.validate(VALID_JSON);

        assertTrue(validationResult.isValid());
        assertTrue(validationResult.getErrors().isEmpty());
        assertTrue(validationResult.getWarnings().isEmpty());
    }

    @Test
    public void validate_EmptyJson() {
        ValidationResult validationResult = validator.validate("");

        assertFalse(validationResult.isValid());
        assertTrue(validationResult.getErrors().size() == 1);
        assertEquals("Json cannot be empty.", validationResult.getErrors().get(0));
    }

    @Test
    public void validate_InvalidJson() {
        ValidationResult validationResult = validator.validate("{invalidKey: value}");

        assertFalse(validationResult.isValid());
        assertTrue(validationResult.getErrors().size() == 1);
        assertEquals("Json structure is not valid.", validationResult.getErrors().get(0));
    }
}
