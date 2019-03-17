import java.util.ArrayList;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubString {

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int Max = 1;
        ArrayList<Character> list = new ArrayList<Character>();
        list.add(s.charAt(0));
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                if(list.contains(s.charAt(j))){
                    Max = Math.max(Max,list.size());
                    list.removeAll(list);
                    list.add(s.charAt(i+1));
                    break;
                }else{
                    list.add(s.charAt(j));
                }
            }
        }
        return  Math.max(Max,list.size());
    }

    /**
     * 动态规划
     * @param s
     */
    public static int lengthOfLongestSubstring1(String s) {

        return 0;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("aab");
        System.out.println(result);
    }
}
