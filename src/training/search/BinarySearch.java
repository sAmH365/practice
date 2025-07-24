package training.search;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9, 11, 13};
    int target = 8;

    int idx = binarySearch(arr, target);
    
    if (idx == -1) {
      System.out.println("not found");
    } else {
      System.out.println("index = " + idx);  
    }
  }



  static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
