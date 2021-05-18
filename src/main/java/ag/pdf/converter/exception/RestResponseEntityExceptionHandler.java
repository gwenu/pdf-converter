package ag.pdf.converter.exception;

import ag.pdf.converter.validation.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {JsonFormatValidationException.class})
    protected ResponseEntity<ValidationResult> handleJsonValidationException(JsonFormatValidationException ex) {
        LOGGER.warn("Json format validation failed: ", ex);

        return new ResponseEntity<>(ex.getValidationResult(), HttpStatus.BAD_REQUEST);
    }
}
