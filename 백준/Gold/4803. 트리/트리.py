import sys

input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

tc = 1
while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0:
        break

    parent = [0] * (N+1)
    cycle_set = set()
    edges = []
    for i in range(1,N+1):
        parent[i] = i

    for _ in range(M):
        a, b = map(int, input().split())
        if find_parent(parent, a) == find_parent(parent, b):
            cycle_set.add(parent[a])
        
        # 두 노드 중 한쪽이 사이클에 연결 되어있으면
        # 두 노드 다 사이클에 연결 된 것으로 간주
        if parent[a] in cycle_set or parent[b] in cycle_set:
            cycle_set.add(parent[a])
            cycle_set.add(parent[b])
        
        union_parent(parent, a, b)

    for i in range(1,N+1):
        find_parent(parent, i)

    count_set = sum([1 if i not in cycle_set else 0 for i in set(parent[1:])])
    word = ""
    if count_set == 0:
        word = "No trees."
    elif count_set == 1:
        word = "There is one tree."
    else:
        word = f"A forest of {count_set} trees."   
    print(f"Case {tc}: {word}")
    tc += 1