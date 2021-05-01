package ag.pdf.converter.component;

import ag.pdf.converter.descriptor.TextDescriptor;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;

public class TextComponent implements Component {

	private TextDescriptor descriptor;
	private IElement element;
	
	public TextComponent(TextDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void accept(ComponentVisitor componentVisitor) {
		componentVisitor.visit(this);
	}

	@Override
	public IBlockElement getIElement() {
		return new Paragraph(getDescriptor().getValue());
	}

	public TextDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(TextDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public IElement getElement() {
		return element;
	}

	public void setElement(IElement element) {
		this.element = element;
	}
}
