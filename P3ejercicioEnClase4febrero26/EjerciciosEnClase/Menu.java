import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menu de Programacion 3 ---");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo con Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("5. Figuras Geometricas");
            System.out.println("6. Gestion de Productos");
            System.out.println("7. Inventario con Arrays de Objetos");
            System.out.println("8. Copia de Arrays");
            System.out.println("0. Salir");
            System.out.print("Seleciona una opcion: ");
            
            opcion = sn.nextInt();

            switch(opcion) {
                
                case 1:
                    System.out.println("\n--- Cuenta Bancaria ---");
                    CuentaBancaria cuenta = new CuentaBancaria("789-456", 1000.0);
                    cuenta.depositar(500.0);
                    System.out.println("Saldo actual: RD$ " + cuenta.getSaldo());
                    break;

                case 2:
                    System.out.println("\n--- Polimorfismo con Empleados ---");
                    Empleado emp1 = new EmpleadoFijo("Maria", 2500.0);
                    Empleado emp2 = new EmpleadoPorHora("Juan", 150.0, 40);
                    System.out.println("Salario Fijo: " + emp1.calcularSalario());
                    System.out.println("Salario por Hora: " + emp2.calcularSalario());
                    break;

                case 3:
                    OcultamientoAtributos ej3 = new OcultamientoAtributos();
                    ej3.ejecutar();
                    break;

                case 4:
                    System.out.println("\n--- Arrays y Referencias ---");
                    Referencias ej4 = new Referencias();
                    ej4.ejecutar();
                    break;

                case 5:
                    FigurasGeometricas ej5 = new FigurasGeometricas();
                    ej5.ejecutar();
                    break;

                case 6:
                    System.out.println("\n--- Gestion de Productos ---");
                    sn.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombreP = sn.nextLine();
                    System.out.print("Precio: ");
                    double precioP = sn.nextDouble();
                    System.out.print("Stock inicial: ");
                    int stockP = sn.nextInt();
                    
                    Producto p = new Producto(nombreP, precioP, stockP);
                    System.out.print("Cantidad a vender: ");
                    int cant = sn.nextInt();
                    p.vender(cant);
                    break;

                case 7:
                    Inventario ej7 = new Inventario();
                    ej7.ejecutar();
                    break;

                case 8:
                    Copias ej8 = new Copias();
                    ej8.ejecutar();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while(opcion != 0);

        sn.close();
    }
}