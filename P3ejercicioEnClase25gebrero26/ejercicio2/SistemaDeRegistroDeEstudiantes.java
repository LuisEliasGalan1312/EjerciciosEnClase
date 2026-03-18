package ejercicio2;

import java.io.*;
import java.util.*;

class Estudiante implements Serializable {
    String nombre;
    String matricula;
    double promedio;

    public Estudiante(String nombre, String matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + " Nombre: " + nombre + " Promedio: " + promedio;
    }
}

public class SistemaDeRegistroDeEstudiantes {
    private static final String ARCHIVO = "estudiantes.dat";
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatos();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- REGISTRO DE ESTUDIANTES ---");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Listar Todos");
            System.out.println("3. Buscar por Matricula");
            System.out.println("4. Salir");
            System.out.print("Eligue una opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Matrícula: "); String mat = sc.nextLine();
                    System.out.print("Promedio: "); double prom = sc.nextDouble();
                    listaEstudiantes.add(new Estudiante(nom, mat, prom));
                    guardarDatos();
                    break;
                case 2:
                    System.out.println("\n--- LISTADO ---");
                    for (Estudiante e : listaEstudiantes) System.out.println(e);
                    break;
                case 3:
                    System.out.print("Introduce la matrícula a buscar: ");
                    String buscarMat = sc.nextLine();
                    buscarConRandomAccess(buscarMat);
                    break;
            }
        } while (opcion != 4);
    }

    private static void guardarDatos() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
            oos.writeObject(listaEstudiantes);
            System.out.println("Datos guardados.");
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        }
    }

    private static void cargarDatos() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO));
            listaEstudiantes = (List<Estudiante>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error raro al cargar los datos.");
        }
    }

    private static void buscarConRandomAccess(String matricula) {
        try {
            RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "r");
            System.out.println("Buscando en el archivo binario...");
            
            boolean encontrado = false;
            for (Estudiante e : listaEstudiantes) {
                if (e.matricula.equalsIgnoreCase(matricula)) {
                    System.out.println("archivo encontrado: " + e);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) System.out.println("Ese estudiante no aparece.");
            raf.close();
        } catch (Exception e) {
            System.out.println("Error en la busqueda.");
        }
    }
}