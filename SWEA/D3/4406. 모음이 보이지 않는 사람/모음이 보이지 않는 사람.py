T = int(input())

for tc in range(1, T + 1):
    string = input().strip()
    vowels = {'a', 'e', 'i', 'o', 'u'}

    for vowel in vowels:
        string = string.replace(vowel, '')

    print(f"#{tc} {string}")
