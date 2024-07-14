package y2024.m07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cn_zane@outlook.com
 * @version 1.0.0
 * @date 2024/7/14
 */
public class a3用最少数量的箭引爆气球 {
    
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    
    /**
     * 查找min箭头镜头.
     *
     * @param points 点数
     * @return int
     * @author cn_zane@outlook.com
     * @date 2024/07/14
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count += 1;
            }else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
