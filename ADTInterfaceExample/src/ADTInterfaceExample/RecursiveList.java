package ADTInterfaceExample;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

	protected int numElements;
	protected Node<T> list;

	@Override
	public void add(T newEntry) {
		add(1, newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if (newPosition < 0 || newPosition > numElements + 1)
			throw new IndexOutOfBoundsException();
		if (newEntry == null)
			throw new NullPointerException();
		Node<T> nn = new Node<T>(newEntry);
		if (newPosition == 1) {
			nn.setLink(list);
			list = nn;
		} else
			insertHelper(list, newPosition, nn);
		numElements++;
	}

	private void insertHelper(Node<T> curr, int newPosition, Node<T> nn) {
		if (newPosition == 1) {
			nn.setLink(curr.getLink());
			curr.setLink(nn);
		} else
			insertHelper(curr.getLink(), newPosition - 1, nn);
	}

	@Override
	public T remove(int givenPosition) {
		if (givenPosition < 1 || givenPosition >= numElements)
			throw new IndexOutOfBoundsException();
		T elem;
		if (givenPosition == 1) {
			elem = list.getInfo();
			list = list.getLink();
		} else
			elem = removeHelper(list, givenPosition);
		numElements--;
		return elem;
	}

	private T removeHelper(Node<T> curr, int i) {
		if (i == 2) {
			T elem = curr.getLink().getInfo();
			curr.setLink(curr.getLink().getLink());
			return elem;
		}
		return removeHelper(curr.getLink(), i - 1);
	}

	@Override
	public void clear() {
		for(int i=1;i<=numElements;i++) {
		remove(i);
		}
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if (givenPosition < 1 || givenPosition > numElements)
			throw new IndexOutOfBoundsException();
		if (newEntry == null)
			throw new NullPointerException();
		Node<T> nn = new Node<T>(newEntry);
		T elem;
		if (givenPosition == 1) {
			nn.setLink(list);
			list = nn;
			elem=nn.getInfo();
		} else {
			elem=remove(givenPosition);
			add(givenPosition, newEntry);
		}
		return elem;
			
	}

	@Override
	public T getEntry(int givenPosition) {
		if (givenPosition < 1 || givenPosition > numElements)
			throw new IndexOutOfBoundsException();
		return getHelper(list, givenPosition);
	}

	private T getHelper(Node<T> curr, int i) {
		if (i == 1)
			return curr.getInfo();
		return getHelper(curr.getLink(), i - 1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[numElements+1];
		Node<T> curr=list.getLink();
		for(int i=1;i<=numElements;i++) {
			result[i]=getEntry(i);
		}
		return result;
		
	}

	@Override
	public boolean contains(T anEntry) {
		int index = indexOf(anEntry);
		if (index == -1)
			return false;
		return true;
	}

	public int indexOf(T elem) {
		if (elem == null)
			throw new NullPointerException();
		return indexOf(elem, list, 1);
	}

	private int indexOf(T toFind, Node<T> toCheck, int currentIndex) {
		if (toCheck == null)
			return -1;
		if (toCheck.getInfo().equals(toFind))
			return currentIndex;
		return indexOf(toFind, toCheck.getLink(), currentIndex + 1);
	}

	@Override
	public int getLength() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return list == null;
	}

}
