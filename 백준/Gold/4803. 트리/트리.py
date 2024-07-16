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
    cycle = []
    for i in range(1,N+1):
        parent[i] = i

    for _ in range(M):
        a, b = map(int, input().split())
        if find_parent(parent, a) == find_parent(parent, b):
            cycle.append(a)
        else:
            union_parent(parent, a, b)

    # 모두 루트 노드 갱신
    for i in range(N+1):
        find_parent(parent, i)

    cycle_set = set()
    for e in cycle:
        cycle_set.add(parent[e])

    count_set = len(set(parent[1:]) - cycle_set)
    word = ""
    if count_set == 0:
        word = "No trees."
    elif count_set == 1:
        word = "There is one tree."
    else:
        word = f"A forest of {count_set} trees."   
    print(f"Case {tc}: {word}")
    tc += 1