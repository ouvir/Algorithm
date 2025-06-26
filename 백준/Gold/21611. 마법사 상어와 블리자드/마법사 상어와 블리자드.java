import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dx = {0, -1, 1, 0, 0};
    static final int[] dy = {0, 0, 0, -1, 1};

    static final int[] ddx = {0, 1, 0, -1};
    static final int[] ddy = {-1, 0, 1, 0};

    static int N;
    static int M;
    static int x;
    static int y;
    static int[][] graph;
    static int[] numberCount;
    static ArrayDeque<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        x = N / 2;
        y = N / 2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numberCount = new int[4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            blizzard(d, s);

            move();
        }

        System.out.println(numberCount[1] + 2 * numberCount[2] + 3 * numberCount[3]);
    }

    public static void blizzard(int d, int s) {
        for (int i = 1; i <= s; i++) {
            int mx = x + dx[d] * i;
            int my = y + dy[d] * i;
            graph[mx][my] = 0;
        }
    }

    public static void move() {
        // 큐에 담기 -> 다시 배치 O(2N)
        q = new ArrayDeque<>();
        // 나선형 순회하며 큐에 담기
        search();
        // 큐 순회하며 4개 연속 숫자 제거
        pop();
        // 구슬 변화
        change();
        // 큐에 남은거 다시 그려주기
        draw();
    }


    public static void search() {
        int x = N/2, y = N/2, d = 0, m = 1, mCount = 0, dCount = 0;
        q.add(graph[x][y]); // 상어

        for(int i = 0; i < N * N-1; i++) {
            int mx = x + ddx[d];
            int my = y + ddy[d];

            if(graph[mx][my] != 0) q.add(graph[mx][my]);

            mCount++;
            if(mCount == m) {
                d = (d + 1) % 4;
                mCount = 0;
                dCount++;
                if(dCount == 2) {
                    m++;
                    dCount = 0;
                }
            }
            x = mx;
            y = my;
        }
    }

    private static void pop() {
        Queue<Integer> tmp = new ArrayDeque<>();
        boolean bomb = true;
        while(bomb) {
            bomb = false;
            int count = 0;
            int target = 0;

            while(!q.isEmpty()) {
                int e = q.poll();
                if(e == target) {
                    count++;
                } else {
                    if(count < 4) {
                        for (int j = 0; j < count; j++) tmp.add(target);
                    } else {
                        numberCount[target] += count;
                        bomb = true;
                    }
                    target = e;
                    count = 1;
                }
            }

            if (count < 4) {
                for (int j = 0; j < count; j++) tmp.add(target);
            } else {
                numberCount[target] += count;
                bomb = true;
            }

            while(!tmp.isEmpty()) {
                q.add(tmp.poll());
            }
        }
    }

    private static void change() {
        Queue<Integer> tmp = new ArrayDeque<>();
        tmp.add(q.poll()); // 상어 빼기


        while(!q.isEmpty()) {
            int target = q.poll();
            int count = 1;

            while(!q.isEmpty() && target == q.peek()) {
                count++;
                q.poll();
            }
            // A 구슬(개수) , B 구슬(번호)
            tmp.add(count);
            tmp.add(target);
        }

        while(!tmp.isEmpty() && q.size() < N*N) {
            q.add(tmp.poll());
        }
    }

    public static void draw() {
        int x = N/2, y = N/2, d = 0, m = 1, mCount = 0, dCount = 0;

        graph = new int[N][N];
        graph[x][y] = q.poll(); // 상어

        while(!q.isEmpty()) {
            int e = q.poll();
            int mx = x + ddx[d];
            int my = y + ddy[d];

            graph[mx][my] = e;

            mCount++;
            if(mCount == m) {
                d = (d + 1) % 4;
                mCount = 0;
                dCount++;
                if(dCount == 2) {
                    m++;
                    dCount = 0;
                }
            }
            x = mx;
            y = my;
        }
    }

}