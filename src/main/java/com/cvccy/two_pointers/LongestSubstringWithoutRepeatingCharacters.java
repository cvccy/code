package com.cvccy.two_pointers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * 方法一 位图法
     * @param s
     * @return 最长字串长度
     */
    public int lengthOfLongestSubstring1(String s){
        //LocalDateTime start  = LocalDateTime.now();
        BitSet bitSet = new BitSet(1); //定义位图 只作为判断当前字串该位指向字符是否以存在
        int left=0,right=0,result=0;
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        while (right < len && left < len) {
            // if s[right] == 1 将left循环到当前right位置，此位置之前的位图置位0 else s[right] == 0 位图置为1
            if (bitSet.get(s.charAt(right)) == true) {
                bitSet.clear(s.charAt(left));
                left++;
            } else {
                bitSet.set(s.charAt(right));
                right++;
            }
            result = Math.max(right - left,result);
        }
        //LocalDateTime end = LocalDateTime.now();
        //Duration duration = Duration.between(start,end);
        //System.out.println(duration.toMillis());
        return result;
    }

    /**
     * 方法二 移动窗格法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(256 >> 6);
        String s = "abbzcabcbbz";
        System.out.println(s.charAt(3));
        LongestSubstringWithoutRepeatingCharacters ss = new LongestSubstringWithoutRepeatingCharacters();
        LocalDateTime start  = LocalDateTime.now();
        System.out.println(ss.lengthOfLongestSubstring2(s));
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration.toMillis());

    }
}
