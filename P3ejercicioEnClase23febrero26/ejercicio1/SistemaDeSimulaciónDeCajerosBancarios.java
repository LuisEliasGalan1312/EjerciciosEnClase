package ejercicio1;
public class SistemaDeSimulaciónDeCajerosBancarios {
    public static void main(String[] args) {
        Boveda bovedaReal = new Boveda();

        Cajero c1 = new Cajero("Cajero - 1", bovedaReal);
        Cajero c2 = new Cajero("Cajero - 2", bovedaReal);
        Cajero c3 = new Cajero("Cajero - 3", bovedaReal);

        Thread monitor = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Saldo en boveda: $" + bovedaReal.getSaldo());
                } catch (InterruptedException e) { break; }
            }
        });

        monitor.start();

        c1.start();
        c2.start();
        c3.start();

        System.out.println("\n===== Banco =====");
        System.out.println(" Transacion C1: " + c1.getConteoTransacciones());
        System.out.println("Transacion C2: " + c2.getConteoTransacciones());
        System.out.println("Transaciona C3: " + c3.getConteoTransacciones());
        System.out.println("Saldo Final: $" + bovedaReal.getSaldo());
    }
}