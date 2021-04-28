package ag.pdf.converter.component;

import ag.pdf.converter.model.WText;
import com.itextpdf.layout.element.Text;

public class DocumentWidgetVisitor {

	public void visit(DText text) {
		WText widget = (WText) text.getWidget();
		Text textElement = new Text(widget.getValue())
				.setFontSize(widget.getStyle().getSize());
		text.setElement(textElement);
	}

	public void visit(DContainer text) {

	}

}
