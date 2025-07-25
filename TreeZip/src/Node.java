public class Node {
    char character;
    int frequency;
    Node left, right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
