package ag.pdf.converter.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WContainer {
	
	public String widget;
	
	@JsonProperty(value = "content")
	private List<Widget> content = new ArrayList<>();

	public List<Widget> getContent() {
		return content;
	}
	
	public void addContent(Widget widget) {
		content.add(widget);
	}
}
