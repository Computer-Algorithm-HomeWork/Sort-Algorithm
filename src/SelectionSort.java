public class SelectionSort extends AwesomeSort{
    @Override
    public int[] sort(int[] arr) {
        int [] x = arr.clone();
        int n = arr.length;;

        for (int i=0; i<n;i++){
            int idx = i;

            for (int j=i; j<n;j++){
                if (x[idx] > x[j]){
                    idx = j;
                }
            }
            int temp = x[i];
            x[i] = x[idx];
            x[idx] = temp;
        }
        return x;
    }
}
