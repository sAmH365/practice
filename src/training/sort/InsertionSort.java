package training.sort;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {9, 5, 1, 3, 7};

    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;

      // 왼쪽에서 key보다 큰 값들은 오른쪽으로 밀기
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }

      // key를 알맞은 자리에 삽입
      arr[j + 1] = key;
    }

    // 출력
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
