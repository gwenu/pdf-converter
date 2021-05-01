package ag.pdf.converter.component;

import java.util.ArrayList;
import java.util.List;

import ag.pdf.converter.descriptor.ContainerDescriptor;
import com.itextpdf.layout.element.IBlockElement;

import ag.pdf.converter.descriptor.TextDescriptor;
import ag.pdf.converter.descriptor.Descriptor;
import com.itextpdf.layout.element.IElement;

public class ContainerComponent implements Component {

	private ContainerDescriptor descriptor;
	private IElement element;
	private List<Component> components;

	public ContainerComponent(ContainerDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void accept(ComponentVisitor componentVisitor) {
		components = convertToDWidgets(this.descriptor);
		
	      for (Component componentItem : components) {
	    	  componentItem.accept(componentVisitor);
	       }
//	      documentWidgetVisitor.visit(this);
	}
	
	private List<Component> convertToDWidgets(ContainerDescriptor containerDescriptor) {
		List<Component> widgets = new ArrayList<>();
		
		 for (Descriptor descriptor : containerDescriptor.getContent()) {
			 if(descriptor instanceof TextDescriptor) {
				 widgets.add(new TextComponent((TextDescriptor) descriptor));
			 }
		 }
		return widgets;
	}

	@Override
	public IBlockElement getIElement() {
		return null;
	}
	
	public List<IBlockElement> retriveIElements() {
		List<IBlockElement> elements = new ArrayList<>();

		for (Component componentItem : components) {
			elements.add(componentItem.getIElement());
		}
		return elements;
	}
}
