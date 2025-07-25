import java.io.FileWriter;
import java.io.IOException;

public class FileExporter {
    public void save(String content, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Archivo guardado: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
