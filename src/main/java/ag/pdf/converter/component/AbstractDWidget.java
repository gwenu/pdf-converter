package ag.pdf.converter.component;

import com.itextpdf.layout.element.IElement;

import ag.pdf.converter.model.Widget;

public abstract class AbstractDWidget {
	
	private Widget widget;
	private IElement element;
	
	public AbstractDWidget(Widget widget) {
		this.widget = widget;
	}

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	public IElement getElement() {
		return element;
	}

	public void setElement(IElement element) {
		this.element = element;
	}
}
