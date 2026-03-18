package ejercicio1;
import java.util.Random;

public class Cajero extends Thread {
    private String nombre;
    private Boveda boveda;
    private int conteoTransacciones = 0;

    public Cajero(String nombre, Boveda boveda) {
        super(nombre);
        this.nombre = nombre;
        this.boveda = boveda;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int clientes = rand.nextInt(3) + 3;

        for (int i = 0; i < clientes; i++) {
            try {
                int monto = rand.nextInt(1501) + 500;
                boveda.retirar(monto);
                conteoTransacciones++;
                
                Thread.sleep((rand.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha terminado.");
    }

    public int getConteoTransacciones() {
        return conteoTransacciones;
    }
}