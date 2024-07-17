package y2024.m07;

public class a4跳跃游戏 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        // 最大可以到达的索引,初始为0
        int maxIndex = 0;
        for (int i = 0; i <=maxIndex; i++) {
            // 索引加上跳跃的步数
            if (nums[i] + i > maxIndex) {
                maxIndex = nums[i] + i;
            }
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


}
