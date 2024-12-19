package compositePattern;

public class CompositePattern {
	
	public static void main(String[] args) {
		
		// Create a tree structure
		DrawingElement root = new CompositeElement("Picture");
		root.Add(new PrimitiveElement("Red Line"));
		root.Add(new PrimitiveElement("Blue Circle"));
		root.Add(new PrimitiveElement("Green Box"));

		DrawingElement comp = new CompositeElement("Two Circles");
		comp.Add(new PrimitiveElement("Black Circle"));
		comp.Add(new PrimitiveElement("White Circle"));
		root.Add(comp);

		// Add and remove a PrimitiveElement
		DrawingElement pe = new PrimitiveElement("Yellow Line");
		pe.Add(new PrimitiveElement("Red Line"));
		root.Add(pe);
		root.Remove(pe);

		// Recursively display nodes
		root.Display(1);
	}

}
