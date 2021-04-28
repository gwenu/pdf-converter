package ag.pdf.converter.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ag.pdf.converter.model.WContainer;

@Service
public class RequestParser {

    public WContainer parse(String json) throws JsonParseException, IOException {
        WContainer container = null;

        if (!json.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            container = mapper.readValue(json, WContainer.class);
        }

        return container;
    }
}
