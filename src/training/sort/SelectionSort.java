package training.sort;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = {9, 6, 5, 7, 3};

    selectionSort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIdx = i;

      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }

      swap(arr, i, minIdx);
    }
  }

  static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
}
