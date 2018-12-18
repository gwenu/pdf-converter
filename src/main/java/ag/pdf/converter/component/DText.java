package ag.pdf.converter.component;

import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;

import ag.pdf.converter.model.WText;
import ag.pdf.converter.model.Widget;

public class DText extends AbstractDWidget implements DWidget {
	
	public DText(Widget widget) {
		super(widget);
	}

	@Override
	public void accept(DocumentWidgetVisitor documentWidgetVisitor) {
		documentWidgetVisitor.visit(this);
	}

	@Override
	public IBlockElement getIElement() {
		return new Paragraph(((WText)getWidget()).getValue());
	}
}
