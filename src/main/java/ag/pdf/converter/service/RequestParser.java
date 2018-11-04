package ag.pdf.converter.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import ag.pdf.converter.model.WContainer;

@Service
public class RequestParser {

	public WContainer parse(String json) throws JsonParseException, IOException {
		JsonParser parser = new JsonFactory().createParser(json);
		ObjectMapper mapper = new ObjectMapper();
		WContainer container =  mapper.readValue(parser, WContainer.class);
		
		return container;
	}
}
