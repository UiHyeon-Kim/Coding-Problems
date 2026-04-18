from collections import deque

for _ in range(10):
    tc, _ = map(int, input().split())
    arr = list(map(int, input().split()))
    graph = [[] for _ in range(100)]

    for i in range(0, len(arr), 2):
        graph[arr[i]].append(arr[i + 1])

    q = deque()
    visited = [False] * 100

    q.append(0)
    visited[0] = True

    is_find = False

    while q:
        cur = q.popleft()

        for neighbor in graph[cur]:
            if neighbor == 99:
                is_find = True
                break
            if not visited[neighbor]:
                q.append(neighbor)
                visited[neighbor] = True

        if is_find:
            break

    if is_find:
        print(f"#{tc} 1")
    else:
        print(f"#{tc} 0")