package ag.pdf.converter.validation;

import org.springframework.util.Assert;

import ag.pdf.converter.model.Widget;

public class WidgetValidator {
	
	public static <T extends Widget> void validate(Widget widget) {
		Assert.notNull(widget, "Widget must not be null");
	}
}
