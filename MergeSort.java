public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        // MergeSort
        long start, end;
        
        System.out.println(Main.PURPLE + "\n----------MergeSort----------" + Main.RESET);
        int[] arr = Main.ClonarArray(Main.arregloMain);

        System.out.println(Main.RED + "\nArray original:" + Main.RESET);
        //Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR

        start = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        System.out.println(Main.GREEN + "\nArray ordenado:" + Main.RESET);
        //Main.imprimirArray(arr);//-----------------PARA ARREGLOS MUY GRANDES COMENTAR

        System.out.println(
                Main.BLUE + "\tTiempo de MergeSort: " + (end - start) / 1e6 + " ms" + Main.RESET);
    }

}