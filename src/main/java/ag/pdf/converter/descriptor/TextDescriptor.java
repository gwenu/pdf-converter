package ag.pdf.converter.descriptor;

import ag.pdf.converter.util.json.JsonConst;

public class TextDescriptor extends Descriptor {
	
	private String value;
	private StyleDescriptor styleDescriptor;
	
	public TextDescriptor() {
		super(JsonConst.Value.TEXT);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public StyleDescriptor getStyle() {
		return styleDescriptor;
	}

	public void setStyle(StyleDescriptor styleDescriptor) {
		this.styleDescriptor = styleDescriptor;
	}
}
