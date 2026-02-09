import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegistroReservas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Reserva> listaReservas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        String opcion = "";

        while (!opcion.equals("0")) {
            System.out.println("\n --- Menu ---");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Mostrar reservas");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextLine();

            try {
                if (opcion.equals("1")) {
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Fecha (dd/MM/yyyy): ");
                    String fechaStr = sc.nextLine();
                    
                    Date fecha;
                    try {
                        fecha = sdf.parse(fechaStr);
                    } catch (ParseException e) {
                        throw new ReservaInvalidaException("Formato de fecha incorrecto. Use dd/MM/yyyy.");
                    }

                    System.out.print("Cantidad de personas: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    listaReservas.add(new Reserva(nombre, fecha, cantidad));
                    System.out.println("Reserva guardada.");

                } else if (opcion.equals("2")) {
                    if (listaReservas.isEmpty()) {
                        System.out.println("No hay reservas registradas.");
                    } else {
                        System.out.println("\n--- LISTADO DE RESERVAS ---");
                        for (Reserva r : listaReservas) {
                            System.out.println(r);
                        }
                    }
                }
            } catch (ReservaInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido para la cantidad.");
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado.");
            }
        }
        System.out.println("Programa finalizado.");
    }
}