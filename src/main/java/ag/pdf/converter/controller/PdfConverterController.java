package ag.pdf.converter.controller;

import ag.pdf.converter.exception.JsonFormatValidationException;
import ag.pdf.converter.service.PdfConverter;
import ag.pdf.converter.validation.JsonFormatValidator;
import ag.pdf.converter.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfConverterController {

    @Autowired
    private PdfConverter pdfConverter;

    @Autowired
    private JsonFormatValidator validator;

    @RequestMapping(value = "/pdf", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> pdf(@RequestBody String jsonToConvert) throws IOException, JsonFormatValidationException {
        ValidationResult validationResult = validator.validate(jsonToConvert);

        if (validationResult.isValid()) {
            byte[] content = pdfConverter.getPdfAsByteArray(jsonToConvert);
            return new ResponseEntity<>(content, new HttpHeaders(), HttpStatus.OK);
        } else {
            throw new JsonFormatValidationException(validationResult);
        }
    }
}
