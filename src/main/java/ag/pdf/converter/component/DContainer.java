package ag.pdf.converter.component;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.layout.element.IBlockElement;

import ag.pdf.converter.model.WContainer;
import ag.pdf.converter.model.WText;
import ag.pdf.converter.model.Widget;

public class DContainer extends AbstractDWidget implements DWidget {
	
	private List<DWidget> dWidgets;

	public DContainer(Widget widget) {
		super(widget);
	}

	@Override
	public void accept(DocumentWidgetVisitor documentWidgetVisitor) {
		dWidgets = convertToDWidgets(getWidget());
		
	      for (DWidget dWidgetItem : dWidgets) {
	    	  dWidgetItem.accept(documentWidgetVisitor);
	       }
//	      documentWidgetVisitor.visit(this);
	}
	
	private List<DWidget> convertToDWidgets(Widget widget) {
		List<DWidget> widgets = new ArrayList<>();
		
		 for (Widget contentItem : ((WContainer) widget).getContent()) {
			 if(contentItem instanceof WText) {
				 widgets.add(new DText(contentItem));
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
		for (DWidget dWidgetItem : dWidgets) {
			elements.add(dWidgetItem.getIElement());
		}
		return elements;
	}
}
