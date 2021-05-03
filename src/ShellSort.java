public class ShellSort extends AwesomeSort {


    @Override
    public int[] sort(int[] arr) {
        int [] x = arr.clone();

        int n = arr.length;

        for (int h = 1; h<n; h=3*h+1) // robert sedgewick
        // for (int h=n/2; h>0; h=h/2) // 간격 gap

            for (int i=h; i<n;i++){
                int temp = x[i];
                int j;

                for (j=i-h; j>=0 && x[j]>temp; j-=h){
                    x[j+h]=x[j];

                }
                x[j+h] = temp;

            }
        return x;
    }
}
