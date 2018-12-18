package ag.pdf.converter.component;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.element.Text;

import ag.pdf.converter.model.WText;

public class DocumentWidgetVisitor {

	public void visit(DText text) {
		WText widget = (WText) text.getWidget();
		Text textElement = new Text(widget.getValue())
				.setFontColor(Color.RED)
				.setFontSize(widget.getStyle().getSize());
		text.setElement(textElement);
	}

	public void visit(DContainer text) {

	}

}
