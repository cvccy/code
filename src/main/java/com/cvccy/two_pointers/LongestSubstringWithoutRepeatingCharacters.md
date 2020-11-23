# 3. 无重复字符的最长子串
题目 #
Given a string, find the length of the longest substring without repeating characters.

Example 1:
```
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3.  因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
Example 2:

```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.因为无重复字符的最长子串是 "b"，所以其长度为 1。
```
Example 3:

```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
因为无重复字符的最长子串是"wke"，所以其长度为 3。
   请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
```

## 题目解读

在一个字符串中寻找没有重复字母的最长子串。

# 解题思路
## 解法一 位图
// 右侧字符对应的 bitSet 被标记 true，说明此字符在 X 位置重复，需要左侧向前移动，直到将X标记为 false

## 解法三 滑动窗口的
滑动窗口的右边界不断的右移，只要没有重复的字符，就持续向右扩大窗口边界。一旦出现了重复字符，就需要缩小左边界，直到重复的字符移出了左边界，然后继续移动滑动窗口的右边界。以此类推，每次移动需要计算当前长度，并判断是否需要更新最大长度，最终最大的值就是题目中的所求。

# 复杂度分析

- 时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
- 空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符），|\Sigma|∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符，即 ∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣ 个，因此空间复杂度为 O(∣Σ∣)。


