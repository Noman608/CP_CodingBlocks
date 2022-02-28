import java.util.Scanner;

public class BS {
     int getBit(int n ,int i){
        int mask= (1<<i);
        int bit = (n & mask) > 0 ? 1:0;
        return bit;
    }
    int UpdateNum(int n,int i){
         int mask = ~(1<<i);
         int bit = n & mask;
         return bit;
    }
    int changeAperticularBit(int n,int p,int cng){
         int mask = (1<<p);
         return (n & ~mask)|(cng<<p);
    }
    int setBit(int n, int i){
         int mask =(1<<i);
         int bit = (n | mask);
         return bit;
    }
    int clearBit(int n,int p){
         int mask = ~0;
         int q = mask<<p;
         return (n & q);
    }
    int clearItoJ(int n,int i,int j){
         int mask = ((~0)<<j+1) | (1<<i)-1;
         return n & mask;
    }
    int ClearBit_forreplaceBit(int n,int i,int j){
         int a =(~0)<<j+1;
         int b = (1<<i)-1;
         int mask = a|b;
         return n & mask;
    }
    int replaceBit(int n ,int m,int i,int j){
      int n_ = ClearBit_forreplaceBit(n,i,j);
      return  n_ | (m<<i);
    }
    int NUmOFSetBits(int n){
//         int add=0;
//         while(n>0) {
//             add = add + (n & 1);
//             n = n >> 1;
//         }
//      return add;
        int add =0;
        while(n>0){
            n = n & (n-1);
            add++;
        }
        return add;
    }

    int binaryRayOfN(int n){
         int p=1;
         int answer=0;
         while(n>0){
             int lastBit = n&1;
             answer = answer + (p * lastBit);
             p= p*10;
             n= n>>1;
         }
         return answer;
    }
    public static void main(String[] args) {
         BS b = new BS();
        Scanner sc =new Scanner(System.in);

        System.out.println(b.binaryRayOfN(100000));

    }


}

