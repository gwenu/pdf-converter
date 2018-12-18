package ag.pdf.converter.model;

import java.util.ArrayList;
import java.util.List;

import ag.pdf.converter.util.json.JsonConst;

public class WContainer extends Widget {
	
	private List<Widget> content = new ArrayList<>();
	
	public WContainer() {
		super(JsonConst.Value.CONTAINER);
	}

	public List<Widget> getContent() {
		return content;
	}
	
	public void addContent(Widget widget) {
		content.add(widget);
	}
}
