import java.util.ArrayList;
import java.util.List;

public class findClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> kClosest = new ArrayList<>();
        int closest = findClosestNum(arr, x);
        int left = closest, right = closest;

        int found = 0;
        while (found < k - 1) {

            if (left <= 0) {
                right++;
            } else if (right >= arr.length - 1) {
                left--;
            } else  {
                int leftDist = Math.abs(arr[left - 1] - x);
                int rightDist = Math.abs(arr[right + 1] - x);

                if (leftDist == rightDist || leftDist < rightDist) {
                    left--;
                } else {
                    right++;
                }
            }
            found++;
        }


        for (int i = left; i < left + k; i++) {
            kClosest.add(arr[i]);
        }

        return kClosest;
    }

    private int findClosestNum(int[] arr, int x){
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int midNum = arr[mid];
            if (midNum == x) {
                return mid;
            } else if (midNum > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= arr.length) {
            return right;
        } else if (right < 0) {
            return left;
        }

        int leftDist = Math.abs(arr[left] - x);
        int rightDist = Math.abs(arr[right] - x);
        return leftDist < rightDist ? left : right;
    }

}
