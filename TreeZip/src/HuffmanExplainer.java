import java.util.*;

public class HuffmanExplainer {
    public void explain(List<String> steps, long delayMs) throws InterruptedException {
        for (String line : steps) {
            System.out.println(line);
            Thread.sleep(delayMs);
        }
    }

    public void explainTree(Node node, String prefix, boolean isLeft, long delayMs) throws InterruptedException {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") +
                    (node.character == '\0' ? "◼" : "'" + node.character + "'") + " (" + node.frequency + ", nodo "
                    + node.id + ")");
            Thread.sleep(delayMs);
            explainTree(node.left, prefix + (isLeft ? "│   " : "    "), true, delayMs);
            explainTree(node.right, prefix + (isLeft ? "│   " : "    "), false, delayMs);
        }
    }
}