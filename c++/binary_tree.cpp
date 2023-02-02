#include<iostream>
using namespace std;
class Node {
public:
    int data;
    Node* left;
    Node* right;
    Node(int data) {
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }

};
class Tree {
public:
    Node* root;
    Tree() {
        root = nullptr;
    }
    void addNode(int data) {
        Node* newNode = new Node(data);
        if(root == nullptr) {
            root = newNode;
        }
        else {
            Node* focusNode = root;
            Node* parent;
            while(true) {
                parent = focusNode;
                if(data < focusNode->data) {
                    focusNode = focusNode->left;
                    if(focusNode == nullptr) {
                        parent->left = newNode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode->right;
                    if(focusNode == nullptr) {
                        parent->right = newNode;
                        return;
                    }
                }
            }
        }
    }
    void preOrderTraversal(Node* focusNode) {
        if(focusNode == nullptr) {
            return;
        }
        cout << focusNode->data << "\t";
        preOrderTraversal(focusNode->left);
        preOrderTraversal(focusNode->right); 
    }
};
int main() {
    Tree* tree = new Tree();
    tree->addNode(50);
    tree->addNode(25);
    tree->addNode(75);
    tree->addNode(12);
    tree->addNode(37);
    tree->addNode(43);
    tree->addNode(30);
    tree->preOrderTraversal(tree->root);
    return 0;
}
