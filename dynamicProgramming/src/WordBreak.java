import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> dict) {
        int n = s.length();
        return helper(0, s, dict) == 1;
    }

    static int helper(int i, String s, List<String> dict) {
        if (i >= s.length())
            return 0;
        else {
            if (dict.contains(s.substring(0, i)) && (helper(0, s, dict) == 1))
                return 1;
            else
                return 0;
        }
    }
}
