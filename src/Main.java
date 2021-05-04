import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long beforeTime = System.nanoTime();

        int [] arr = new int [120000];


        Random r = new Random(System.nanoTime());

        for (int j=0; j<arr.length;j++){
            arr[j] = r.nextInt(10000);
        }

        for (int i=0; i< arr.length;i++){
           for (int k = i; k<arr.length; k++){
                if (arr[k] < arr[i]){ // > reverse
                   int temp = arr[i];
                    arr[i] = arr[k];
                   arr[k] = temp;
               }
           }
        }


        AwesomeSort b = new ShellSort(); // (bubble,selection,insertion,shell)Sort 중 선택

        for(int j : arr) System.out.printf("%d ", j);
        System.out.println("");

        int [] y = b.sort(arr);

        for (int i=0; i< y.length; i++){
            System.out.printf("%d ", y[i] );

        }


        long afterTime = System.nanoTime();
        double secDiffTime = (afterTime - beforeTime)/1000000000.0;
        System.out.println("");
        System.out.println("시간(초) : "+secDiffTime);
    }
}