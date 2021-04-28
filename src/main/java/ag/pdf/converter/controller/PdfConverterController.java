package ag.pdf.converter.controller;

import ag.pdf.converter.model.WContainer;
import ag.pdf.converter.service.PdfConverterWriter;
import ag.pdf.converter.service.RequestParser;
import ag.pdf.converter.validation.JsonFormatValidator;
import ag.pdf.converter.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PdfConverterController {

    @Autowired
    private RequestParser parser;

    @Autowired
    private PdfConverterWriter writer;

    @Autowired
    private JsonFormatValidator validator;

    @RequestMapping(value = "/pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> pdf(@RequestParam("jsonToConvert") String jsonToConvert) throws IOException {
        ValidationResult validationResult = validator.validate(jsonToConvert);

        if (validationResult.isValid()) {
            WContainer container = parser.parse(jsonToConvert);
            ResponseEntity<byte[]> response = new ResponseEntity<>(writer.writeToByteArray(container), new HttpHeaders(),
                    HttpStatus.OK);
            return response;
        } else {
            return null;
        }
    }
}
