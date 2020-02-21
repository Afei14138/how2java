package algorithm.quicksort;

import java.util.Arrays;
import java.util.List;

/**
 * @author :wangpf45
 * @date : 2019-9-12
 */
public class QuickSort {
    public void quickSort(List<Integer> list, int left, int right) {
        int i, j, temp;
        //递归结束的基线调教
        if (left > right) {
            return;
        }

        temp = list.get(left);
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，首先要从右往左找
            while (list.get(j) >= temp && i < j) {
                j--;
            }
            while (list.get(i) <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = list.get(i);
                list.set(i, list.get(j));
                list.set(j, t);
            }
        }
        list.set(left, list.get(i));
        list.set(i, temp);
        quickSort(list, left, i - 1);
        quickSort(list, i + 1, right);
    }

    public static void main(String[] args) {
        Integer arr[] = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        List<Integer> arrs = Arrays.asList(arr);
        new QuickSort().quickSort(arrs, 0, arrs.size() - 1);
        for (int i = 0; i < arrs.size(); i++) {
            System.out.println(arrs.get(i));
        }

    }


}
