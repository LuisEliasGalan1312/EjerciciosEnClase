public class Referencias {

    public void ejecutar() {
        int[] arreglo1 = { 45, 12, 89, 33, 27, 5, 68 };
        
        System.out.print("Arreglo original: ");
        imprimir(arreglo1);

        int[] arreglo2 = arreglo1;

        arreglo2[0] = 999;

        System.out.print("Arreglo 1 tras modificar el 2: ");
        imprimir(arreglo1);
        System.out.println(" Ambos cambian ");

        ordenarBurbuja(arreglo1);
        System.out.print("Arreglo ordenado: ");
        imprimir(arreglo1);

        int buscado = 33;
        int resultado = busquedaBinaria(arreglo1, buscado, 0, arreglo1.length - 1);
        
        if (resultado != -1) {
            System.out.println(" El " + buscado + " esta en el indice " + resultado);
        } else {
            System.out.println(" No se encontro el valor.");
        }
    }

    public void ordenarBurbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int busquedaBinaria(int[] arreglo, int valorBuscado, int inf, int sup) {
        if (sup < inf) return -1;
        int centro = (inf + sup) / 2;
        if (arreglo[centro] == valorBuscado) return centro;
        else if (valorBuscado > arreglo[centro])
            return busquedaBinaria(arreglo, valorBuscado, centro + 1, sup);
        else
            return busquedaBinaria(arreglo, valorBuscado, inf, centro - 1);
    }
    

    private void imprimir(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println();
    }
}