package ag.pdf.converter.component;

import ag.pdf.converter.descriptor.StyleDescriptor;
import ag.pdf.converter.descriptor.TextDescriptor;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Text;

public class ComponentVisitor {

	public void visit(TextComponent text) {
		TextDescriptor textDescriptor = text.getDescriptor();
		StyleDescriptor styleDescriptor = textDescriptor.getStyle();
		Style style = new Style()
				.setFontSize(styleDescriptor.getSize())
				.setFontColor(text.getColor(styleDescriptor.getColor()));
		Text textElement = new Text(textDescriptor.getValue());

		textElement.addStyle(style);
		text.setElement(textElement);
	}

	public void visit(ContainerComponent container) {

	}

}
