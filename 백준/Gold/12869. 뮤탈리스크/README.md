# [Gold IV] 뮤탈리스크 - 12869 

[문제 링크](https://www.acmicpc.net/problem/12869) 

### 성능 요약

메모리: 15804 KB, 시간: 88 ms

### 분류

다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 너비 우선 탐색

### 제출 일자

2025년 8월 2일 23:26:30

### 문제 설명

<p>수빈이는 강호와 함께 스타크래프트 게임을 하고 있다. 수빈이는 뮤탈리스크 1개가 남아있고, 강호는 SCV N개가 남아있다.</p>

<p>각각의 SCV는 남아있는 체력이 주어져있으며, 뮤탈리스크를 공격할 수는 없다. 즉, 이 게임은 수빈이가 이겼다는 것이다.</p>

<p>뮤탈리스크가 공격을 할 때, 한 번에 세 개의 SCV를 공격할 수 있다.</p>

<ol>
	<li>첫 번째로 공격받는 SCV는 체력 9를 잃는다.</li>
	<li>두 번째로 공격받는 SCV는 체력 3을 잃는다.</li>
	<li>세 번째로 공격받는 SCV는 체력 1을 잃는다.</li>
</ol>

<p>SCV의 체력이 0 또는 그 이하가 되어버리면, SCV는 그 즉시 파괴된다. 한 번의 공격에서 같은 SCV를 여러 번 공격할 수는 없다.</p>

<p>남아있는 SCV의 체력이 주어졌을 때, 모든 SCV를 파괴하기 위해 공격해야 하는 횟수의 최솟값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 SCV의 수 N (1 ≤ N ≤ 3)이 주어진다. 둘째 줄에는 SCV N개의 체력이 주어진다. 체력은 60보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 모든 SCV를 파괴하기 위한 공격 횟수의 최솟값을 출력한다.</p>

