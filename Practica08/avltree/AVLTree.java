package Practica08.avltree;
 
import Practica08.bstree.BSTree;
import Practica08.bstree.Node;
import Practica08.exceptions.ItemDuplicated;
import Practica08.exceptions.ItemNotFound;
 
public class AVLTree<E extends Comparable<E>> extends BSTree<E> { 
    private boolean height;
    public AVLTree() {
        super();
        this.height = false;
    }
    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        root = insertAVL(x, (NodeAVL<E>) this.root);
    }
    private NodeAVL<E> insertAVL(E x, NodeAVL<E> node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL<>(x);
        }
        int cmp = x.compareTo(node.getData());
        if (cmp == 0) {
            throw new ItemDuplicated(x + " ya existe en el árbol AVL.");
        }
        if (cmp > 0) {
            node.setRight(insertAVL(x, node.getRight()));
            if (this.height) {
                switch (node.bf) {
                    case -1:
                        node.bf     = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf     = 1;
                        this.height = true;
                        break;
                    case 1:
                        System.out.println("  [AVL] Desbalance DERECHA en nodo " + node.getData());
                        node        = balanceToLeft(node);
                        this.height = false;
                        break;
                }
            }
        } else {
            node.setLeft(insertAVL(x, node.getLeft()));
            if (this.height) {
                switch (node.bf) {
                    case 1:
                        node.bf     = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf     = -1;
                        this.height = true;
                        break;
                    case -1:
                        System.out.println("  [AVL] Desbalance IZQUIERDA en nodo " + node.getData());
                        node        = balanceToRight(node);
                        this.height = false;
                        break;
                }
            }
        }
        return node;
    }
    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> hijo = node.getRight();
        switch (hijo.bf) {
            case 1:
                System.out.println("  [AVL] Caso DD → RSL en nodo " + node.getData());
                node.bf = 0;
                hijo.bf = 0;
                node    = rotateSL(node);
                break;
            case -1:
                System.out.println("  [AVL] Caso DI → Rotación Doble en nodo " + node.getData());
                NodeAVL<E> nieto = hijo.getLeft();
                switch (nieto.bf) {
                    case -1: node.bf =  0; hijo.bf =  1; break;
                    case  0: node.bf =  0; hijo.bf =  0; break;
                    case  1: node.bf = -1; hijo.bf =  0; break;
                }
                nieto.bf = 0;
                node.setRight(rotateSR(hijo));
                node = rotateSL(node);
                break;
            case 0:
                node.bf     =  1;
                hijo.bf     = -1;
                node        = rotateSL(node);
                this.height = false;
                break;
        }
        return node;
    }
    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> hijo = node.getLeft();
        switch (hijo.bf) {
            case -1:
                System.out.println("  [AVL] Caso II → RSR en nodo " + node.getData());
                node.bf = 0;
                hijo.bf = 0;
                node    = rotateSR(node);
                break;
            case 1:
                System.out.println("  [AVL] Caso ID → Rotación Doble en nodo " + node.getData());
                NodeAVL<E> nieto = hijo.getRight();
                switch (nieto.bf) {
                    case  1: node.bf =  0; hijo.bf = -1; break;
                    case  0: node.bf =  0; hijo.bf =  0; break;
                    case -1: node.bf =  1; hijo.bf =  0; break;
                }
                nieto.bf = 0;
                node.setLeft(rotateSL(hijo));
                node = rotateSR(node);
                break;
            case 0:
                node.bf     = -1;
                hijo.bf     =  1;
                node        = rotateSR(node);
                this.height = false;
                break;
        }
        return node;
    }
    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        System.out.println("  [AVL] RSL en nodo " + node.getData());
        NodeAVL<E> p = node.getRight();
        node.setRight(p.getLeft());
        p.setLeft(node);
        return p;
    }
    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        System.out.println("  [AVL] RSR en nodo " + node.getData());
        NodeAVL<E> p = node.getLeft();
        node.setLeft(p.getRight());
        p.setRight(node);
        return p;
    }
    @Override
    public void delete(E x) throws ItemNotFound {
        this.height = false;
        root = deleteAVL(x, (NodeAVL<E>) root);
    }
    private NodeAVL<E> deleteAVL(E x, NodeAVL<E> node) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound(x + " no encontrado.");
        }
        int cmp = x.compareTo(node.getData());        
            node.setLeft(deleteAVL(x, node.getLeft()));
            if (this.height) {
                node = rebalanceAfterDeleteRight(node);
            }
        } else if (cmp > 0) {
            node.setRight(deleteAVL(x, node.getRight()));
            if (this.height) {
                node = rebalanceAfterDeleteLeft(node);
            }
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                this.height = true;
                return null;
            } else if (node.getLeft() == null) {
                this.height = true;
                return (NodeAVL<E>) node.getRight();
            } else if (node.getRight() == null) {
                this.height = true;
                return (NodeAVL<E>) node.getLeft(); 
            } else {
                NodeAVL<E> sucesor = (NodeAVL<E>) minNode(node.getRight());
                System.out.println("  [AVL] Sucesor inorden de "+ node.getData() + " → " + sucesor.getData());
                node.data = sucesor.getData();                
                node.setRight(deleteAVL(sucesor.getData(), node.getRight()));
                if (this.height) {
                    node = rebalanceAfterDeleteLeft(node);
                }
            }
        }
        return node;
    }
    private NodeAVL<E> rebalanceAfterDeleteLeft(NodeAVL<E> node) {
        switch (node.bf) {
            case -1:
                node.bf     = 0;
                this.height = true;
                break;
            case 0:
                node.bf     = 1;
                this.height = false;
                break;
            case 1:
                node = balanceToLeft(node);
                break;
        }
        return node;
    }
    private NodeAVL<E> rebalanceAfterDeleteRight(NodeAVL<E> node) {
        switch (node.bf) {
            case 1:
                node.bf     = 0;
                this.height = true;
                break;
            case 0:
                node.bf     = -1;
                this.height = false;
                break;
            case -1:
                node = balanceToRight(node);
                break;
        }
        return node;
    }
    @Override
    public void printTree() {
        System.out.println("Árbol AVL:");
        printAVL((NodeAVL<E>) root, "", true);
    }
    private void printAVL(NodeAVL<E> node, String prefix, boolean isRoot) {
        if (node != null) {
            System.out.println(prefix + (isRoot ? "└── " : "├── ") + node);
            if (node.getLeft() != null || node.getRight() != null) {
                printAVL(node.getLeft(),  prefix + "    ", false);
                printAVL(node.getRight(), prefix + "    ", false);
            }
        }
    }
    public void levelOrderAVL() {
        System.out.print("BFS (niveles): ");
        int alturaTotal = height();               
        for (int nivel = 0; nivel < alturaTotal; nivel++) {
            imprimirNivel((NodeAVL<E>) root, nivel);
        }
        System.out.println();
    }
    private void imprimirNivel(NodeAVL<E> node, int nivel) {
        if (node == null) {
            return;                               
        }
        if (nivel == 0) {
            System.out.print(node.getData() + " "); 
        } else {
            imprimirNivel(node.getLeft(),  nivel - 1);
            imprimirNivel(node.getRight(), nivel - 1);
        }
    }
    public void preOrderAVL() {
        System.out.print("PreOrden AVL: ");
        preOrdenRecursivo((NodeAVL<E>) root);
        System.out.println();
    }
    private void preOrdenRecursivo(NodeAVL<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " "); 
        preOrdenRecursivo(node.getLeft());       
        preOrdenRecursivo(node.getRight());      
    }
    public NodeAVL<E> getRoot() {
        return (NodeAVL<E>) root;
    }