import java.util.Scanner;
public class Bit {
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
    public static void main(String[] args) {
        BS b = new BS();
        Scanner sc =new Scanner(System.in);

        System.out.println(b.clearItoJ(31,1,3));

    }


}

