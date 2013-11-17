package set.duseok;

public class JoinSet<T> {
	public class Set<T> {
		private Set<T> parent;
		private T data;

		public Set<T> getParent() {
			return parent;
		}

		public void setParent(Set<T> parent) {
			this.parent = parent;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	public void unionSet(Set<T> set1, Set<T> set2) {
		set2 = findSet(set2);
		set2.setParent(set1);
	}

	public Set<T> findSet(Set<T> set) {
		while (set.getParent() != null) {
			set = set.getParent();
		}
		return set;
	}

	public Set<T> makeSet(T data) {
		Set<T> newSet = new Set<T>();
		newSet.setData(data);
		return newSet;
	}
}
