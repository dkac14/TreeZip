public class PasoAPasoExplicador {
    public static void mostrar(String texto, long delayMillis) throws InterruptedException {
        for (String linea : texto.split("\n")) {
            System.out.println(linea);
            Thread.sleep(delayMillis);
        }
    }
}
