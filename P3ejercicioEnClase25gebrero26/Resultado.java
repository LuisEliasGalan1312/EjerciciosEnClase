import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private int totalGeneral = 0;
    private final List<String> registros = new ArrayList<>();

    public synchronized void acumular(String archivo, int cantidad) {
        totalGeneral += cantidad;
        registros.add("Archivo: " + archivo + "\nPalabras encontradas: " + cantidad + "\n");
    }

    public int getTotalGeneral() { return totalGeneral; }
    public List<String> getDetalles() { return registros; }
}