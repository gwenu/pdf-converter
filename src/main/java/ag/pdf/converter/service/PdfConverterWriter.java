package ag.pdf.converter.service;

import ag.pdf.converter.descriptor.ContainerDescriptor;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfConverterWriter {

    @Autowired
    private DescriptorParser descriptorParser;

    public byte[] writeToByteArray(ContainerDescriptor descriptor) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        List<IBlockElement> elements = descriptorParser.parse(descriptor);

        for (IBlockElement element : elements) {
            document.add(element);
        }

        document.close();
        baos.close();

        return baos.toByteArray();
    }
}
