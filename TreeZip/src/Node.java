public class Node {
    static int counter = 1; // contador de nodos
    int id;
    char character;
    int frequency;
    Node left, right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.id = counter++;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}