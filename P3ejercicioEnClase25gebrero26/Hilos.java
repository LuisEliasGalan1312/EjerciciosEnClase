import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hilos extends Thread {
    private final String nombreArchivo;
    private final Resultado resultado;

    public Hilos(String nombreArchivo, Resultado resultado) {
        this.nombreArchivo = nombreArchivo;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        int contador = 0;
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            while (sc.hasNext()) {
                sc.next();
                contador++;
            }
            resultado.acumular(nombreArchivo, contador);
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + nombreArchivo);
        }
    }
}