# 컴퓨터 알고리즘 9주차 과제
----------------------
## 201701643 고희수
----------------------

#### 1. 선택/삽입/쉘 정렬이란?
* 선택정렬
> 입력 배열에서 최소값을 선택하여 0번 원소와 자리를 바꾸고, 이후 0번 원소를 제외한 나머지에서 최소값을 선택하여 1번원소와 자리를 바꾼다.
<img width="253" alt="선택정렬" src="https://user-images.githubusercontent.com/51106969/116845928-33a13300-ac22-11eb-8e41-b74c992f92fa.PNG">{: width="100" height="100"}
<center><img width="270" alt="선택정렬2" src="https://user-images.githubusercontent.com/51106969/116845932-34d26000-ac22-11eb-9441-30252e929d22.PNG">{: width="100" height="100"}</center>


* 삽입정렬
> 배열을 정렬 부분과 정렬 되지 않은 부분으로 나누고, 정렬 되지 않은 부분의 가장 왼쪽 원소를 정렬 부분의 적절한 위치에 삽입하여 정렬한다.
![image](https://user-images.githubusercontent.com/51106969/116845483-eff9f980-ac20-11eb-88e7-344c314bd1cb.png)

* 셸정렬
> 버블정렬, 삽입정렬의 단점(작은 숫자가 배열의 앞부분으로 매우 느리게 동작하며 모든 숫자들이 한칸 씩 이동해야한다는 점)을 보완하기 위해 삽입 정렬을 이용하여 뒷부분의 작은 숫자들을 빠르게 이동시킨다. 동시에 앞부분의 큰 숫자는 뒷부분으로 이동시키고 마지막에는 삽입정렬을 수행한다.
![image](https://user-images.githubusercontent.com/51106969/116846174-b6c28900-ac22-11eb-8ed0-a600e629bb95.png)
![image](https://user-images.githubusercontent.com/51106969/116846210-c4780e80-ac22-11eb-9816-2ef63dff223d.png)
![image](https://user-images.githubusercontent.com/51106969/116846276-e70a2780-ac22-11eb-8e01-404dae687387.png)
---------------------
#### 2. 소스코드
* Main
```java
        for (int i =0; i< arr.length; i++){
            arr[i] = Integer.parseInt(scanner.next());
        }
        AwesomeSort b = new SelectionSort(); 
        // (bubble,selection,insertion,shell)Sort 중 선택

        for(int j : arr) System.out.printf("%d ", j);
        System.out.println("");
        int [] y = b.sort(arr);
        
        for (int i=0; i< y.length; i++){
            System.out.printf("%d ", y[i] );

        }
```

``` java
        long beforeTime = System.nanoTime();
...
        long afterTime = System.nanoTime();
        double secDiffTime = (afterTime - beforeTime)/1000000000.0;
        System.out.println("");
        System.out.println("시간(초) : "+secDiffTime);
```
> 시간 측정을 위해 nanoTime 함수를 이용

```java
        for (int j=0; j<arr.length;j++){
            arr[j] = r.nextInt(10000);
        }
            for (int i=0; i< arr.length;i++){ // reverse
                for (int k = i; k<arr.length; k++){
                    if (arr[k] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
```
> 배열 역순 입력 (reverse)

* SelectionSort
```java
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
```
* InsertionSort
```java
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
```
* ShellSort
```java
        int [] x = arr.clone();
        int n = arr.length;

        for (int h=n/2; h>0; h=h/2) // 간격 gap
            for (int i=h; i<n;i++){
                int temp = x[i];
                int j;
                for (j=i-h; j>=0 && x[j]>temp; j-=h){
                    x[j+h]=x[j];
                }
                x[j+h] = temp;
            }
        return x;
```
-----------------------
#### 3. 결과분석
![image](https://user-images.githubusercontent.com/51106969/116883697-dbd5ec80-ac60-11eb-971f-6256b3754771.png)
> int [] arr = new int [?] 를 통해 입력의 개수를 달리하여 코드 실행 후 표를 작성하였다.

> 위 표를 통해 정렬되어 있는 입력,reverse 입력 (data : 120000)에 대해서 선택정렬이 가장 느리다는 것을 확인할 수 있으며 삽입정렬과 셸정렬은 reverse 입력에 대해서도 비교적 좋은 성능을 보여주고 있다는 것을 알 수 있다.
> 셸정렬은 삽입정렬보다 조금 빠른 속도를 가지고 있다.

-----------------------
#### 4. 셸정렬의 효율성 높이기
셸정렬은 가장 빠르다고 알려진 퀵정렬 보다 성능이 우수하다. 퀵정렬은 데이터의 개수가 많아지면 성능이 떨어지는 반면 셸정렬은 그렇지 않기 때문이다.
셸정렬의 효율성을 더 높이기 위해서는 gap(간격)을 잘 설정해야 한다. 이에 관한 연구로 수열(보조 증분 수열)을 이용한 방법이 있다.
![image](https://user-images.githubusercontent.com/51106969/116888075-024a5680-ac66-11eb-9392-b9235afd5241.png)
> 보조 증분 수열이란 1을 향해 감소하는 자연수열이다.


셸정렬에서 무작위 입력에 대한 평균적인 비교 횟수가 어떻게 되는 지 수학적인 결론은 나와있지 않다. 하지만 일반적인 N값에 대해 증가율의 차이가 구별하기 어려울 정도로 작기 때문에 학문적으로만 의미가 있다. (by Robert Sedgewick)

Robert Sedgewick의 연구
( h(n) = 3 * h(n-1) + 1 , h(1) = 1 )
에 따라 간격을 1,4,13,40,121,364,1093 으로 대체하면 성능이 더 좋아진다.
> 실제로 60000개의 데이터를 입력했을 때 
``` java
        for (int h = 1; h<n; h=3*h+1) // robert sedgewick
        for (int h=n/2; h>0; h=h/2) // 일반
```
> 첫번째 줄의 for문에서는 6.21초의 시간이 걸렸으며 두번째 줄의 for문에서는 11.58초의 시간이 걸렸다. 

만약 정렬 문제에 대한 해결책이 필요하고, 시스템 차원에서의 정렬 기능이 제공되지 않는 환경(HW, 임베디드 시스템)이라면 셸정렬을 선택하는 것이 안전하다.












