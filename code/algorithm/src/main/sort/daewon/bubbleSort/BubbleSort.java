public class BubbleSort {
  static void sort(int[] arr) {
    for(int i=0; i<arr.length -1; i++) {
      for(int j=i+1; j<arr.length; j++) {
        int l = arr[i];
        int r = arr[j];
        if (l > r) {
          arr[i] = r;
          arr[j] = l;
        }
      }
    }
  }


  static void print(int[] arr) {
    System.out.print("[");
    for(int i=0; i < arr.length; i++) {
      int n = arr[i];
      System.out.print(n);
      if (i < arr.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] ints = {5, 1, 6, 4, 2, 3};
    print(ints);
    sort(ints);
    print(ints);
  }
}
