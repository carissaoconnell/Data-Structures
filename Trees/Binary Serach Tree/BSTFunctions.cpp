#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>

using namespace std;

// Circle object with radius and color
class Circle {
public:
    double radius;

    Circle(double r) : radius(r) {}
};

// Binary Search Tree node with Circle object and pointers to left and right child
class TreeNode {
public:
    Circle* circle;
    TreeNode* left;
    TreeNode* right;

    TreeNode(Circle* c) : circle(c), left(NULL), right(NULL) {}
};

// Binary Search Tree class with insertion, search, traversal and deletion operations
class BinarySearchTree {
private:
    TreeNode* root;

    // recursive helper function for insertion operation
    TreeNode* insertHelper(TreeNode* node, Circle* circle) {
        if (node == NULL) {
            node = new TreeNode(circle);
        } else if (circle->radius < node->circle->radius) {
            node->left = insertHelper(node->left, circle);
        } else {
            node->right = insertHelper(node->right, circle);
        }
        return node;
    }

    // recursive helper function for search operation
    TreeNode* searchHelper(TreeNode* node, double radius) {
        if (node == NULL || node->circle->radius == radius) {
            return node;
        } else if (radius < node->circle->radius) {
            return searchHelper(node->left, radius);
        } else {
            return searchHelper(node->right, radius);
        }
    }

    // recursive helper function for preorder traversal operation
    void preorderHelper(TreeNode* node) {
        if (node != NULL) {
            cout << node->circle->radius << " ";
            preorderHelper(node->left);
            preorderHelper(node->right);
        }
    }

    // recursive helper function for inorder traversal operation
    void inorderHelper(TreeNode* node) {
        if (node != NULL) {
            inorderHelper(node->left);
            cout << node->circle->radius << " ";
            inorderHelper(node->right);
        }
    }

    // recursive helper function for postorder traversal operation
    void postorderHelper(TreeNode* node) {
        if (node != NULL) {
            postorderHelper(node->left);
            postorderHelper(node->right);
            cout << node->circle->radius << " ";
        }
    }

    // recursive helper function for deletion operation
    TreeNode* deleteHelper(TreeNode* node, double radius) {
        if (node == NULL) {
            return NULL;
        } else if (radius < node->circle->radius) {
            node->left = deleteHelper(node->left, radius);
        } else if (radius > node->circle->radius) {
            node->right = deleteHelper(node->right, radius);
        } else {
            // node to be deleted has no child or only one child
            if (node->left == NULL) {
                TreeNode* temp = node->right;
                delete node;
                return temp;
            } else if (node->right == NULL) {
                TreeNode* temp = node->left;
                delete node;
                return temp;
            }
            // node to be deleted has two children
            TreeNode* temp = minValueNode(node->right);
            node->circle = temp->circle;
            node->right = deleteHelper(node->right, temp->circle->radius);
        }
        return node;
    }

    // helper function to find node with minimum value in a subtree
    TreeNode* minValueNode(TreeNode* node) {
        TreeNode     * current = node;

    while (current && current->left != NULL) {
        current = current->left;
    }
    return current;
}
public:
BinarySearchTree() : root(NULL) {}
// public method to insert a Circle object into the binary tree
void insert(double radius) {
    Circle* circle = new Circle(radius);
    root = insertHelper(root, circle);
}

// public method to search for a Circle object in the binary tree
TreeNode* search(double radius) {
    return searchHelper(root, radius);
}

// public method to perform preorder traversal of the binary tree
void preorder() {
    preorderHelper(root);
}

// public method to perform inorder traversal of the binary tree
void inorder() {
    inorderHelper(root);
}

// public method to perform postorder traversal of the binary tree
void postorder() {
    postorderHelper(root);
}

// public method to delete a Circle object from the binary tree
void deleteNode(double radius) {
    root = deleteHelper(root, radius);
}
};

// function to display menu and handle user input
void displayMenu(BinarySearchTree& binaryTree) {
int choice;
double radius;

while (true) {
    cout << endl;
    cout << "Binary Tree of Circle Objects" << endl;
    cout << "1. Add Circle Object" << endl;
    cout << "2. Search for Circle Object" << endl;
    cout << "3. Display All Circle Objects (preorder traversal)" << endl;
    cout << "4. Display All Circle Objects (inorder traversal)" << endl;
    cout << "5. Display All Circle Objects (postorder traversal)" << endl;
    cout << "6. Delete a Circle Object" << endl;
    cout << "7. Exit" << endl;
    cout << "Enter your choice: ";
    cin >> choice;

    switch (choice) {
        case 1:
            cout << "Enter the radius of the Circle: ";
            cin >> radius;
            binaryTree.insert(radius);
            break;

        case 2:
            cout << "Enter the radius of the Circle to search: ";
            cin >> radius;
            if (binaryTree.search(radius) == NULL) {
                cout << "Circle not found" << endl;
            } else {
                cout << "Circle found" << endl;
            }
            break;

        case 3:
            cout << "All Circle Objects (preorder traversal): ";
            binaryTree.preorder();
            cout << endl;
            break;

        case 4:
            cout << "All Circle Objects (inorder traversal): ";
            binaryTree.inorder();
            cout << endl;
            break;

        case 5:
            cout << "All Circle Objects (postorder traversal): ";
            binaryTree.postorder();
            cout << endl;
            break;

        case 6:
            cout << "Enter the radius of the Circle to delete: ";
            cin >> radius;
            binaryTree.deleteNode(radius);
            break;

        case 7:
            cout << "Exiting the program..." << endl;
            exit(0);

        default:
            cout << "Invalid choice" << endl;
            break;
    }
}
}

// main function to create a binary tree of Circle objects and display the menu
int main() {
BinarySearchTree binaryTree;
displayMenu(binaryTree);
return 0;
}