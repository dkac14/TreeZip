import java.util.*;

public class HuffmanTreeBuilder {
    public HuffmanNode buildTree(Map<Character, Integer> freqMap, StringBuilder explanation) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));

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

        return pq.poll();
    }
}
