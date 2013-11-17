package set.duseok;

public class JoinSet<T> {
	public class Set {
		private Set parent;
		private T data;

		public Set getParent() {
			return parent;
		}

		public void setParent(Set parent) {
			this.parent = parent;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	public void unionSet(Set set1, Set set2) {
		set2 = findSet(set2);
		set2.setParent(set1);
	}

	public Set findSet(Set set) {
		while (set.getParent() != null) {
			set = set.getParent();
		}
		return set;
	}

	public Set makeSet(T data) {
		Set newSet = new Set();
		newSet.setData(data);
		return newSet;
	}
}
