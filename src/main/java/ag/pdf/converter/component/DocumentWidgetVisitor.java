package ag.pdf.converter.component;

import ag.pdf.converter.model.Text;

public class DocumentWidgetVisitor {

	public void visit(DText text) {
		Text widget = (Text) text.getWidget();
		com.itextpdf.layout.element.Text textElement = new com.itextpdf.layout.element.Text(widget.getValue())
				.setFontSize(widget.getStyle().getSize());
		text.setElement(textElement);
	}

	public void visit(DContainer text) {

	}

}
