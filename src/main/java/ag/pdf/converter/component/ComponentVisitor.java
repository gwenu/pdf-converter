package ag.pdf.converter.component;

import ag.pdf.converter.descriptor.TextDescriptor;
import com.itextpdf.layout.element.Text;

public class ComponentVisitor {

	public void visit(TextComponent text) {
		TextDescriptor textDescriptor = text.getDescriptor();
		Text textElement = new Text(textDescriptor.getValue())
				.setFontSize(textDescriptor.getStyle().getSize());
		text.setElement(textElement);
	}

	public void visit(ContainerComponent container) {

	}

}
