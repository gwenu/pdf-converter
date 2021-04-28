package ag.pdf.converter.validation;

import java.util.List;

public class ValidationResult {

    private boolean isValid;
    private List<String> errors;
    private List<String> warnings;

    public ValidationResult(boolean isValid, List<String> errors, List<String> warnings) {
        this.isValid = isValid;
        this.errors = errors;
        this.warnings = warnings;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }
}
