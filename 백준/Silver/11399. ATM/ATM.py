import sys
input = sys.stdin.readline

n = input()
person = list(map(int, input().split()))

person.sort()

sum = 0
total = 0
for i in person:
    sum += i
    total += sum

print(total)
