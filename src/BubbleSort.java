public class BubbleSort {
    public static void main(String[]args) {
        int[] array = {5, 3, 4, 2, 9};
        int[] result = sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] sort(int[] array) {
        int len = array.length;
        int temp;
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}

