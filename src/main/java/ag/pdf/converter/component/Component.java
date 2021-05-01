package ag.pdf.converter.component;

import com.itextpdf.layout.element.IBlockElement;

public interface Component {

	public void accept(ComponentVisitor componentVisitor);

	public IBlockElement getIElement();
}
