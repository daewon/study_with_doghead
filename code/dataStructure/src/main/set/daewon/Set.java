class Set<T> {
  public Set<T> parent;
  T value;

  public Set(T value, Set<T> parent) {
    this.value = value;
    this.parent = parent;
  }

  public Set<T> ancestor() {
    if (this.parent == null)  {
      return this;
    }

    return this.parent.ancestor();
  }

  public void union(Set<T> others) {
    Set<T> ancestor = others.ancestor();
    ancestor.parent = this;
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new Set<>(null, null);
    Set<Integer> set2 = new Set<>(null, null);
    Set<Integer> set3 = new Set<>(null, null);

    // group 1
    Set<Integer> a = new Set<>(1, set1);
    Set<Integer> b = new Set<>(2, set1);
    Set<Integer> c = new Set<>(3, set1);

    // group 2
    Set<Integer> d = new Set<>(4, set2);
    Set<Integer> e = new Set<>(5, set2);

    // group 3
    Set<Integer> f = new Set<>(6, set3);

    System.out.println(a.ancestor() == b.ancestor()); // set1
    System.out.println(a.ancestor() != d.ancestor()); // set2

    set2.union(set1); // union set1 && set2

    System.out.println(a.ancestor() == b.ancestor()); // set1
    System.out.println(a.ancestor() == d.ancestor()); // set2

    set3.union(set1); // union (set 1, set 2) && set 3

    System.out.println(a.ancestor() == b.ancestor()); // group 1 && group 1
    System.out.println(a.ancestor() == f.ancestor()); // group 1 && group 2
    System.out.println(d.ancestor() == f.ancestor()); // group 2 && group 3
    System.out.println(b.ancestor() == f.ancestor()); // group 1 && group 3

  }
}
