package ag.pdf.converter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PdfConverterTest {

    private static final String VALID_JSON = "{\"widget\": \"container\", "
            + "\"content\": [ {\"widget\": \"text\", \"value\": \"test content\","
            + "\"style\": {\"size\": \"10\",\"color\": \"red\"}}]}";

    @Autowired
    PdfConverter converter;

    @Test
    public void getPdfAsByteArray() throws IOException {
        byte[] content = converter.getPdfAsByteArray(VALID_JSON);

        assertTrue(content.length > 0);
    }

    @Test
    public void getPdfAsByteArray_EmptyJson() throws IOException {
        byte[] content = converter.getPdfAsByteArray("");

        assertTrue(content.length == 0);
    }

    @Test
    public void getPdfAsByteArray_Null() throws IOException {
        byte[] content = converter.getPdfAsByteArray(null);

        assertTrue(content.length == 0);
    }

    @Test
    public void getPdfAsByteArray_invalidJson() throws IOException {
        byte[] content = converter.getPdfAsByteArray("{}");

        assertTrue(content.length == 0);
    }
}
