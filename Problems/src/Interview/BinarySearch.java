package Interview;

public class BinarySearch {

	static int firstOccurence = Integer.MAX_VALUE;
	static int lastOccurence = Integer.MIN_VALUE;

	public static int BinarySearch(int[] inputArr, int lookUpValue, int start,
			int end) {

		int mid = (start + end) / 2;

		if (start == end) {
			if (inputArr[start] == lookUpValue) {
				return start;
			} else {
				System.out.println("Value does not dexist");
				return -1;
			}
		}

		if (inputArr[mid] == lookUpValue) {
			return mid;
		} else if (inputArr[mid] < lookUpValue) {
			return BinarySearch(inputArr, lookUpValue, mid + 1, end);
		} else {
			return BinarySearch(inputArr, lookUpValue, start, mid - 1);
		}

	}

	public static void getFirstOccurrence(int[] inputArr, int lookUpValue,
			int start, int end) {

		int mid = (start + end) / 2;

		if (start == end) {
			if (inputArr[start] == lookUpValue) {
				if (firstOccurence > mid) {
					firstOccurence = start;
				}
			}
			return;
		}
		if (inputArr[mid] == lookUpValue) {
			if (firstOccurence > mid) {
				firstOccurence = mid;
			}
			getFirstOccurrence(inputArr, lookUpValue, start, mid - 1);
		} else if (inputArr[mid] > lookUpValue) {
			getFirstOccurrence(inputArr, lookUpValue, start, mid - 1);
		} else {
			getFirstOccurrence(inputArr, lookUpValue, mid + 1, end);
		}

	}
	
	public static void getLastOccurrence(int[] inputArr, int lookUpValue,
			int start, int end) {

		int mid = (start + end) / 2;

		if (start == end) {
			if (inputArr[start] == lookUpValue) {
				if (lastOccurence < start) {
					lastOccurence = start;
				}
			}
			return;
		}
		
		if (inputArr[mid] == lookUpValue) {
			if (lastOccurence < mid) {
				lastOccurence = mid;
			}
			getLastOccurrence(inputArr, lookUpValue, mid+1, end);
		} else if (inputArr[mid] > lookUpValue) {
			getLastOccurrence(inputArr, lookUpValue, start, mid - 1);
		} else {
			getLastOccurrence(inputArr, lookUpValue, mid + 1, end);
		}

	}

	public static void main(String[] args) {

		int[] arr = new int[10];

		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		arr[5] = 5;
		arr[6] = 7;
		arr[7] = 7;
		arr[8] = 7;
		arr[9] = 8;

		getFirstOccurrence(arr, 7, 0, 9);
		getLastOccurrence(arr, 7, 0, 9);
		
		System.out.println(firstOccurence);
		System.out.println(lastOccurence);
		System.out.println(BinarySearch(arr, 7, 0, 9));

	}

}
