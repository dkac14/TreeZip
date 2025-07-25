import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el texto a codificar: ");
        String texto = scanner.nextLine();

        HuffmanEncoder encoder = new HuffmanEncoder();
        encoder.build(texto);
        String codificado = encoder.encode(texto);

        HuffmanExplainer explainer = new HuffmanExplainer();

        System.out.println("\nIniciamos la codificación Huffman del texto: \"" + texto + "\"\n");
        explainer.explain(encoder.getSteps(), 250);

        System.out.println("\nÁrbol de Huffman:\n");
        explainer.explainTree(encoder.getRoot(), "", false, 250);

        System.out.println("\nTabla de códigos:");
        for (var entry : encoder.getCodes().entrySet()) {
            System.out.println("  '" + entry.getKey() + "' → " + entry.getValue());
            Thread.sleep(250);
        }

        int originalBits = texto.length() * 8;
        int compressedBits = codificado.length();

        System.out.println("\nComparación de tamaños:");
        System.out.println(" - Tamaño original: " + originalBits + " bits");
        System.out.println(" - Tamaño codificado: " + compressedBits + " bits");
        System.out.printf(" - Ahorro: %d bits (%.2f%%)\n", (originalBits - compressedBits),
                (originalBits - compressedBits) * 100.0 / originalBits);

        System.out.println("\nJustificación:");
        System.out.println("Huffman reduce el tamaño asignando menos bits a caracteres más frecuentes.");
        System.out.println("Así se logra comprimir el texto sin perder información. \n");
    }
}