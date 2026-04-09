A, B = map(int, input().split())
result = A % B

if result == 0 or result == 2:
    print("B")
elif result == 1:
    print("A")
