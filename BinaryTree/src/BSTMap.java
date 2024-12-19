package src;

import java.util.ArrayList;
import java.util.LinkedList;

/**
* Your implementation of the BST class
*
* @author YOUR NAME HERE
*
* Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
*
* Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
*/

import java.util.List;

public class BSTMap<K extends Comparable<? super K>, V> {
	private BSTMapNode<K, V> root;

	/**
	 * Specifies the current version of the BST map. Useful to determine whether the
	 * class's iterator may be used.
	 */
	protected int versionNumberBSTmap;
	/**
	 * Counter variable detailing the size of the BST map.
	 */
	private int BSTsize;

	/**
	 * Sorted map which stores the statistics provided by {@link #calculateStats()}
	 */

	/**
	 * This constructor initializes an empty BST.
	 *
	 * There is no need to do anything for the constructor.
	 */
	public BSTMap() {
// DO NOT IMPLEMENT THIS CONSTRUCTOR!
	}

//TODO 1
	/**
	 * Returns the value associated with a given key.
	 *
	 * Traverse the tree to find the appropriate location. If the key is in the
	 * tree, then return its value. Otherwise return null.
	 *
	 * Time Complexity: O(log n)
	 *
	 * @param key the key to search for
	 * @return the value associated with key if key is in the tree, null otherwise
	 * @throws java.lang.IllegalArgumentException if key is null
	 */
	public V get(K key) {
		if (root == null)
			return null; // Empty root returns a null value
		else {
			// Call helper method to recursively find node
			BSTMapNode<K, V> result = dig(key, root);
			// Return the value of the node if it's not null
			if (result != null)
				return result.value;
			else
				return null;
		}
	}

	/**
	 * Helper method for {@link #get(K)} to recursively search through nodes of the
	 * BST.
	 * <p>
	 * If the key corresponds to an existing node N, return N.
	 * 
	 * @param digKey generic key which implements Comparable.
	 * @param N      initially corresponds to the root of the BST, but defined by
	 *               recursive calls as subtrees of the BST.
	 * @return the node if it was successfully found. Otherwise, null.
	 */
	private BSTMapNode<K, V> dig(K digKey, BSTMapNode<K, V> N) {
		// If the node is null do not attempt to traverse through it!
		if (N == null)
			return null;

		// Return the found key if it corresponds to that provided by the parameter
		int ct = digKey.compareTo(N.key);
		if (ct == 0)
			return N;

		// Nodes corresponding to greater keys will fall to the current's right
		// (lower-valued keys fall to the left)
		else if (ct > 0)
			return dig(digKey, N.right);
		else
			return dig(digKey, N.left);
	}

//TODO 2
	/**
	 * Adds a new entry to the tree or updates the value of an existing key in the
	 * tree
	 *
	 * Traverse the tree to find the appropriate location. If the key is already in
	 * the tree, then update its value to the new value. Otherwise create a new node
	 * consisting the new (key, value) pair and add it to the tree. The new node
	 * becomes a leaf. Then go back up the tree from the new leaf to the root. Upon
	 * seeing an imbalanced node on the path, balance it with proper rotations.
	 * Update the height, balance factor and the new size instance variable of every
	 * affected node.
	 *
	 * This method is essentially the same as its counterpart in SimpleBST.
	 * Therefore you can use the code for put(), its helper method putHelper() and
	 * the helper's helpers - balance(), rotateLeft(), rotateRight(), update() and
	 * height(), from the SimpleBST class. The only new items you need to
	 * incorporate are the following: 1. Modify the code properly to handle the
	 * generic types K and V for the key and value. 2. Provide the code for
	 * rotateLeft() which mirrors rotateRight(). You can get lots of help from Slide
	 * 33 for the BST lectures when completing this method. 3. In update(), update
	 * the size instance variable of a BST node in addition to height and balance
	 * factor. You need to think of the relation between the size of a node and the
	 * sizes of its left and right children, and how to define the size of a null
	 * node. 4. Handle the exceptions properly.
	 *
	 * Time Complexity: O(log n)
	 *
	 * @param key   the key of the entry to add or update
	 * @param value the value associated with key
	 * @throws java.lang.IllegalArgumentException if key or value is null
	 */
	public void put(K key, V value) {

		// If the BST is empty set up the root
		if (root == null) {
			root = new BSTMapNode<K, V>(key, value, null, null, null);
			BSTsize++;
			versionNumberBSTmap++;
		} else {
			// Rely on the recursive add method
			boolean added = add(key, value, root);
			// Keep track of the version of the BST
			if (added) {
				versionNumberBSTmap++;
			}
		}
	}

	/**
	 * Helper method for {@link #put(K, V)} to recursively add nodes to the BST.
	 * <p>
	 * If the new key corresponds to an existing node, update its value.
	 * 
	 * @param addKey   generic key which implements Comparable.
	 * @param addValue generic value.
	 * @param N        initially corresponds to the root of the BST, but defined by
	 *                 recursive calls as subtrees of the BST.
	 * @return true if successfully added or updated, false if not.
	 */
	private boolean add(K addKey, V addValue, BSTMapNode<K, V> N) {
		// Compare the comparable keys
		int ct = addKey.compareTo(N.key);
		// There shall be no repeats so do nothing if they're the same
		if (ct != 0) {
			if (ct > 0) {
				if (N.right == null) {
					// Set the new node to the right of this one (remember to give it the parent)
					N.right = new BSTMapNode<K, V>(addKey, addValue, null, null, N);
					BSTsize++;
					return true;
				} else {
					// Recursive call with node to its right
					return add(addKey, addValue, N.right);
				}
			} else { // if (ct < 0)
				if (N.left == null) {
					// Set the new node to this one's left
					N.left = new BSTMapNode<K, V>(addKey, addValue, null, null, N);
					BSTsize++;
					return true;
				} else {
					// Recursive call with node to its left
					return add(addKey, addValue, N.left);
				}
			}
		} else if (ct == 0) {
			// Update the value!
			N.value = addValue;
			return true;
		} else {
			// Return false because it's not getting added!
			return false;
		}
	}

//TODO 3
	/**
	 * Traverses the tree by an in-order traversal Sorts data by key
	 *
	 * Time Complexity: O(n)
	 *
	 * @return a list consisting of all keys in the tree in the ascending order
	 */
	public List<K> inOrder() {
		List<K> list = new ArrayList<K>();
		inOrder(root, list);
		return list;
	}

	public void inOrder(BSTMapNode<K,V> node, List<K> list) {
		if (node != null) {
			inOrder(node.left, list);
			list.add(node.key);
			inOrder(node.right, list);
		}
	}

//TODO 4
	/**
	 * Finds and returns all keys in the tree in descending order
	 *
	 * Time Complexity: O(n)
	 *
	 * Note: You would NOT receive credit if you perform an in-order traversal of
	 * the tree and then reverse the returned list, as this is unnecessary. Instead
	 * your method should directly obtain the list of all keys in descending order.
	 *
	 * Hint: Modify in-order traversal by changing the order in which the nodes are
	 * visited.
	 * 
	 * @param list2
	 * @param root2
	 *
	 * @return the list of all keys in the tree in descending order
	 */
	public List<K> reverseOrder() {
		List<K> list = new ArrayList<K>();
		reverseOrder(root, list);
		return list;
	}

	public void reverseOrder(BSTMapNode<K, V> node, List<K> list) {
		if (node != null) {
			list.add(node.key);
			reverseOrder(node.left, list);
			reverseOrder(node.right, list);
		}
	}

//TODO 5
	/**
	 * Finds and returns the k smallest keys in ascending order
	 *
	 * Ex: For the following BST
	 *
	 * 50 / \ 25 75 / \ / \ 12 37 70 80 / \ \ \ 10 15 40 85 / 13
	 *
	 * kSmallest(0) should return the list [] kSmallest(5) should return the list
	 * [10, 12, 13, 15, 25] kSmallest(3) should return the list [10, 12, 13]
	 * kSmallest(20) should cause java.lang.IllegalArgumentException to be thrown
	 *
	 * Time Complexity: O(log n + k)
	 *
	 * Note: The required time complexity does NOT allow you to perform an in-order
	 * traversal on the entire tree and then return the k smallest keys. Instead you
	 * should only traverse the branches of the tree necessary to get the data you
	 * need.
	 *
	 * @param k the number of smallest keys to find
	 * @return the list of k smallest keys in ascending order
	 * @throws java.lang.IllegalArgumentException if k < 0 or k > the size of the
	 *                                            tree
	 */
	public List<K> kSmallest(int k) {
		List<K> result = new ArrayList<K>();
        dfs(root, k, result);
        return result;
    }
	
    private void dfs(BSTMapNode<K, V> root, int k, List<K> result) {
        if(result.size() == k) {
            return;
        }
        if(root.left != null) {
            dfs(root.left, k, result);
        }
        result.add(root.key);
        if(root.right != null) {
            dfs(root.right, k, result);
        }
	}

	/**
	 * Returns the root of the tree.
	 *
	 * For grading purposes only.
	 *
	 * @return the root of the tree
	 */
	public BSTMapNode<K, V> getRoot() {
// DO NOT MODIFY THIS METHOD!
		return root;
	}

}
