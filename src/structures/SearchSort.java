package structures;

public class SearchSort {

    ////////////////////////////////////////////////////////////
    ///// BINARY SEARCH
    ////////////////////////////////////////////////////////////

    public static boolean binarySearch(int[] data, int val) {
        int lo = 0;
        int hi = data.length -1;

        while (hi >= lo) {
            int middle = (lo + hi) / 2;
            if(data[middle] == val) {
                return true;
            } else if(data[middle] < val) {
                lo = middle + 1;
            } else {
                hi = middle - 1;
            }
        }
        return false;
    }



    ////////////////////////////////////////////////////////////
    ///// MERGE SORT
    ////////////////////////////////////////////////////////////

    public static void mergeSort(int[] data) {
        int[] helper = new int[data.length];
        int low = 0, high = helper.length-1;
        mergeSort(data, helper, low, high);
    }

    private static void mergeSort(int[] data, int[] helper, int low, int high) {
        if(low < high) {
            int middle = (low + high)/2;
            mergeSort(data, helper, low, middle);
            mergeSort(data, helper, middle+1, high);
            merge(data, helper, low, middle, high);
        }
    }

    private static void merge(int[] data, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = data[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                data[current] = helper[helperLeft];
                helperLeft++;
            } else {
                data[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            data[current+i] = helper[helperLeft+i];
        }
    }



    ////////////////////////////////////////////////////////////
    ///// QUICK SORT
    ////////////////////////////////////////////////////////////

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length-1);
    }

    private static void quickSort(int[] data, int left, int right) {
        int index = partition(data, left, right);
        if(left < index - 1) {
            quickSort(data, left, index - 1);
        }
        if(index < right) {
            quickSort(data, index, right);
        }
    }

    private static int partition(int[] data, int left, int right) {
        int pivot = data[(left+right)/2];

        while (left <= right) {
            while (data[left] < pivot) {
                left++;
            }
            while (data[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(data, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

}
