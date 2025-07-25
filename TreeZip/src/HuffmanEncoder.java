import java.util.*;
import java.io.*;

public class HuffmanEncoder {
    private Map<Character, String> huffmanCodes = new HashMap<>();
    private StringBuilder explanation = new StringBuilder();
    private HuffmanNode root;

    public void buildHuffmanTree(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        explanation.append("Paso 1: Conteo de frecuencias\n");
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            explanation.append(" - '" + entry.getKey() + "' → " + entry.getValue() + "\n");
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        explanation.append("\nPaso 2: Construcción del árbol de Huffman\n");
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            pq.offer(parent);
            explanation.append(" - Nodo combinado con frecuencia " + parent.frequency + " ("
                    + left.frequency + " + " + right.frequency + ")\n");
        }

        root = pq.poll();
        explanation.append("\nPaso 3: Generación de códigos de Huffman\n");
        generateCodes(root, "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
            explanation.append(" - '" + node.character + "' → " + code + "\n");
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(huffmanCodes.get(c));
        }
        return encoded.toString();
    }

    public String getExplanation() {
        return explanation.toString();
    }

    public HuffmanNode getRoot() {
        return root;
    }

    public Map<Character, String> getCodes() {
        return huffmanCodes;
    }

      public void saveToFile(String encodedText, String filePath) throws IOException {
    FileWriter writer = new FileWriter(filePath);
    writer.write(encodedText);
    writer.close();
}
}

