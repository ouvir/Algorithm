import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int N;
	static int M;
	static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int count = 0; // 청소 개수
        
        while(true) {
        	// 현재칸 청소 count++;
        	if(graph[r][c] == 0) {
        		graph[r][c] = -1;
        		count++;        		
        	}
        	
        	// 현재 칸 주변 4칸 중 청소 안된 칸 없는 경우
        	boolean allClear = true;
        	for (int i = 0; i < 4; i++) {
				int mr = r + dr[i];
				int mc = c + dc[i];
				
				if(mr < 0 || mr >= N || mc < 0 || mc >= M) continue;
				if(graph[mr][mc] == 0) allClear = false;
			}
        	if(allClear) {
        		// back or stop
        		int mr = r - dr[d];
				int mc = c - dc[d];
				
				if(mr < 0 || mr >= N || mc < 0 || mc >= M || graph[mr][mc] == 1) {
					break;
				}
				
				r = mr;
				c = mc;
        	} else {
        		// 현재 칸 주변 4칸 중 청소 안된 칸 존재 시
            	while(true) {
            		d = (d + 3) % 4;
            		int mr = r + dr[d];
            		int mc = c + dc[d];
            		
            		if(mr < 0 || mr >= N || mc < 0 || mc >= M || graph[mr][mc] == 1) {
            			continue;
            		}
            		if(graph[mr][mc] == 0) {
            			r = mr;
            			c = mc;
            			break;
            		}
            	}
        	}
        	
        	
        }
        System.out.println(count);
    }
}
