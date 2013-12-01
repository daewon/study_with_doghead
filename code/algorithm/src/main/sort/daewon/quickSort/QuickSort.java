public class QuickSort {
  static void partition(int[] arr, int s, int e) {
    int pivot = arr[e];
    int i = s;
    int j = e-1;

    while (i <= j ) {
      int l = arr[i];
      int r = arr[j];

      if (l < pivot && r > pivot) {
        i++;
        j--;
        continue;
      } else if (l < pivot && r < pivot)  {
        i++;
        continue;
      } else if (l > pivot && r < pivot) {
        arr[i] = r;
        arr[j] = l;
        i++;
        j++;
        continue;
      } else if (l > pivot && r > pivot) {
        j--;
        continue;
      }
    }

    System.out.println(i);
    System.out.println(j);

    arr[e] = arr[j+1];
    arr[j+1] = pivot;
  }

  static void sort(int[] arr) {
    partition(arr, 0, arr.length-1);
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
    int[] ints = {23, 15, 38, 62, 19, 16, 42, 25};
    print(ints);
    sort(ints);
    print(ints);
  }
}
