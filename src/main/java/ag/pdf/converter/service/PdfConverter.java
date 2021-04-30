package ag.pdf.converter.service;

import ag.pdf.converter.model.Container;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PdfConverter {

    @Autowired
    private PdfConverterWriter writer;

    public byte[] getPdfAsByteArray(String json) throws IOException {

        if (json != null && !json.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            Container container = mapper.readValue(json, Container.class);
            return writer.writeToByteArray(container);
        } else {
            return "".getBytes();
        }
    }
}
