public class HuffmanNode {
    public char character;
    public int frequency;
    public HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
