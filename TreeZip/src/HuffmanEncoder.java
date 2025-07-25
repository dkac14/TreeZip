import java.util.*;

public class HuffmanEncoder {
    private Map<Character, String> codes = new HashMap<>();
    private Node root;
    private List<String> steps = new ArrayList<>();

    public void build(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        steps.add("Frecuencias de caracteres:");
        for (var entry : freqMap.entrySet()) {
            steps.add("  '" + entry.getKey() + "' : " + entry.getValue());
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));
        for (var entry : freqMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        steps.add("\nConstrucción del árbol de Huffman:");
        int step = 1;
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            queue.add(parent);
            steps.add("Paso " + step++ + ": combinamos '" + 
                (left.character == '\0' ? "◼" : left.character) + "' (" + left.frequency + 
                ") + '" + (right.character == '\0' ? "◼" : right.character) + "' (" + right.frequency + 
                ") → nuevo nodo (" + parent.frequency + ")");
        }

        root = queue.poll();
        buildCodes(root, "");
    }

    private void buildCodes(Node node, String code) {
        if (node == null) return;
        if (node.isLeaf()) {
            codes.put(node.character, code);
        }
        buildCodes(node.left, code + "0");
        buildCodes(node.right, code + "1");
    }

    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(codes.get(c));
        }
        return sb.toString();
    }

    public String explain(String input) {
        StringBuilder sb = new StringBuilder("Hola, soy TreeZip. Vamos a codificar tu texto paso a paso:\n\n");

        for (String s : steps) {
            sb.append(s).append("\n");
        }

        sb.append("\nTabla de códigos:\n");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            sb.append("  '").append(entry.getKey()).append("' → ").append(entry.getValue()).append("\n");
        }

        sb.append("\nTexto original: ").append(input).append("\n");
        sb.append("Codificado: ").append(encode(input));

        return sb.toString();
    }

    public Map<Character, String> getCodes() {
        return codes;
    }
}
