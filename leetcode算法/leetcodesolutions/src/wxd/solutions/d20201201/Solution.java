package wxd.solutions.d20201201;

import wxd.solutions.utils.PrintHelper;

import java.util.Arrays;
import java.util.List;

/* arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
        我们最多能将数组分成多少块？
        示例 1:
        输入: arr = [5,4,3,2,1]
        输出: 1
        解释:
        将数组分成2块或者更多块，都无法得到所需的结果。
        例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
        示例 2:
        输入: arr = [2,1,3,4,4]
        输出: 4
        解释:
        我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
        然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。*/
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] arrBefore = arr;
        Arrays.sort(arr);
        int num = 0;
        int i = 0;
        while (i < arr.length) {
            for (int j = i + 1; j <= arrBefore.length; j++) {
                if (this.elementsEqual(arr, arrBefore, i, j)) {
                    i = j;
                    num++;
                }
            }
        }
        return num;
    }

    public boolean elementsEqual(int[] a, int[] b, int begin, int end) {
        int[] aElements = new int[end - begin];
        PrintHelper.printIntArray(a);
        PrintHelper.printIntArray(b);
        for (int i = begin; i < end; i++) {
            aElements[i] = a[i];
        }
        int[] bElements = new int[end - begin];
        for (int i = begin; i < end; i++) {
            bElements[i] = b[i];
        }
        Arrays.sort(aElements);
        Arrays.sort(bElements);
        return Arrays.equals(aElements, bElements);
    }
}