class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        size = len(nums)

        def isDifferentParity(a: int, b: int) -> bool:
            return (a+b) & 1 == 1

        for i in range(size-1):
            if not isDifferentParity(nums[i], nums[i+1]):
                return False
        return True
