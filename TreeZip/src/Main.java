import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HuffmanEncoder encoder = new HuffmanEncoder();
        FileExporter exporter = new FileExporter();

        System.out.print("Ingrese un texto: ");
        String input = scanner.nextLine();

        encoder.build(input);

        // Mostrar explicación detallada paso a paso
        String explanation = encoder.explain(input);
        System.out.println("\n--- PROCESO DE HUFFMAN ---\n");
        System.out.println(explanation);

        // Guardar solo el texto codificado
        String encoded = encoder.encode(input);
        exporter.save(encoded, "resultado_codificado.txt");
    }
}
