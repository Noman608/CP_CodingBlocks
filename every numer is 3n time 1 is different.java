import java.util.Arrays;
import java.util.Scanner;

public class CP {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int sum[] = new int[64];
        for(int i =0 ;i<n;i++){
            int j=0;
            int number= sc.nextInt();
            while(number>0){
                int lastBit = (number & 1);
                sum[j] +=lastBit;
                j++;
                number = number>>1;
            }
        }
        int p=1;
       int answer=0;
        for(int i= 0;i<64;i++){
          sum[i] %= 3;
          answer += (sum[i]*p);
          p = p<<1;
        }
        System.out.println(answer);


    }


}

