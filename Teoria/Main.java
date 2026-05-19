// Clase que representa un nodo de un B+ Tree
class BPlusNode {
    int[] keys;          // Arreglo de claves en el nodo
    BPlusNode[] children; // Arreglo de hijos (solo para nodos internos)
    boolean isLeaf;      // Indica si es hoja
    int numKeys;         // Número actual de claves en el nodo
    BPlusNode next;      // Apunta al siguiente nodo hoja (para rangos)

    // Constructor del nodo
    BPlusNode(int t, boolean leaf) {
        keys = new int[2 * t - 1];      // Cada nodo puede tener máximo 2t - 1 claves
        children = new BPlusNode[2 * t]; // Máximo 2t hijos
        isLeaf = leaf;
        numKeys = 0;
        next = null;
    }
}

// Clase principal del B+ Tree
class BPlusTree {
    BPlusNode root; // Raíz del árbol
    int t;          // Grado mínimo del árbol

    // Constructor
    BPlusTree(int t) {
        root = new BPlusNode(t, true); // Inicialmente la raíz es una hoja
        this.t = t;
    }

    // Búsqueda de una clave en el árbol
    public BPlusNode search(int key, BPlusNode node) {
        int i = 0;
        // Avanza mientras la clave sea mayor que las claves del nodo
        while (i < node.numKeys && key > node.keys[i]) i++;

        // Si encontramos la clave, devolvemos el nodo
        if (i < node.numKeys && key == node.keys[i]) return node;

        // Si es hoja y no encontramos la clave, no existe
        if (node.isLeaf) return null;

        // Recurre al hijo correspondiente
        return search(key, node.children[i]);
    }

    // Inserción (simplificada para ejemplo)
    public void insert(int key) {
        BPlusNode r = root;
        if (r.numKeys == 2 * t - 1) { // Si la raíz está llena, se divide
            BPlusNode s = new BPlusNode(t, false);
            root = s;
            s.children[0] = r;
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    // Inserción en nodo que no está lleno
    private void insertNonFull(BPlusNode node, int key) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            // Desplaza claves para insertar la nueva
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            // Encuentra el hijo correcto
            while (i >= 0 && key < node.keys[i]) i--;
            i++;
            if (node.children[i].numKeys == 2 * t - 1) {
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) i++;
            }
            insertNonFull(node.children[i], key);
        }
    }

    // División de un hijo lleno
    private void splitChild(BPlusNode parent, int index, BPlusNode child) {
        BPlusNode newNode = new BPlusNode(t, child.isLeaf);
        newNode.numKeys = t - 1;

        // Copia las últimas t-1 claves al nuevo nodo
        for (int j = 0; j < t - 1; j++) {
            newNode.keys[j] = child.keys[j + t];
        }

        if (!child.isLeaf) {
            // Copia los hijos si no es hoja
            for (int j = 0; j < t; j++) {
                newNode.children[j] = child.children[j + t];
            }
        }

        child.numKeys = t - 1;

        // Ajusta los hijos del padre
        for (int j = parent.numKeys; j >= index + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }
        parent.children[index + 1] = newNode;

        // Inserta la clave central en el padre
        for (int j = parent.numKeys - 1; j >= index; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }
        parent.keys[index] = child.keys[t - 1];
        parent.numKeys++;

        // Ajusta punteros de hojas
        if (child.isLeaf) {
            newNode.next = child.next;
            child.next = newNode;
        }
    }

    // Mostrar claves de hoja secuencialmente
    public void printLeaves() {
        BPlusNode current = root;
        while (!current.isLeaf) current = current.children[0]; // Ir a la primera hoja

        System.out.print("Leaf nodes: ");
        while (current != null) {
            for (int i = 0; i < current.numKeys; i++) {
                System.out.print(current.keys[i] + " ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

// Clase para probar el árbol
public class Main {
    public static void main(String[] args) {
        BPlusTree tree = new BPlusTree(3); // Grado mínimo t=3
        int[] keys = {10, 20, 5, 6, 12, 30, 7, 17};

        // Insertar claves
        for (int key : keys) {
            tree.insert(key);
        }

        // Mostrar hojas enlazadas
        tree.printLeaves();

        // Buscar un valor
        int searchKey = 12;
        BPlusNode result = tree.search(searchKey, tree.root);
        if (result != null) {
            System.out.println("Clave " + searchKey + " encontrada.");
        } else {
            System.out.println("Clave " + searchKey + " NO encontrada.");
        }
    }
}