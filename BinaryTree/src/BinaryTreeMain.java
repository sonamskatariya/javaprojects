package src;

import java.util.Iterator;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		//make root is built into overloaded constructor
				BinaryTree<String> a = new BinaryTree<String>("A");
				BinaryTree<String> left = new BinaryTree<String>("B");
				BinaryTree<String> right = new BinaryTree<String>("C");
				//BinaryTree<String> tree = new BinaryTree<String>("D",left,right);
				
				BinaryTree<Integer> tree = new BinaryTree<Integer>();
		        tree.root = new BinaryNode(10);
		        tree.root.leftChild = new BinaryNode(8);
		        tree.root.rightChild = new BinaryNode(2);
		        tree.root.leftChild.leftChild = new BinaryNode(3);
		        tree.root.leftChild.rightChild = new BinaryNode(5);
		        tree.root.rightChild.leftChild = new BinaryNode(2);

				// Obtain an interator for traversing 
				// the elements in the BST in preorder
				Iterator<Integer> iterator = tree.getPreorderIterator();

				// Traverse all the strings in the tree 
				System.out.println("PreOrder Traversal");
				while (iterator.hasNext())
				System.out.println(iterator.next() + " ");
				System.out.println();
				
				System.out.println(tree.count1(tree));
				
				// Obtain an interator for traversing 
				// the elements in the BST in preorder
				Iterator<Integer> inOrderiterator = tree.getInorderIterator();

				// Traverse all the strings in the tree 
				System.out.println("InOrder Traversal");
				while (inOrderiterator.hasNext())
				System.out.println(inOrderiterator.next() + " ");
				System.out.println();
				
				System.out.println("Copying the tree");
				BinaryNode<Integer> newRoot=tree.root.copy();
				
				BinaryTree<Integer> newTree = new BinaryTree<Integer>();
				newTree.root = new BinaryNode(10);
				newTree.root.leftChild = new BinaryNode(8);
				newTree.root.rightChild = new BinaryNode(2);
				newTree.root.leftChild.leftChild = new BinaryNode(3);
				newTree.root.leftChild.rightChild = new BinaryNode(5);
				newTree.root.rightChild.leftChild = new BinaryNode(2);

		
	}

}
