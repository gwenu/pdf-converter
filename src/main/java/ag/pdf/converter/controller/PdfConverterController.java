package ag.pdf.converter.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ag.pdf.converter.service.PdfConverterWriter;

@RestController
public class PdfConverterController {
	private static final String INDEX_VIEW = "index";

	@RequestMapping(value = "/")
    public ModelAndView hello() {
        return new ModelAndView(INDEX_VIEW);
    }
	
	@RequestMapping(value = "/pdf", method = RequestMethod.POST, produces =  MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> pdf(@RequestParam("jsonToConvert") String jsonToConvert) throws IOException {
		PdfConverterWriter writer = new PdfConverterWriter();
		ResponseEntity<byte[]> response = new ResponseEntity<>(writer.writeToByteArray(), new HttpHeaders(), HttpStatus.OK);
        return response;
    }
}
