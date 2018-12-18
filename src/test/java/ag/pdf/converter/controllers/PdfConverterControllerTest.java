package ag.pdf.converter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ag.pdf.converter.service.PdfConverterWriter;
import ag.pdf.converter.service.RequestParser;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PdfConverterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RequestParser parser;

	@MockBean
	private PdfConverterWriter writer;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}
}
