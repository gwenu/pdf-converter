package ag.pdf.converter.service;

import ag.pdf.converter.component.ContainerComponent;
import ag.pdf.converter.component.ComponentVisitor;
import ag.pdf.converter.descriptor.ContainerDescriptor;
import com.itextpdf.layout.element.IBlockElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptorParser {
	
	public List<IBlockElement> parse(ContainerDescriptor containerDescriptor) {
		ContainerComponent containerComponent = new ContainerComponent(containerDescriptor);
		containerComponent.accept(new ComponentVisitor());
		return containerComponent.retriveIElements();
	}
}
