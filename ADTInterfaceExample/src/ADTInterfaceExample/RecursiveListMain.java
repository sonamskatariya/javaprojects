package ADTInterfaceExample;

public class RecursiveListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListInterface<String> list= new RecursiveList<String>();
		System.out.println("IS Empty  "+list.isEmpty());
		System.out.println("Size  "+list.getLength());
		list.add("First");
		list.add("Second");
		list.add("Third");
		System.out.println("IS Empty  "+list.isEmpty());
		System.out.println("Size After adding element  "+list.getLength());
		list.remove(1);
		System.out.println("Size After removing element  "+list.getLength());
		list.replace(1, "Sonam");
		System.out.println(list.getEntry(1));
		
	}

}
