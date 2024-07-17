package y2024.m07;

import java.util.Arrays;
import java.util.Collections;

public class a5火柴拼正方形 {
    public static void main(String[] args) {
        int[] matchsticks = new int[]{5,5,5,5,4,4,4,4,3,3,3,3};
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        // stream 倒序排序
        matchsticks = Arrays.stream(matchsticks)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        // 倒序排序
//        Arrays.sort(matchsticks);
//        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
//            int temp = matchsticks[i];
//            matchsticks[i] = matchsticks[j];
//            matchsticks[j] = temp;
//        }

        int bucketSize = sum / 4;
        int[] buckets = new int[4];
        return dfs(0, matchsticks, buckets, bucketSize);
    }

    private static boolean dfs(int i, int[] matchsticks, int[] buckets, int bucketSize) {
        if (i == matchsticks.length) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            // 桶放不下
            if (buckets[j] + matchsticks[i] > bucketSize) {
                continue;
            }
            buckets[j] += matchsticks[i];
            // 递归将下一个火柴放入四个桶中
            if (dfs(i + 1, matchsticks, buckets, bucketSize)) {
                return true;
            }
            buckets[j] -= matchsticks[i];
        }
        return false;
    }


}
