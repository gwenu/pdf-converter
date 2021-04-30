package ag.pdf.converter.model;

import ag.pdf.converter.util.json.JsonConst;

public class Text extends Widget {
	
	private String value;
	private Style style;
	
	public Text() {
		super(JsonConst.Value.TEXT);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}
}
