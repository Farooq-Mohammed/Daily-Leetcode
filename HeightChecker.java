import java.util.Arrays;

public class HeightChecker {
/*
    A school is trying to take an annual photo of all the students.
    The students are asked to stand in a single file line in non-decreasing order by height.
    Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
    You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
    Return the number of indices where heights[i] != expected[i].

    Example 1:
    Input: heights = [1,1,4,2,1,3]
    Output: 3
    Explanation:
        heights:  [1,1,4,2,1,3]
        expected: [1,1,1,2,3,4]
        Indices 2, 4, and 5 do not match.

    Example 2:
    Input: heights = [5,1,2,3,4]
    Output: 5
    Explanation:
        heights:  [5,1,2,3,4]
        expected: [1,2,3,4,5]
        All indices do not match.

    Example 3:
    Input: heights = [1,2,3,4,5]
    Output: 0
    Explanation:
        heights:  [1,2,3,4,5]
        expected: [1,2,3,4,5]
        All indices match.


    Constraints:
        1 <= heights.length <= 100
        1 <= heights[i] <= 100
*/

    private void countingSort(int[] arr) {
        int[] count = new int[101];
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        for (int val : arr) count[val] += 1;

        int index = 0;
        for (int val = minVal; val <= maxVal; ++val) {
            while (count[val] > 0) {
                arr[index++] = val;
                count[val] -= 1;
            }
        }
    }

    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone();
        countingSort(sortedHeights);

        int count = 0;
        for (int i = 0; i < sortedHeights.length; ++i) {
            if (heights[i] != sortedHeights[i])
                count += 1;
        }
        return count;
    }
}
