public class QuickSort {
  static int partition(int[] arr, int s, int e) {
    int pivot = arr[e];
    int i = s;
    int j = e-1;

    while (i <= j) {
      int l = arr[i];
      int r = arr[j];

      if (l < pivot && r < pivot)  {
        i++;
        continue;
      } else if (l > pivot && r > pivot) {
        j--;
        continue;
      } else if (l > pivot && r < pivot) {
        arr[i] = r;
        arr[j] = l;
      }

      i++;
      j--;
    }
    arr[e] = arr[i];
    arr[i] = pivot;

    return i;
  }

  static void sortInRange(int[] arr, int s, int e) {
    if (e - s < 1)  { return; }
    int p = partition(arr, s, e);
    sortInRange(arr, s, p-1);
    sortInRange(arr, p+1, e);
  }

  static void sort(int[] arr) {
    int p = partition(arr, 0, arr.length - 1);
    sortInRange(arr, 0, arr.length - 1);
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
    int[] ints = {1, 2, 3, 23, 15, 38, 62, 19, 16, 42, 25, 12};

    print(ints);
    sort(ints);
    print(ints);
  }
}
