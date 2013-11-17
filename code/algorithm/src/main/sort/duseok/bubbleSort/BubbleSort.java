package sort.duseok.bubbleSort;

public class BubbleSort {

	static int[] sort(int dataSet[]) {
		int i = 0;
		int j = 0;
		int temp = 0;
		int length = dataSet.length;

		for (i = 0; i < length - 1; i++) {
			for (j = 0; j < length - 1; j++) {
				if (dataSet[j] > dataSet[j + 1]) {
					temp = dataSet[j + 1];
					dataSet[j + 1] = dataSet[j];
					dataSet[j] = temp;
				}
			}
		}
		return dataSet;
	}

}
