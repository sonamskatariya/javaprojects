package compositePattern;

public class PrimitiveElement extends DrawingElement {
	private String name;
	public String getName() { return name;}
	public PrimitiveElement(String name) {this.name = name;}
	public void Add(DrawingElement c) {
		System.out.println("Cannot add to a PrimitiveElement.");
	}
	public void Remove(DrawingElement c) {
		System.out.println("Cannot remove from a PrimitiveElement.");
	}
	public void Display(int indent) {
		for(int i = 1;i <= indent;i++) 	System.out.print("-");
		System.out.println(" " + name);
	}
}
