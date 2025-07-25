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

        steps.add("Paso 1: Frecuencias de caracteres:");
        for (var entry : freqMap.entrySet()) {
            steps.add("  '" + entry.getKey() + "' : " + entry.getValue());
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));
        for (var entry : freqMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        steps.add("\nPaso 2: Construcción del árbol de Huffman:");
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
                    ") → nuevo nodo (" + parent.frequency + ", nodo " + parent.id + ")");
        }

        root = queue.poll();
        steps.add("\nPaso 3: Generación de códigos binarios:");
        buildCodes(root, "", root.id);
    }

    private void buildCodes(Node node, String code, int nodoId) {
        if (node == null)
            return;

        if (node.isLeaf()) {
            codes.put(node.character, code);
            steps.add("  -> Nodo hoja: '" + node.character + "' = código: " + code);
        } else {
            if (node.left != null) {
                steps.add("  Descendemos por la izquierda por el nodo " + node.id + " agregamos '0' a "
                        + leftMostChar(node.left));
                buildCodes(node.left, code + "0", node.left.id);
            }
            if (node.right != null) {
                steps.add("  Descendemos por la derecha por el nodo " + node.id + " agregamos '1' a "
                        + rightMostChar(node.right));
                buildCodes(node.right, code + "1", node.right.id);
            }
        }
    }

    private String leftMostChar(Node node) {
        while (node != null && !node.isLeaf())
            node = node.left;
        return node != null ? ("'" + node.character + "'") : "◼";
    }

    private String rightMostChar(Node node) {
        while (node != null && !node.isLeaf())
            node = node.right;
        return node != null ? ("'" + node.character + "'") : "◼";
    }

    public String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(codes.get(c));
        }
        return sb.toString();
    }

    public Node getRoot() {
        return root;
    }

    public Map<Character, String> getCodes() {
        return codes;
    }

    public List<String> getSteps() {
        return steps;
    }
}