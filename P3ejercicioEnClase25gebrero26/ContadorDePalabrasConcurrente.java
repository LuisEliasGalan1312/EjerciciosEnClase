import java.io.*;

public class ContadorDePalabrasConcurrente {
    public static void main(String[] args) {
        Resultado resultadoGlobal = new Resultado();
        long inicio = System.currentTimeMillis();

        String rutaBase ="C:\\Users\\luise\\OneDrive\\Documentos\\Problema";

        Hilos h1 = new Hilos(rutaBase + "texto1", resultadoGlobal);
        Hilos h2 = new Hilos(rutaBase + "texto2", resultadoGlobal);
        Hilos h3 = new Hilos(rutaBase + "texto3", resultadoGlobal);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        generarReporte(resultadoGlobal, (fin - inicio));
    }

    private static void generarReporte(Resultado res, long tiempo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("estadisticas.txt"))) {
            writer.println("========================================");
            writer.println("REPORTE DE PROCESAMIENTO DE ARCHIVOS");
            writer.println("========================================");
            for (String detalle : res.getDetalles()) {
                writer.println(detalle);
            }
            writer.println("----------------------------------------");
            writer.println("Total de palabras procesadas: " + res.getTotalGeneral());
            writer.println("Tiempo de procesamiento: " + tiempo + " ms");
            writer.println("========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}