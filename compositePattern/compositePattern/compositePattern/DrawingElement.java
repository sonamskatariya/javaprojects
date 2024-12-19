package compositePattern;

import java.util.ArrayList;
import java.util.List;

public abstract class DrawingElement {
	public void Add(DrawingElement d) {
	}
	public void Remove(DrawingElement d) {
	}
	public void Display(int indent) {
	}
	public abstract String getName();

	//Accessor to the children of this Component
		public List<DrawingElement> getChildren(){
			return new ArrayList<DrawingElement>();
		}
}
