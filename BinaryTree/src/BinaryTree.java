package src;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack; // for nodeStack


public class BinaryTree < T > {
        
        protected BinaryNode < T > root;
        
        public BinaryTree() {

                root = null;
        } // end default constructor

        public BinaryTree(T rootData) {

                root = new BinaryNode < T > (rootData);
        } // end constructor

        public BinaryTree(T rootData, BinaryTree < T > leftTree,

        BinaryTree < T > rightTree) {
                privateSetTree(rootData, leftTree, rightTree);
        } // end constructor

        public void setTree(T rootData) {

                root = new BinaryNode < T > (rootData);
        } // end setTree

        public void setTree(T rootData, BinaryTree < T > leftTree, BinaryTree < T > rightTree) {

                privateSetTree(rootData, leftTree, rightTree);
        } // end setTree

        private void privateSetTree(T rootData, BinaryTree < T > leftTree,

        BinaryTree < T > rightTree) {
                root = new BinaryNode < T > (rootData);
                if (leftTree != null) root.setLeftChild(leftTree.root);
                if (rightTree != null) root.setRightChild(rightTree.root);
                System.out.println("Setting the Tree");
        }
        
        public T getRootData() {

                T rootData = null;
                if (root != null) rootData = (T) root.getData();
                return rootData;
        }
        
        public boolean isEmpty() {
                return root == null;
        }
        
        public void clear() {
                root = null;
        }
        
        // getHeight and getNumberOfNodes call same functions in BinaryNode<T>
        public int getHeight() {
                return root.getHeight();
        }
        public int getNumberOfNodes() {
                return root.getNumberOfNodes();
        }

        // Runtime: O(n)
        public int count1(BinaryTree<Integer> tree) {
                return count1(root, tree);
        }

        private int count1(BinaryNode < T > rootNode, BinaryTree<Integer> anObject) {
                if (rootNode == null) {
                        return 0;
                }

                if (rootNode.getData().equals(anObject)) {
                        return 1;
                }

                return count1(rootNode.getLeftChild(), anObject) + count1(rootNode.getRightChild(),anObject);
        }

        //Runtime O(n)
        public int count2(T anObject) {
                InorderIterator iterator = new InorderIterator();
                int count = 0;
                while (iterator.hasNext() == true) {
                        if (iterator.next().equals(anObject))
                        count++;
                        }

                return count;
        }
        
        public boolean isIsomorphic(BinaryTree<T> otherTree) {
                BinaryNode thisRoot = root;
                return isIsomorphic(thisRoot, otherTree.root);  
        } //checks whether two binary trees have the same structure and the same values
        

		private boolean isIsomorphic(BinaryNode root1, BinaryNode root2) {
                boolean same = true;
                
                if((root1.getRightChild() == null && root1.getLeftChild() == null) && (root2.getRightChild() == null && root2.getLeftChild() == null))
                        return same;
                if(!root1.equals(root2))
                        same = false;
                
                return (isIsomorphic(root1.getRightChild(), root2.getRightChild()) == isIsomorphic(root1.getLeftChild(), root2.getLeftChild()) ? true:false);
                
        }

                
        public void inorderTraversal() {
                Stack < BinaryNode < T >> nodeStack = new Stack < BinaryNode < T >> ();
                BinaryNode < T > currentNode = root;

                while (!nodeStack.empty() || currentNode != null) {
                        while (currentNode != null) {
                                nodeStack.push(currentNode);
                                currentNode = currentNode.getLeftChild();
                        }
                        if (!nodeStack.empty()) {
                                BinaryNode < T > nextNode = nodeStack.pop();
                                System.out.println(nextNode.getData());
                                currentNode = nextNode.getRightChild();
                        }
                }
        }

        public Iterator < T > getPreorderIterator() {
                return new PreorderIterator();
        }

        public Iterator < T > getInorderIterator() {
                return new InorderIterator();
        }

        private class PreorderIterator implements Iterator < T > {
                private Stack < BinaryNode < T >> nodeStack;
                public PreorderIterator() {
                        nodeStack = new Stack < BinaryNode < T >> ();
                        if (root != null) {
                        	nodeStack.push(root);
                        }	
                } // end default constructor

                public boolean hasNext() {
                        return !nodeStack.isEmpty();
                } // end hasNext

                public T next() {
                        BinaryNode < T > nextNode;
                        if (hasNext()) {
                                nextNode = nodeStack.pop();
                                BinaryNode < T > leftChild = nextNode.getLeftChild();
                                BinaryNode < T > rightChild = nextNode.getRightChild();
                               
                                // push into stack in reverse order of recursive calls
                                if (rightChild != null) nodeStack.push(rightChild);

                                if (leftChild != null) nodeStack.push(leftChild);
                        } else { throw new NoSuchElementException();}
                
                        return nextNode.getData();
                } // end next

                public void remove() {
                        throw new UnsupportedOperationException();
                } // end remove
        } // end PreorderIterator

        private class InorderIterator implements Iterator < T > {
                private Stack < BinaryNode < T >> nodeStack;
                private BinaryNode < T > currentNode;
                public InorderIterator() {
                        nodeStack = new Stack < BinaryNode < T >> ();
                        currentNode = root;
                } // end default constructor

                public boolean hasNext() {
                        return !nodeStack.isEmpty() || (currentNode != null);
                } // end hasNext

                public T next() {
                        BinaryNode < T > nextNode = null;

                        // find leftmost node with no left child
                        while (currentNode != null) {
                                nodeStack.push(currentNode);
                                currentNode = currentNode.getLeftChild();
                        } // end while
                                // get leftmost node, then move to its right subtree
                        if (!nodeStack.isEmpty()) {
                                nextNode = nodeStack.pop();
                                currentNode = nextNode.getRightChild();
                        } else throw new NoSuchElementException();
                        return nextNode.getData();
                } // end next

                public void remove() {
                        throw new UnsupportedOperationException();
                } // end remove

        } // end InorderIterator



} // end BinaryTree