import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int[] bubbleSort(double[] nums) {
		int swaps = 0;
		int count = 0;
		boolean swapped = true;

		for (int i = 0; i < nums.length - 1 && swapped; i++) {
			swapped = false;
			for (int j = 0; j < nums.length - 1 - i; j++) {
				count++;
				if (nums[j] > nums[j + 1]) {
					double temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swaps += 3;

					swapped = true;
				}
			}
		
		}
		return new int[]{swaps, count};
	}

	public static int[] selectionSort(double[] nums) {
		int swaps = 0;
		int count = 0;
		int smallestIndex;

		for (int i = 0; i < nums.length - 1; i++) {
			smallestIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				count++;
				if (nums[j] < nums[smallestIndex]) {
					smallestIndex = j;
					swaps++;
				}
			}
			double temp = nums[smallestIndex];
			nums[smallestIndex] = nums[i];
			nums[i] = temp;
			swaps += 3;
		}
		return new int[]{swaps, count};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int steps = 0;
		double key;
		int index;

		for (int i = 1; i < nums.length; i++) {
			key = nums[i];
			swaps++;
			index = i - 1;
			

			while (index >= 0 && nums[index] > key) {
				steps++;
				
				nums[index + 1] = nums[index];
				swaps++;
				index--;
			}

			nums[index + 1] = key;
			swaps++;
		}
		return new int[]{swaps, steps};
	}

	public static String leastSwaps(double[] nums) {
		double[] bubbleSortNums = Arrays.copyOf(nums, nums.length);
		double[] selectionSortNums = Arrays.copyOf(nums, nums.length);
		double[] insertionSortNums = Arrays.copyOf(nums, nums.length);

		int[] bubbleFinal = bubbleSort(bubbleSortNums);
		int[] selectionFinal = selectionSort(selectionSortNums);
		int[] insertionFinal = insertionSort(insertionSortNums);

		int bubbleSwaps = bubbleFinal[0];
		int selectionSwaps = selectionFinal[0];
		int insertionSwaps = insertionFinal[0];

		String bestSort = "Bubble";

		int minSwaps = bubbleSwaps;

		if (insertionSwaps < minSwaps) {
			minSwaps = insertionSwaps;
			bestSort = "Insertion";
		}

		if (selectionSwaps < minSwaps) {
			bestSort = "Selection";
		}

		//tie breaking
		if (bubbleSwaps <= insertionSwaps && bubbleSwaps <= selectionSwaps) {
			return "Bubble";
		}

		else if (insertionSwaps <= selectionSwaps) {
			return "Insertion";
		}

		else {
			return "Selection";
		}
	}

	public static String leastIterations(double[] nums) {
		double[] bubbleSortNums = Arrays.copyOf(nums, nums.length);
		double[] selectionSortNums = Arrays.copyOf(nums, nums.length);
		double[] insertionSortNums = Arrays.copyOf(nums, nums.length);

		int[] bubbleFinal = bubbleSort(bubbleSortNums);
		int[] selectionFinal = selectionSort(selectionSortNums);
		int[] insertionFinal = insertionSort(insertionSortNums);

		int bubbleSteps = bubbleFinal[1];
		int selectionSteps = selectionFinal[1];
		int insertionSteps = insertionFinal[1];

		String bestSort = "Bubble";
		int minSteps = bubbleSteps;

		if (insertionSteps < minSteps) {
			minSteps = insertionSteps;
			bestSort = "Insertion";
		}

		if (selectionSteps < minSteps) {
			bestSort = "Selection";
		}

		if (bubbleSteps <= insertionSteps && bubbleSteps <= selectionSteps) {
			return "Bubble";
		}

		else if (insertionSteps <= selectionSteps) {
			return "Insertion";
		}

		else {
			return "Selection";
		}
	}

}