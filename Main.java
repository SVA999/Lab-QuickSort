import java.util.Random;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static final int volumenDatos = 10000;//-------AQUI PUEDES CAMBIAR EL TAMAÑO DEL ARRAY 

    public static int[] arrRandom = GenerarArray(volumenDatos);

    public static final int[] arregloMain = ClonarArray(arrRandom);

    public static void main(String[] args) {

        // long start,end;

        // PRIMERO
        Quicksort.main(args);

        // RANDOM
        QuicksortRandom.main(args);

        // MEDIANA DE 3
        QuicksortMediana3.main(args);

        // Mergesort
        MergeSort.main(args);

    }

    // ----------------METODOS-------------------//

    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Generar arreglo con n elementos
    public static int[] GenerarArray(int cantidadElementos) {

        int[] arregloRandom = new int[cantidadElementos];
        Random random = new Random();

        for (int i = 0; i < arregloRandom.length; i++) {
            arregloRandom[i] = random.nextInt(1001) - 100;
        }
        return arregloRandom;
    }

    // Clonar arreglos
    public static int[] ClonarArray(int[] arregloOriginal) {

        int[] Clon = new int[arregloOriginal.length];

        for (int i = 0; i < arregloOriginal.length; i++) {
            Clon[i] = arregloOriginal[i];
        }
        return Clon;
    }

}