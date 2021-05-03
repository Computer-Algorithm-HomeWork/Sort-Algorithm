import javax.swing.*;

public class BubbleSort extends AwesomeSort {

    @Override
    public int[] sort(int[] arr) {

        int[] x = arr.clone();
        int n = x.length;

        for (int i=0; i<n; i++){
            for (int j=0; j<n-1; j++){
                if (x[j]>x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;

                }
            }
        }
        return x;

    }
}
