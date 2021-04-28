package ag.pdf.converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConverterController {

    @GetMapping(value = "/")
    public String hello() {
        return "index";
    }
}
