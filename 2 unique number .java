import java.util.Scanner;

public class BS {
    public static void main(String[] args) {
         BS b = new BS();
        Scanner sc =new Scanner(System.in);
        int xor =0 ;
        int n= sc.nextInt();
        int arry[] = new int[n];
        for(int i=0;i<n;i++){
            arry[i]=sc.nextInt();
            xor = xor ^ arry[i];
        }
        /* 1 way of creating musk */
//       int pos=0;
//        int temp = xor;
//        while((temp&1)==0){
//            pos++;
//            temp=temp>>1;
//        }
//        int mask = (1<<pos);

        /* 2 way of creating musk */
        int mask = xor & (-xor);

        int  x= 0,y = 0;
        for(int i=0;i<n;i++){
            if((arry[i] & mask) > 0){
                x=x^arry[i];
            }
        }
        y = xor^x;
        System.out.println(x +" "+y);


    }


}

