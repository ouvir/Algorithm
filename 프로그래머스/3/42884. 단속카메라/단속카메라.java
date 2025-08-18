import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 시작점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));

        int answer = routes.length;
        int endPoint = -30001;

        for (int[] route : routes) {
            if (endPoint >= route[0]) {
                answer -= 1;
                endPoint = Math.min(endPoint, route[1]);
            } else {
                endPoint = route[1];
            }
        }

        return answer;
    }
}