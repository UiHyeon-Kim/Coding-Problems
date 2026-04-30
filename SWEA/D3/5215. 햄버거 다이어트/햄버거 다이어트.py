T = int(input())


def find_score(idx, current_score, current_kcal):
    global max_score

    if current_kcal > max_kcal:
        return

    if max_score < current_score:
        max_score = current_score

    if idx >= mater_cnt:
        return

    find_score(idx + 1, current_score, current_kcal)
    find_score(idx + 1, current_score + materials[idx][0], current_kcal + materials[idx][1])


def solve():
    for tc in range(1, 1 + T):
        global max_score, materials, max_kcal, mater_cnt

        max_score = 0
        mater_cnt, max_kcal = map(int, input().split())
        materials = [list(map(int, input().split())) for _ in range(mater_cnt)]

        find_score(0, 0, 0)
        print(f"#{tc} {max_score}")


if __name__ == "__main__":
    solve()
