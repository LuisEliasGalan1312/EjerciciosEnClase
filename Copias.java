public class Copias {

    public void ejecutar() {
        System.out.println("\n--- Copia de Arrays ---");

        int[] original = {10, 20, 30, 40, 50};

        int[] copia = original.clone();

        copia[0] = 777;

        System.out.print("Array Original: ");
        imprimir(original);

        System.out.print("Array Copia (modificado): ");
        imprimir(copia);
    }

    private void imprimir(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println();
    }
}