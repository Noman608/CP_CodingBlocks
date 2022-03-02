import java.util.Arrays;
import java.util.Scanner;

public class BS {
    public void CharDisplay(int n ,char arr[]){
        int i=0;
            while(n>0){
                int lastBit = n&1;
                if(lastBit==1)
                    System.out.print(arr[i]);
                n = n>>1;
                i++;
            }
    }
    public  void sendSettodisplay(char arr[]){
       int n = arr.length;
       for(int i =0;i<(1<<n);i++){
           CharDisplay(i,arr);
           System.out.println();
       }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char arr[]={'a','b','c','d'};
        BS b= new BS();
        b.sendSettodisplay(arr);

    }


}

