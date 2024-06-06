import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
/*
    Question:
    Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
    You may return the answer in any order.

    Example 1:
    Input: words = ["bella","label","roller"]
    Output: ["e","l","l"]

    Example 2:
    Input: words = ["cool","lock","cook"]
    Output: ["c","o"]

    Constraints:
        1 <= words.length <= 100
        1 <= words[i].length <= 100
        words[i] consists of lowercase English letters.
*/
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<String>();

        int[] counter = count(words[0]);
        for(int i = 1; i < words.length; i++) {
            int[] counter2 = count(words[i]);
            compare(counter, counter2);
        }

        for(int i=0;i<26;i++) {
            char ch = (char)('a' + i);
            while(counter[i]-- > 0)
                result.add(String.valueOf(ch));
        }

        return result;
    }

    public void compare(int[] a, int[] b) {
        for(int j=0;j<26;j++)
            a[j] = Math.min(a[j], b[j]);
    }

    public int[] count(String s) {
        int[] c = new int[26];
        for(char ch : s.toCharArray())    c[ch - 'a']++;
        return c;
    }
}
