public class InsertSort {

  static void shift(int[] arr, int index, int range) {
    for (int i=range; i > index; i--) {
      arr[i] = arr[i-1];
    }
  }

  static void sortInRange(int[] arr, int range) {
    int value = arr[range]; // 현재 비교할 값
    for (int i=0; i < range; i++) {
      int n = arr[i];
      if (value < n ) { // 현재 값을 정렬된 위치에 넣는다
        shift(arr, i, range);
        arr[i] = value;
        break;
      }
    }
  }

  static void sort(int[] arr) {
    for (int i=1; i < arr.length; i++) {
      if (arr[i-1] < arr[i]) { continue; }
      sortInRange(arr, i);
    }
  }

  static void print(int[] arr) {
    System.out.print("[");
    for (int i=0; i < arr.length; i++) {
      int n = arr[i];
      System.out.print(n);
      if (i < arr.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] ints = {6, 3, 1, 7, 4, 8, 9, 5, 2};
    print(ints);
    sort(ints);
    print(ints);
  }
}
