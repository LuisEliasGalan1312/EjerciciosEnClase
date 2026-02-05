import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Programación 3 ---");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo con Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("0. Salir");
            System.out.print("Introduce una opción: ");
            
            opcion = sn.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("Ejecutando 1...");
                    break;
                case 2:
                    System.out.println("Ejecutando 2...");

                    break;
                case 3:
                    System.out.println("\n--- [Ejercicio 3: Ocultamiento de Atributos] ---");
                    A objeto = new B();
                    System.out.println("Valor de x: " + objeto.x);
                    break;
                case 4:
                    System.out.println("Ejecutando 4...");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        } while(opcion != 0);

        sn.close();
    }
}

class A {
    int x = 10;
}

class B extends A {
    int x = 20;
}