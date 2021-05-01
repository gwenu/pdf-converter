package ag.pdf.converter.service;

import ag.pdf.converter.descriptor.ContainerDescriptor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PdfConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfConverter.class);

    @Autowired
    private PdfConverterWriter writer;

    public byte[] getPdfAsByteArray(String json) throws IOException {
        byte[] pdfAsByteArray = "".getBytes();

        if (json != null && !json.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                ContainerDescriptor containerDescriptor = mapper.readValue(json, ContainerDescriptor.class);
                pdfAsByteArray = writer.writeToByteArray(containerDescriptor);
            } catch (JsonProcessingException exception) {
                LOGGER.warn("Json has incorrect format: " + exception);
            }
        }

        return pdfAsByteArray;
    }
}
