public class HuffmanPrinter {
    public static void printTree(HuffmanNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + 
                (node.character == '\0' ? "*" : "'" + node.character + "'") + " (" + node.frequency + ")");

            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
