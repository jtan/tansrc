package utils;

public class CustomArrayUtil{

    /**
     * Sort an array using a merge sort algorithm.
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        int[] arrayBuffer = new int[array.length];
        mergeSort(array, arrayBuffer, 0, array.length);
    }

    /**
     * Sort an array using a quick sort algorithm.
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length);
    }

    /**
     * Search for a value in an array using a binary search algorithm.
     *
     * @param array
     * @param value
     * @return
     */
    public static int search(int[] sortedArray, int value) {
        return binarySearch(sortedArray, 0, sortedArray.length, value);
    }

    private static int binarySearch(int[] sortedArray, int left, int right, int value) {
        int mid = (left + right) / 2;

        if (value < sortedArray[mid]) {
            return binarySearch(sortedArray, left, mid, value);
        } else if (value > sortedArray[mid]) {
            return binarySearch(sortedArray, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int pivotIndex = swapAroundPivot(array, left, right);

        if (left < pivotIndex - 1) {
            quickSort(array, left, pivotIndex - 1);
        }

        if (right > pivotIndex) {
            quickSort(array, pivotIndex, right);
        }
    }

    private static int swapAroundPivot(int[] array, int left, int right) {
        int pivot = (left + right) / 2;

        while(array[left] < array[pivot]) {
            left++;
        }

        while(array[right] > array[pivot]) {
            right--;
        }

        if (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }

        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static void mergeSort(int[] array, int[] buffer, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, buffer, low, mid);
            mergeSort(array, buffer, mid + 1, high);
            merge(array, buffer, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] buffer, int low, int mid, int high) {
        // copy array into buffer to store original state
        for (int i = 0; i < array.length; i++) {
            buffer[i] = array[i];
        }

        // init left and right boundaries
        int left = low;
        int right = mid;
        int current = low;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                array[current] = array[left];
                left++;
            } else {
                array[current] = array[right];
                right++;
            }

            current++;
        }

        // copy over left side if right side is finished first
        int remainingCount = mid - left;
        for (int i = left; i < remainingCount; i++) {
            array[current] = buffer[left];
            left++;
            current++;
        }
    }


}
