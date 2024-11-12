

public class insertionsort {
    // Function to perform insertion sort
    public static void insertionsort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];9968
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Helper function to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6 };
        System.out.println("Original Array:");
        printArray(array);

        insertionsort(array);
        System.out.println("Sorted Array:");
        printArray(array);
    }
}