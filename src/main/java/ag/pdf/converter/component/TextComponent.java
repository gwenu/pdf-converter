package ag.pdf.converter.component;

import ag.pdf.converter.descriptor.TextDescriptor;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.util.HashMap;
import java.util.Map;

public class TextComponent implements Component {

	private static final Map<String, Color> colorMap = new HashMap<>();

	static {
		colorMap.put("green", ColorConstants.GREEN);
		colorMap.put("red", ColorConstants.RED);
	}

	private TextDescriptor descriptor;
	private Text text;
	
	public TextComponent(TextDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void accept(ComponentVisitor componentVisitor) {
		componentVisitor.visit(this);
	}

	@Override
	public IBlockElement getIElement() {
		return new Paragraph().add(text);
	}

	public Color getColor(String key) {
		return colorMap.get(key);
	}

	public TextDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(TextDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public IElement getElement() {
		return text;
	}

	public void setElement(IElement element) {
		this.text = (Text) element;
	}
}
