public class InsertSort {

  static void shift(int[] arr, int index, int range) {
    for (int i=range; i > index; i--) {
      arr[i] = arr[i-1];
    }
  }

  static void sortInRange(int[] arr, int range) {
    int value = arr[range];
    for (int i=0; i < range; i++) {
      int n = arr[i];
      if (value < n ) {
        shift(arr, i, range);
        arr[i] = value;
        break;
      }
    }
  }

  static void sort(int[] arr) {
    for (int i=1; i < arr.length; i++) {
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
