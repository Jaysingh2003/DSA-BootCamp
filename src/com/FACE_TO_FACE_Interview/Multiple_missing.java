import java.util.ArrayList;
import java.util.List;

public class Multiple_missing{

    public List<Integer> findDuplicates(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int i = 0;

        // cyclic sort
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        // find duplicates
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(arr[i]);
            }
        }

        return list;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}