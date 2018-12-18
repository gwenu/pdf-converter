package ag.pdf.converter.component;

import com.itextpdf.layout.element.IBlockElement;

public interface DWidget {
	public void accept(DocumentWidgetVisitor documentWidgetVisitor);
	public IBlockElement getIElement();
}
