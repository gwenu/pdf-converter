package ag.pdf.converter.descriptor;

import java.util.ArrayList;
import java.util.List;

import ag.pdf.converter.util.json.JsonConst;

public class ContainerDescriptor extends Descriptor {
	
	private List<Descriptor> content = new ArrayList<>();
	
	public ContainerDescriptor() {
		super(JsonConst.Value.CONTAINER);
	}

	public List<Descriptor> getContent() {
		return content;
	}
	
	public void addContent(Descriptor descriptor) {
		content.add(descriptor);
	}
}
