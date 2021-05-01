package ag.pdf.converter.validation;

import ag.pdf.converter.descriptor.Descriptor;
import org.springframework.util.Assert;

public class WidgetValidator {
	
	public static <T extends Descriptor> void validate(Descriptor descriptor) {
		Assert.notNull(descriptor, "Widget must not be null");
	}
}
