import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 1. Texto de entrada
        String input = "este es un ejemplo del algoritmo de huffman";

        // 2. Instanciar el codificador de Huffman
        HuffmanEncoder encoder = new HuffmanEncoder();

        // 3. Construir el árbol y generar los códigos
        encoder.buildHuffmanTree(input);

        // 4. Codificar el texto
        String encodedText = encoder.encode(input);

        // 5. Mostrar la explicación tipo IA
        System.out.println("🧠 Explicación paso a paso del algoritmo de Huffman:\n");
        System.out.println(encoder.getExplanation());

        // 6. Mostrar el texto codificado
        System.out.println("\n🔐 Texto codificado:\n" + encodedText);

        // 7. Mostrar el árbol de Huffman en consola
        System.out.println("\n🌳 Árbol de Huffman:");
        printTree(encoder.getRoot(), "", false);

        // 8. Guardar resultado en un archivo
        try {
            String filePath = "resultado_huffman.txt";
            encoder.saveToFile(encodedText, filePath);
            System.out.println("\n✅ Archivo guardado en: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método auxiliar para imprimir el árbol
    public static void printTree(HuffmanNode node, String indent, boolean isLeft) {
        if (node != null) {
            System.out.println(indent + (isLeft ? "├── " : "└── ") +
                    (node.character == '\0' ? "*" : "'" + node.character + "'") + " (" + node.frequency + ")");
            printTree(node.left, indent + (isLeft ? "│   " : "    "), true);
            printTree(node.right, indent + (isLeft ? "│   " : "    "), false);
        }
    }
}
