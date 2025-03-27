import java.util.Random;

public class QuicksortRandom {

    // Método principal para ordenar el array
    public static String quickSort(int[] lista, int ini, int fin) {

        // Si el subarray tiene más de un elemento
        if (ini < fin) {

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

        // De esta forma escogemos una posicion al azar dentro del vector
        int posicionRandom = new Random().nextInt(fin - ini + 1) + ini;
        swap(lista, posicionRandom, ini);

        // Mientras los índices no se crucen
        while (ini < fin) {
            // Revisar desde la derecha: buscar elemento menor que el pivote
            while (lista[fin] >= lista[ini] && ini < fin) {
                fin--; // Mover índice hacia la izquierda
            }

            // Si encontramos un elemento menor, lo intercambiamos con el pivote (en ini)
            if (ini < fin) {
                swap(lista, ini, fin);
            }

            // Revisar desde la izquierda: buscar elemento mayor que el pivote
            while (lista[ini] <= lista[fin] && ini < fin) {
                ini++; // Mover índice hacia la derecha
            }

            // Si encontramos un elemento mayor, lo intercambiamos con el pivote (en fin)
            if (ini < fin) {
                swap(lista, ini, fin);
            }
        }

        // Al final, ini y fin son iguales y apuntan a la posición correcta del pivote
        return ini;
    }

    // Método auxiliar para intercambiar elementos
    private static void swap(int[] lista, int posicion1, int posicion2) {

        // Esto evita perder el valor cuando lo sobrescribamos.
        int temp = lista[posicion1]; // Guarda el valor original de lista[i] en una varable temporal
        lista[posicion1] = lista[posicion2]; // Ahora lista[i] tiene el valor que estaba en lista[j]
        lista[posicion2] = temp; // lista[j] recibe el valor original de lista[i]
    }

    public static void main(String[] args) {
        // RANDOM

        long start, end;

        System.out.println(Main.PURPLE + "\n----------RANDOM----------" + Main.RESET);
        int[] arr = Main.ClonarArray(Main.arregloMain);

        System.out.println(Main.RED + "\nArray original:" + Main.RESET);
        // Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR

        start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        System.out.println(Main.GREEN + "\nArray ordenado:" + Main.RESET);
        // Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR

        System.out.println(
                Main.BLUE + "\tTiempo de Quicksort / Pivote Aleatorio: " + (end - start) / 1e6 + " ms" + Main.RESET);
    }

}