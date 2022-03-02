import java.util.Arrays;
import java.util.Scanner;

public class BS {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        int n= sc.nextInt();
        int answer = 1;
        while (n>0){
          int last_bit = (n&1);
          if(last_bit==1){
              answer *= a;
          }
          a = a*a;
          n=n>>1;
        }

        System.out.println(answer);
    }


}