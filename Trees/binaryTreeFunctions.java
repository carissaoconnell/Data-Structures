// Binary Tree with the functions to Insert, Traverse, Delete and Search
// elements into the circle class with the radius

import java.util.*;

		// circle class for circle elements
		class Circle {
		    private double radius;

		    // method to get the value of the radius
		    public double getRadius() {
		        return radius;
		    }
		    
		    // constructor that takes in parameter radius
		    public Circle(double radius) {
		        this.radius = radius; // initialize variable radius with the parameter radius
		    }

		    // method to return string representation of circle object
		    public String toString() {
		        return "Circle radius " + radius; 
		    }   
		} // end Circle class

		
		// Node class
		class TreeNode {
		    Circle circle; // declare instance variable of type circle 
		    TreeNode left; // declare instance variable of type node for left node
		    TreeNode right; // declare instance variable of type node for right node

		    // constructor for Circle
		    public TreeNode(Circle circle) {
		        this.circle = circle; //initialize instance variable circle with parameter
		        left = null; // set left node to null
		        right = null; // set right node to null
		    }
		} // end Node class

		
		// Binary Tree class
		class BinaryTree {
		    TreeNode root; // declare instance variable of node as root
		    TreeNode temp;
		    TreeNode successor;

		    public BinaryTree() {
		        root = null; // set root to null
		    }
		    
		    // insert circle object to binary tree
		    // public method to insert circle object
		    public void insert(Circle circle) {
		        root = insert(root, circle); // call the private method insert with node and circle and assign to root
		    }

		    // private method to insert Circle object
		    private TreeNode insert(TreeNode node, Circle circle) {
		        // if the root is null, then create a new node with circle parameter and assign it to the root
		    	if (node == null) {
		            node = new TreeNode(circle);
		        } 
		        
		    	// otherwise, if there is a value in the root
		        else {
		        	// check if the circle radius is less than or equal to root.circle.radius
		            if (circle.getRadius() <= node.circle.getRadius()) {
		            	// assign circle radius to left node
		                node.left = insert(node.left, circle);
		            } 
		            // circle radius is greater than root.circle radius
		            else {
		            	// assign circle radius to right node
		                node.right = insert(node.right, circle);
		            }
		        }
		        return node; // return root
		    } // end insert method

		    
		    // public method to search for circle object in the binary tree
		    public boolean search(Circle circle) {
		        return search(root, circle); // call private method search with the parameters root and circle, then return the result
		    }

		    // private search method that takes in the root node and circle parameter
		    private boolean search(TreeNode node, Circle circle) {
		        // if the root node is empty or null, return false - it is not in the tree
		    	if (node == null) {
		            return false;
		        }
		    	// if the node.circle.radius is equal to circle.radius, return true - it is in the tree
		        if (node.circle.getRadius() == circle.getRadius()) {
		            return true;
		        } 
		        // otherwise, if the circle.radius is less than the node.circle.radius, return left node
		        else if (circle.getRadius() < node.circle.getRadius()) {
		            return search(node.left, circle);
		        } 
		        // otherwise, return right node
		        else {
		            return search(node.right, circle);
		        }
		    } // end search method

		    
		    // public method to print elements in the binary tree using Inorder
		    public void displayInorder() {
		    	displayInorder(root);
		    }

		    // inorder traversal to display objects in binary tree
		    private void displayInorder(TreeNode node) {
		    	// if the root is not null
		        if (node != null) {
		        	// traverse the left subtree
		        	displayInorder(node.left);
		        	// display node 
		            System.out.println(node.circle);
		            // traverse right subtree
		            displayInorder(node.right);
		        }
		    } // end displayInorder method


			 // public method to print all elements in the binary tree using Preorder
			public void displayPreorder() {
				displayPreorder(root);
			}

    		// preorder traversal to display objects in binary tree
    		private void displayPreorder(TreeNode node) {
        		if (node == null)
        			return;
					// first print data of node 
					System.out.println(node.circle);
					// then recur on left subtree
					displayPreorder(node.left);
					// now recur on right subtree
					displayPreorder(node.right);
    		} //end displayPreorder method


			 // public method to print all elements in the binary tree using Postorder
			public void displayPostorder() {
				displayPostorder(root);
			}

			// postorder traversal to display objects in binary tree
			private void displayPostorder(TreeNode node) {
		    	// if the root is not null
		        if (node != null) {
		        	// first recur on left subtree
		        	displayPostorder(node.left);
					// then recur on right subtree
		        	displayPostorder(node.right);
					// print data of node
		            System.out.println(node.circle);
				}
			} // end displayPostorder method
			
		 
		    // public method to delete node
			// delete method takes in circle object
		    public void delete(Circle circle) {
		        root = deleteRadius(root, circle); // call the private method delete (with node and circle) and assign to root
		    }

		    // private method to delete node
		    private TreeNode deleteRadius(TreeNode node, Circle circle) {
		        // if the root is null, then create a new node with circle parameter and assign it to the root
		    	if (node == null) {
		            return node;
		        } 
		        
		    	// otherwise, if there is a value in the root
		    	// check if the circle radius is less than or equal to root.circle.radius
		        if (circle.getRadius() < node.circle.getRadius()) {
	            	// assign circle radius to left node
	                node.left = deleteRadius(node.left, circle);
		        }
		        // circle radius is greater than root.circle radius
		         else if (circle.getRadius() > node.circle.getRadius()) {
		            // assign circle radius to right node
		            node.right = deleteRadius(node.right, circle);
		         }
		        
		         else {
		        	 if (node.left == null || node.right == null) {
		        		 temp = null;
		        		 temp = node.left != null ? node.left : node.right;
		        	 
		        	 		if(temp == null) {
		        	 			return null;
		        	 		}
		        	 		else {
		        	 			return temp;
		        	 		}
		        	 }
		        	 	
		        	 else {
		        		 successor = getSuccessor(node);
		        		 node.circle = successor.circle ;
		        		 
		        		 node.right = deleteRadius(node.right, successor.circle);
		        		 return node;
		        	 }
		         }
		        return node;
		    } // end delete method
		        	
		    
		    public TreeNode getSuccessor(TreeNode node) {
		        if(node == null) {
		            return null;
		        }
		            
		        temp = node.right;
		        
	            while(temp.left != null) {
		          temp = temp.left;
		        }
		        return temp;
		    } // end getSuccessor method
		    
		} // end Binary Tree class

		
		public class binaryTreeFunctions {
			// main method
		    public static void main(String[] args) {
		        Scanner userInput = new Scanner(System.in); // declare scanner object
		        BinaryTree tree = new BinaryTree(); // create binary tree as tree
		        int choice = 0;

		        do {
		        	// display menu
		        	System.out.println();
		            System.out.println("1. Add radius to Binary Tree");
		            System.out.println("2. Search for radius in Binary Tree");
		            System.out.println("3. Display all radiuses (preorder traversal)");
		            System.out.println("4. Display all radiuses (inorder traversal)");
		            System.out.println("5. Display all radiuses (postorder traversal)");
		            System.out.println("6. Delete a Node");
		            System.out.println("7. Exit");
		            System.out.print("Enter your choice: ");
		            choice = userInput.nextInt(); // assign user input as the choice for the item on the menu

		            switch (choice) {
		            	// choice 1 - Add radius to Binary Tree
		                case 1:
		                    System.out.print("Enter the radius of the circle: ");
		                    int radius = userInput.nextInt(); 
		                    tree.insert(new Circle(radius)); // call insert method taking in the radius parameter
		                    break;

		                // choice 2 - Search for radius in Binary Tree
		                case 2:
		                    System.out.print("Enter the radius of the circle to search: ");
		                    radius = userInput.nextInt();
		                    Circle searchCircle = new Circle(radius); 
		                    boolean found = tree.search(searchCircle);
		                    if (found) {
		                        System.out.println("Radius is found in the Binary Tree.");
		                    } 
		                    else {
		                        System.out.println("Radius is not found in the Binary Tree.");
		                    }
		                    break;

		                // choice 3 - Display all radiuses using preorder traversal
		                case 3:
		                    System.out.println("Binary Tree Circle Objects:");
		                    tree.displayPreorder(); // call displayPreorder method 
		                    break;
		                    
			             // choice 4 - Display all radiuses using inorder traversal
			             case 4:
			                 System.out.println("Binary Tree Circle Objects:");
			                 tree.displayInorder(); // call displayInorder method 
			                 break;
			                 
				          // choice 5 - Display all radiuses using postorder traversal
				          case 5:
				              System.out.println("Binary Tree Circle Objects:");
				              tree.displayPostorder(); // call displayPostorder method 
				              break;
		                   
				          // choice 6 - Delete a Node (radius)
				          case 6:
				        	  System.out.print("Enter the radius you would like to delete: ");
			                  radius = userInput.nextInt(); // take in user input
			                  tree.delete(new Circle(radius)); // call the delete method which takes in the radius from circle class
				        	  System.out.println("Radius " + radius + " has been deleted");
				        	  break;
				              
		                // choice 7 - Exit
		                case 7:
		                    System.out.println("Exiting program");
		                    break; // exit the program

		                default:
		                    System.out.println("Sorry, that option is not available. Please make another choice.");
		            }
		        } 
		        
		        while (choice != 7); // continue to all the user to use the menu until they choose to exit by entering 7

		        userInput.close(); // close scanner
		    }
		}