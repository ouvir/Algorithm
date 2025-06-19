import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    private static int N;
    private static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2;
        int y = N / 2;

        int m = 1;
        int count = 0;
        int d = 0;
        int output = 0; // 격자 밖으로 나간 모래 양

        while(true) {
            if(x == 0 && y == 0) break;
            for (int j = 0; j < m; j++) {
                int mx = x + dx[d];
                int my = y + dy[d];

                if(mx == 0 && my == -1) break;

//                System.out.println(mx + ", " + my + ", " + output);
//
//                for(int k = 0; k < N; k++) {
//                    for (int l = 0; l < N; l++) {
//                        System.out.print(graph[k][l] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("==============");
                // 모래 움직이기
                if (graph[mx][my] > 0) {
                    int leftD = (d + 1) % 4;
                    int rightD = (d + 3) % 4;

                    int one = graph[mx][my] / 100;
                    int two = graph[mx][my] * 2 / 100;
                    int five = graph[mx][my] * 5 / 100;
                    int seven = graph[mx][my] * 7 / 100;
                    int ten = graph[mx][my] * 10 / 100;

                    if (check(mx + dx[leftD], my + dy[leftD])) output += seven;
                    else graph[mx + dx[leftD]][my + dy[leftD]] += seven;

                    if (check(mx + dx[leftD] * 2, my + dy[leftD] * 2)) output += two;
                    else graph[mx + dx[leftD] * 2][my + dy[leftD] * 2] += two;

                    if (check(mx + dx[rightD], my + dy[rightD])) output += seven;
                    else graph[mx + dx[rightD]][my + dy[rightD]] += seven;

                    if (check(mx + dx[rightD] * 2, my + dy[rightD] * 2)) output += two;
                    else graph[mx + dx[rightD] * 2][my + dy[rightD] * 2] += two;

                    if (check(x + dx[leftD], y + dy[leftD])) output += one;
                    else graph[x + dx[leftD]][y + dy[leftD]] += one;

                    if (check(x + dx[rightD], y + dy[rightD])) output += one;
                    else graph[x + dx[rightD]][y + dy[rightD]] += one;


                    int alphaX = mx + dx[d];
                    int alphaY = my + dy[d];

                    if (check(alphaX + dx[leftD], alphaY + dy[leftD])) output += ten;
                    else graph[alphaX + dx[leftD]][alphaY + dy[leftD]] += ten;
                    if (check(alphaX + dx[rightD], alphaY + dy[rightD])) output += ten;
                    else graph[alphaX + dx[rightD]][alphaY + dy[rightD]] += ten;

                    if (check(alphaX + dx[d], alphaY + dy[d])) output += five;
                    else graph[alphaX + dx[d]][alphaY + dy[d]] += five;

                    if (check(alphaX, alphaY))
                        output += graph[mx][my] - (2 * one + 2 * two + 2 * seven + 2 * ten + five);
                    else graph[alphaX][alphaY] += graph[mx][my] - (2 * one + 2 * two + 2 * seven + 2 * ten + five);

                    graph[mx][my] = 0;
                }

                // 토네이도 이동
                x = mx;
                y = my;
            }

            count++;
            if (count == 2) {
                count = 0;
                m++;
            }
            d = (d+1) % 4;
        }

        System.out.println(output);
    }

    private static boolean check(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}
