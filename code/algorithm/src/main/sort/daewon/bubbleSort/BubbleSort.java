public class BubbleSort {
  static void sort(int[] arr) {
    boolean keep = true;
    while(keep) {
      keep = false;
      for(int i=0; i < arr.length -1 ; i++) {
        int l = arr[i];
        int r = arr[i+1];
        if (l > r) {
          arr[i] = r;
          arr[i+1] = l;
          keep = true;
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
    int[] ints = {6, 5, 4, 3, 2, 1, 2, 3, 4, 5};
    print(ints);
    sort(ints);
    print(ints);
  }
}
