public class Main {
    public static void main(String[] args) throws Exception {
        String texto = "amor uwu";
        HuffmanEncoder encoder = new HuffmanEncoder();
        encoder.build(texto);

        String codificado = encoder.encode(texto);

        // Mostrar explicación paso a paso
        System.out.println("📖 Proceso detallado:\n");
        PasoAPasoExplicador.mostrar(encoder.getExplanation(), 250);

        // Mostrar árbol
        System.out.println("\n🌳 Árbol de Huffman (visual):\n");
        HuffmanPrinter.printTree(encoder.getRoot(), "", false);

        // Mostrar códigos
        System.out.println("\n📘 Tabla de códigos generados:\n");
        for (var entry : encoder.getCodes().entrySet()) {
            System.out.println(" - '" + entry.getKey() + "' → " + entry.getValue());
        }

        // Mostrar resultados de codificación
        int originalBits = texto.length() * 8;
        int codificadoBits = codificado.length();

        System.out.println("\n📊 Comparación de tamaños:");
        System.out.println(" - Tamaño original: " + texto.length() + " caracteres × 8 bits = " + originalBits + " bits");
        System.out.println(" - Tamaño codificado: " + codificado.length() + " bits");

        int ahorro = originalBits - codificadoBits;
        double porcentaje = (ahorro * 100.0) / originalBits;

        System.out.printf(" - Ahorro: %d bits (%.2f%%)\n", ahorro, porcentaje);

        // Justificación
        System.out.println("\n🧠 Justificación:");
        System.out.println("Huffman logra compresión porque asigna códigos más cortos a los caracteres más frecuentes.");
        System.out.println("En este caso, los caracteres 'u' y 'o', que se repiten, tienen códigos más cortos.");
        System.out.println("Los caracteres raros (como 'a' o 'w') reciben códigos más largos.");
        System.out.println("Eso reduce el tamaño total del texto codificado.");
    }
}
