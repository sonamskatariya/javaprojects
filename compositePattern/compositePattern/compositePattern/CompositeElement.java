package compositePattern;

import java.util.ArrayList;

public class CompositeElement extends DrawingElement {
	private String name;
	public String getName() { return name;}
	public CompositeElement(String name) {this.name = name;}
	public void Add(DrawingElement d) {elements.add(d);};
	public void Remove(DrawingElement d) {
		for (int i = 0; i< elements.size(); i++) {
			if (elements.get(i).getName() == d.getName()) {
				elements.remove(i);
				return;
			}
		}
	}
	public	void Display(int indent) {
		for(int i = 1;i <= indent;i++) System.out.print("-");
		System.out.println( "+ " + getName());

		// Display each child element on this node
		for (int i= 0; i< elements.size(); i++) {
			elements.get(i).Display(indent+2);
		}
	}
	private	ArrayList<DrawingElement> elements = new ArrayList<DrawingElement>();
}