package ag.pdf.converter.descriptor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "widget")
@JsonSubTypes({ 
	@Type(value = ContainerDescriptor.class, name = "container"),
	@Type(value = TextDescriptor.class, name = "text")})
public abstract class Descriptor {

	private String widget;
	
	protected Descriptor(String widget) {
		this.widget = widget;
	}

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}
}
