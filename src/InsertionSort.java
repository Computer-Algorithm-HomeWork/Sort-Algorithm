public class InsertionSort extends AwesomeSort{
    @Override
    public int[] sort(int[] arr) {
        int [] x = arr.clone();

        int n = x.length;


        for (int i=1; i<n; i++) {
            int idx = x[i];
            int j;
            for (j = i - 1; j >= 0 && x[j] > idx; j--) {
                x[j + 1] = x[j];
            }
            x[j + 1] = idx;
        }
        return x;
    }
}
