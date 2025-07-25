import java.io.FileWriter;
import java.io.IOException;

public class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }

}
