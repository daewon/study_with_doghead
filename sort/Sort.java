import java.util.*;
import java.io.*;

class Sort {
  public static class DealItems<T1 extends Comparable<T1>, T2 extends Comparable<T2>> {
    private Map<T1, List<T2>> items = new TreeMap<T1, List<T2>>();

    public void add(T1 deal, T2 option) {
      if (!items.containsKey(deal)) {
        items.put(deal, new ArrayList<T2>());
      }
      items.get(deal).add(option);
    }

    public void sort() {
      Map<T1, List<T2>> sortedItems = new TreeMap<T1, List<T2>>();
      sortedItems.putAll(this.items);

      for (List<T2> options : sortedItems.values()) {
        Collections.sort(options);
      }

      this.items = sortedItems;
    }

    public void sort(Comparator<T1> forDeal, Comparator<T2> forOption) {
      Map<T1, List<T2>> sortedItems = new TreeMap<T1, List<T2>>(forDeal);
      sortedItems.putAll(this.items);

      for (List<T2> options : sortedItems.values()) {
        Collections.sort(options, forOption);
      }

      this.items = sortedItems;
    }

    public void print() {
      for (Map.Entry<T1, List<T2>> sets : this.items.entrySet()) {
        System.out.printf("%s -> %s\n", sets.getKey(), sets.getValue());
      }
    }
  }

  public static void main(String[] args) throws Exception {
    DealItems<Integer, Integer> dealItems = new DealItems<Integer, Integer>();

    dealItems.add(110, 10);
    dealItems.add(101, 9);
    dealItems.add(101, 8);
    dealItems.add(103, 7);
    dealItems.add(105, 6);
    dealItems.add(105, 5);
    dealItems.add(101, 4);
    dealItems.add(103, 3);
    dealItems.add(103, 2);
    dealItems.add(110, 1);

    // for default sorting
    dealItems.sort();
    dealItems.print();
    System.out.println();

    // for custom order
    Comparator<Integer> intAscComparer = new Comparator<Integer>(){
        @Override public int compare(Integer e1, Integer e2) {
          return e1 - e2;
        }
      };

    Comparator<Integer> intDescComparer = new Comparator<Integer>(){
        @Override public int compare(Integer e1, Integer e2) {
          return e2 - e1;
        }
      };

    dealItems.sort(intDescComparer, intAscComparer);
    dealItems.print();
    System.out.println();

    dealItems.sort(intAscComparer, intDescComparer);
    dealItems.print();
    System.out.println();
  }
}
