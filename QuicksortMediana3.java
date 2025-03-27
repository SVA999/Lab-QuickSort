import java.util.Random;

public class QuicksortMediana3 {

    // Método principal para ordenar el array
    public static String quickSort(int[] lista, int ini, int fin) {

        // Si el subarray tiene más de un elemento
        if (ini < fin) {

            // De esta forma escogemos una posicion al azar dentro del vector
            int posicionRandom = new Random().nextInt(fin - ini) + ini;
            swap(lista, posicionRandom, fin);

            // Ubicamos el pivote en su posición correcta
            int posCorrectaPiv = ubicarPivote(lista, ini, fin);

            // Ordenamos recursivamente los elementos antes del pivote
            quickSort(lista, ini, posCorrectaPiv - 1);

            // Ordenamos recursivamente los elementos después del pivote
            quickSort(lista, posCorrectaPiv + 1, fin);

            return "El Arreglo ha sido ordenado";

        } else
            return "Arreglo vacio o de 1 dato";
    }

    // Método para ubicar el pivote en su posición correcta
    private static int ubicarPivote(int[] lista, int ini, int fin) {

        int pivot = MedianaDeTrees(lista, ini, fin);
        int i = ini - 1;

        for (int j = ini; j < fin; j++) {
            if (lista[j] <= pivot) {
                i++;
                swap(lista, i, j);
            }
        }

        swap(lista, i + 1, fin);
        return i + 1;
    }

    private static int MedianaDeTrees(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }

        swap(arr, mid, high);
        return arr[high];
    }

    // Método auxiliar para intercambiar elementos
    private static void swap(int[] lista, int posicion1, int posicion2) {

        // Esto evita perder el valor cuando lo sobrescribamos.
        int temp = lista[posicion1]; // Guarda el valor original de lista[i] en una varable temporal
        lista[posicion1] = lista[posicion2]; // Ahora lista[i] tiene el valor que estaba en lista[j]
        lista[posicion2] = temp; // lista[j] recibe el valor original de lista[i]
    }

    public static void main(String[] args) {
        // QuicksortMediana3
        long start, end;

        System.out.println(Main.PURPLE + "\n----------QuicksortMediana3----------" + Main.RESET);
        int[] arr = Main.ClonarArray(Main.arregloMain);

        System.out.println(Main.RED + "\nArray original:" + Main.RESET);
        // Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR

        start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        System.out.println(Main.GREEN + "\nArray ordenado:" + Main.RESET);
        // Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR
        System.out.println(
                Main.BLUE + "\tTiempo de Quicksort / Pivote QuicksortMediana3: " + (end - start) / 1e6 + " ms"
                        + Main.RESET);
    }

}