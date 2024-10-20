# [D4] 격자판의 숫자 이어 붙이기 - 2819 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7I5fgqEogDFAXB) 

### 성능 요약

메모리: 59,016 KB, 시간: 288 ms, 코드길이: 801 Bytes

### 제출 일자

2024-10-20 17:26

### 풀이 시간
15분 23초

### 사고 흐름
1. 4x4 의 격자판에서 숫자 이어붙이기를 보고, 완전 탐색을 떠올림
2. 한 칸에서 이동 가능한 경우의 수 = 4, 이를 6번 반복 => 16 * (4 ** 6) = 4 ** 8 = 2 ** 16 = 65,536 의 경우의 수
3. 이는 완전 탐색으로 풀이 가능한 정도라고 봄
4. BFS를 통한 완전탐색을 진행하며, 숫자를 이어 붙이고 길이가 7이 되었을 때, 이를 set에 저장
5. set의 길이를 출력하면 된다고 생각함

> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do
