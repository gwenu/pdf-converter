package ag.pdf.converter.controllers;

import ag.pdf.converter.service.PdfConverter;
import ag.pdf.converter.service.PdfConverterWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PdfConverterControllerTest {

	private static final String VALID_JSON = "{\"widget\": \"container\", "
			+ "\"content\": [ {\"widget\": \"text\", \"value\": \"test content\","
			+ "\"style\": {\"size\": \"10\",\"color\": \"red\"}}]}";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PdfConverter parser;

	@MockBean
	private PdfConverterWriter writer;

	@Test
	public void pdf_ValidJsonParm() throws Exception {
		MvcResult result = this.mockMvc
				.perform(post("/pdf")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(VALID_JSON))
				.andExpect(status().isOk())
				.andReturn();

		assertTrue(result.getResponse().getContentLength() == 0);
	}

	@Test
	public void pdf_InvalidJsonParm() throws Exception {
		MvcResult result = this.mockMvc
				.perform(post("/pdf")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content("{}"))
				.andExpect(status().isBadRequest())
				.andReturn();

		assertTrue(result.getResponse().getContentLength() == 0);
	}

	@Test
	public void pdf_EmptyJsonParm() throws Exception {
		MvcResult result = this.mockMvc
				.perform(post("/pdf")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(""))
				.andExpect(status().isBadRequest())
				.andReturn();

		assertTrue(result.getResponse().getContentLength() == 0);
	}
}
