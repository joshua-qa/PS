class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in s:
            if (len(stack) == 0):
                stack.append(i)
                continue
            if i == '[' or i == '(' or i == '{':
                stack.append(i)
                continue
            top = stack[-1]
            if (top == '[' and i == ']') or (top == '(' and i == ')') or (top == '{' and i == '}'):
                stack.pop()
                continue
            return False

        return len(stack) == 0
