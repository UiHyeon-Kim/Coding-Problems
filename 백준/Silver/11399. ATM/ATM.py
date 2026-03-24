import sys
input = sys.stdin.readline

def solve():
    n = int(input())
    person = list(map(int, input().split()))

    person.sort()

    sum = 0
    total = 0
    for i in person:
        sum += i
        total += sum

    print(total)

if __name__ == '__main__':
    solve()