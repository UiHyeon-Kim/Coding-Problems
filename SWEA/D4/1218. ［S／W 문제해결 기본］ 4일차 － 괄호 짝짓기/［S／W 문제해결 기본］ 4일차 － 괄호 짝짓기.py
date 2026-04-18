for tc in range(1, 11):
    length = int(input())
    brackets = input().strip()
    stack = []
    is_pass = True

    for bracket in brackets:
        if stack:
            if stack[-1] == '(' and bracket == ')':
                stack.pop()
            elif stack[-1] == '{' and bracket == '}':
                stack.pop()
            elif stack[-1] == '[' and bracket == ']':
                stack.pop()
            elif stack[-1] == '<' and bracket == '>':
                stack.pop()
            elif bracket in ['(', '{', '[', '<']:
                stack.append(bracket)
            else:
                is_pass = False
                break
        elif bracket in ['(', '{', '[', '<']:
            stack.append(bracket)
        else:
            is_pass = False
            break

    if not stack and is_pass:
        print(f"#{tc} 1")
    else:
        print(f"#{tc} 0")