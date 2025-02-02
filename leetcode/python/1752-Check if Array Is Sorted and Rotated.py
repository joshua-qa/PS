class Solution:
    def check(self, nums: List[int]) -> bool:
        max_num = 0
        rotated = False
        for i in range(len(nums)):
            if nums[i] >= max_num:
                if rotated and nums[i] > nums[0]:
                    return False
                max_num = nums[i]
                continue
            else:
                rotated = True
                if nums[i] > nums[0]:
                    return False
                else:
                    nums[i] += max_num
                    if nums[i] < nums[i-1]:
                        return False
        return True
