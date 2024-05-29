#include <iostream>
#include <stdlib.h>

using namespace std;

class Circle {
public:
    float radius;
    Circle* left;
    Circle* right;

    // Constructor
    Circle(float r) {
        radius = r;
        left = NULL;
        right = NULL;
    }

    // Display function for circle object
    void display() {
        cout << "Circle with radius " << radius << endl;
    }
};

class BinaryTree {
public:
    Circle* root;

    // Constructor
    BinaryTree() {
        root = NULL;
    }

    // Insert function
    void insert(float r) {
        Circle* newCircle = new Circle(r);

        if (root == NULL) {
            root = newCircle;
        } else {
            Circle* current = root;
            while (true) {
                if (r < current->radius) {
                    if (current->left == NULL) {
                        current->left = newCircle;
                        break;
                    } else {
                        current = current->left;
                    }
                } else {
                    if (current->right == NULL) {
                        current->right = newCircle;
                        break;
                    } else {
                        current = current->right;
                    }
                }
            }
        }

        cout << "Circle with radius " << r << " added to Binary Tree." << endl;
    }

    // Search function
    void search(float r) {
        Circle* current = root;
        bool found = false;
        while (current != NULL) {
            if (r == current->radius) {
                found = true;
                break;
            } else if (r < current->radius) {
                current = current->left;
            } else {
                current = current->right;
            }
        }

        if (found) {
            current->display();
        } else {
            cout << "Circle with radius " << r << " not found in Binary Tree." << endl;
        }
    }

    // Preorder traversal function
    void preorder(Circle* current) {
        if (current != NULL) {
            current->display();
            preorder(current->left);
            preorder(current->right);
        }
    }

    // Inorder traversal function
    void inorder(Circle* current) {
        if (current != NULL) {
            inorder(current->left);
            current->display();
            inorder(current->right);
        }
    }

    // Postorder traversal function
    void postorder(Circle* current) {
        if (current != NULL) {
            postorder(current->left);
            postorder(current->right);
            current->display();
        }
    }

    // Find the minimum value node
    Circle* minValueNode(Circle* node) {
        Circle* current = node;
        while (current && current->left != NULL) {
            current = current->left;
        }
        return current;
    }

    // Delete node function
    Circle* deleteNode(Circle* root, float r) {
        if (root == NULL) {
            return root;
        }

        if (r < root->radius) {
            root->left = deleteNode(root->left, r);
        } else if (r > root->radius) {
            root->right = deleteNode(root->right, r);
        } else {
            if (root->left == NULL) {
                Circle* temp = root->right;
                delete root;
                return temp;
            } else if (root->right == NULL) {
                Circle* temp = root->left;
                delete root;
                return temp;
            }

            Circle* temp = minValueNode(root->right);
                        root->radius = temp->radius;
            root->right = deleteNode(root->right, temp->radius);
        }

        return root;
    }
};

int main() {
    BinaryTree binaryTree;
    int choice;
    float radius;

    do {
        
         cout << "\nMenu:";
         cout << "\n1. Add Circle Object to Binary Tree";
         cout << "\n2. Search for Circle Object in Binary Tree";
         cout << "\n3. Display all Binary Tree Circle Objects (preorder traversal)";
         cout << "\n4. Display all Binary Tree Circle Objects (inorder traversal)";
         cout << "\n5. Display all Binary Tree Circle Objects (postorder traversal)";
         cout << "\n6. Delete a Node";
         cout << "\n7. Exit";
         cout << "\nEnter your choice: ";
       
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter radius of Circle: ";
            cin >> radius;
            binaryTree.insert(radius);
            break;
        case 2:
            cout << "Enter radius of Circle to search: ";
            cin >> radius;
            binaryTree.search(radius);
            break;
        case 3:
            binaryTree.preorder(binaryTree.root);
            break;
        case 4:
            binaryTree.inorder(binaryTree.root);
            break;
        case 5:
            binaryTree.postorder(binaryTree.root);
            break;
        case 6:
            cout << "Enter radius of Circle to delete: ";
            cin >> radius;
            binaryTree.root = binaryTree.deleteNode(binaryTree.root, radius);
            cout << "Circle with radius " << radius << " has been deleted." << endl;
            break;
        case 7:
            exit(0);
            break;
        default:
            cout << "Invalid choice." << endl;
            break;
        }
    } while (true);

    return 0;
}






/*
STEP 1 : Circle class definition:
The Circle class has three attributes - radius (a float), left (a Circle*), and right (a Circle*). It also has a constructor and a display() method.
class Circle {
public:
    float radius;
    Circle* left;
    Circle* right;

    Circle(float r) {
        radius = r;
        left = NULL;
        right = NULL;
    }

    void display() {
        cout << "Circle with radius " << radius << endl;
    }
};



STEP 2: BinaryTree class definition:

The BinaryTree class has one attribute - root (a Circle*), which is the root of the tree. It has several methods for inserting, searching, traversals (preorder, inorder, postorder), and deleting a node.
class BinaryTree {
public:
    Circle* root;
    // Constructor and other methods
};



STEP 3: BinaryTree class methods:

a. insert(float r) - Inserts a new Circle object with the specified radius into the Binary Tree.
b. search(float r) - Searches for a Circle object with the specified radius in the Binary Tree.
c. preorder(Circle* current) - Performs a preorder traversal of the Binary Tree.
d. inorder(Circle* current) - Performs an inorder traversal of the Binary Tree.
e. postorder(Circle* current) - Performs a postorder traversal of the Binary Tree.
f. minValueNode(Circle* node) - Finds the Circle object with the minimum radius value in the given subtree.
g. deleteNode(Circle* root, float r) - Deletes the Circle object with the specified radius from the Binary Tree.

STEP 4 : main() function:

a. Declare a BinaryTree object.
BinaryTree binaryTree;

b. Declare variables for user input (choice and radius).
int choice;
float radius;

c. Implement a do-while loop to display the menu and process user choices.
do {
    // Display the menu and prompt the user to enter their choice
    cin >> choice;

    // Process the user's choice using a switch statement
} while (true);


Step 5 : User choice processing:

a. case 1: Add a Circle object to the Binary Tree
cout << "Enter radius of Circle: ";
cin >> radius;
binaryTree.insert(radius);

b. case 2: Search for a Circle object in the Binary Tree.
cout << "Enter radius of Circle to search: ";
cin >> radius;
binaryTree.search(radius);

c. case 3: Display all Binary Tree Circle objects using preorder traversal.
binaryTree.preorder(binaryTree.root);

d. case 4: Display all Binary Tree Circle objects using inorder traversal.
binaryTree.inorder(binaryTree.root);

e. case 5: Display all Binary Tree Circle objects using postorder traversal.
binaryTree.postorder(binaryTree.root);

f. case 6: Delete a node (Circle object) from the Binary Tree.
cout << "Enter radius of Circle to delete: ";
cin >> radius;
binaryTree.root = binaryTree.deleteNode(binaryTree.root, radius);
cout << "Circle with radius " << radius << " has been deleted." << endl;

g. case 7: Exit the program.
exit(0);

h. default: Handle invalid choices
cout << "Invalid choice." << endl;

*/
