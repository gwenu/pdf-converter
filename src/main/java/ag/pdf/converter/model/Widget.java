package ag.pdf.converter.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ag.pdf.converter.util.json.JsonConst;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = JsonConst.Key.WIDGET)
@JsonSubTypes({
    @Type(value = WText.class, name = JsonConst.Value.TEXT)
})
public abstract class Widget {
	
	private String widget;

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}
}
