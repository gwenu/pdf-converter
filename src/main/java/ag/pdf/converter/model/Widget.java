package ag.pdf.converter.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "widget")
@JsonSubTypes({ 
	@Type(value = WContainer.class, name = "container"),
	@Type(value = WText.class, name = "text")})
public abstract class Widget {

	private String widget;
	
	protected Widget(String widget) {
		this.widget = widget;
	}

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}
}
