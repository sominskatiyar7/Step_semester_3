import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        System.out.println("Maximum Subarray Sum = " + max);
    }
}