for _ in range(10):
    tc, L = map(int, input().split())
    arr = list(map(int, input().split()))

    graph = [[] for _ in range(100)]

    for i in range(0, len(arr), 2):
        u, v = arr[i], arr[i + 1]
        graph[u].append(v)

    stack = [0]
    visited = [False] * 100
    visited[0] = True
    found = 0

    while stack:
        current = stack.pop()

        if current == 99:
            found = 1
            break

        for next_node in graph[current]:
            if not visited[next_node]:
                visited[next_node] = True
                stack.append(next_node)

    print(f"#{tc} {found}")
