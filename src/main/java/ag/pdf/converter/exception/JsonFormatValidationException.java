package ag.pdf.converter.exception;

import ag.pdf.converter.validation.ValidationResult;

public class JsonFormatValidationException extends Throwable {

    private ValidationResult validationResult;

    public JsonFormatValidationException(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }
}
