# -*- coding: utf-8 -*-
"""Two Sum.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1tW1B-iufCtEUO5QKftySI3DtVyC8o3U1
"""

class Solution(object):
    def twoSum(self, nums, target):
        newDict = []
        for i in range(0,len(nums)):
          for j in range(i+1,len(nums)):
              total = nums[i]+nums[j]
              if total == target:
                if i not in newDict:
                  if j not in newDict:
                    newDict.append(i)
                    newDict.append(j)
        return newDict

