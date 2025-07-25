import java.util.Map;

public class HuffmanExplainer {
    public String explain(String input, Map<Character, String> codes, String encoded) {
        StringBuilder sb = new StringBuilder("Hola humano. Vamos a comprimir tu texto:\n\n");
        sb.append("Frecuencia de códigos:\n");
        codes.forEach((ch, code) -> sb.append("  '").append(ch).append("' → ").append(code).append("\n"));
        sb.append("\nTexto codificado: ").append(encoded);
        return sb.toString();
    }
}
