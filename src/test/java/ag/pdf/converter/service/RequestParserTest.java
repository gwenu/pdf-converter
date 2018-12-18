package ag.pdf.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;

import ag.pdf.converter.model.WContainer;
import ag.pdf.converter.model.WText;
import ag.pdf.converter.util.json.JsonConst;

@RunWith(SpringRunner.class)
public class RequestParserTest {

	private static final String TEST_JSON = "{\"widget\": \"container\", "
			+ "\"content\": [ {\"widget\": \"text\", \"value\": \"test content\","
			+ "\"style\": {\"size\": \"10\",\"color\": \"red\"}}]}";

	private static final String EXPECTED_TEXT_VALUE = "test content";
	private static final String EXPECTED_TEXT_STYLE_COLOUR = "red";
	private static final int EXPECTED_TEXT_STYLE_SIZE = 10;

	@Test
	public void parseSuccess() throws JsonParseException, IOException {
		RequestParser parser = new RequestParser();
		WContainer container = parser.parse(TEST_JSON);

		assertEquals(JsonConst.Value.CONTAINER, container.getWidget());
		assertEquals(1, container.getContent().size());

		WText text = (WText) container.getContent().get(0);

		assertEquals(EXPECTED_TEXT_VALUE, text.getValue());
		assertEquals(EXPECTED_TEXT_STYLE_SIZE, text.getStyle().getSize());
		assertEquals(EXPECTED_TEXT_STYLE_COLOUR, text.getStyle().getColor());
	}
}
