package ag.pdf.converter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfConverterController {

	@RequestMapping(value = "/", produces = "application/json")
    public String hello() {
    
        return "Hello";
    }
}
