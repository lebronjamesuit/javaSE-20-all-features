package Arrays;

public class Rotate {

        public static int search(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {
                    return mid;
                }

                // Check if the left half is sorted
                if (arr[left] <= arr[mid]) {
                    if (arr[left] <= target && target < arr[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // If the left half is not sorted, the right half must be sorted
                else {
                    if (arr[mid] < target && target <= arr[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1; // Element not found
        }

        public static void main(String[] args) {
            int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
            int target = 0;
            int result = search(rotatedArray, target);

            if (result != -1) {
                System.out.println("Element " + target + " found at index " + result);
            } else {
                System.out.println("Element " + target + " not found in the rotated array.");
            }
        }

}
