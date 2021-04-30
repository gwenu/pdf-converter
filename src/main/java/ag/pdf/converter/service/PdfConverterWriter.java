package ag.pdf.converter.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;

import ag.pdf.converter.model.Container;

@Service
public class PdfConverterWriter {
	
	@Autowired
	private WidgetParser widgetParser;
	
	public byte[] writeToByteArray(Container container) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(baos);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		List<IBlockElement> elements = widgetParser.parse(container);
		
		for(IBlockElement element : elements) {
			document.add(element);
		}

		document.close();
		baos.close();
		
		return baos.toByteArray();
	}
}
