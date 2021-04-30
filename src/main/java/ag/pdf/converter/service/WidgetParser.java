package ag.pdf.converter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.layout.element.IBlockElement;

import ag.pdf.converter.component.DContainer;
import ag.pdf.converter.component.DocumentWidgetVisitor;
import ag.pdf.converter.model.Container;

@Service
public class WidgetParser {
	
	public List<IBlockElement> parse(Container container) {
		DContainer dContainer = new DContainer(container);
		dContainer.accept(new DocumentWidgetVisitor());
		return dContainer.retriveIElements();
	}
}
