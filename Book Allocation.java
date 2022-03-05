import java.util.Scanner;

public class STACK {
    static int findpage(int arr[], int n, int m){
        int sum =0;
        if(n<m)
            return -1;
        for(int i=0;i<n;i++)
            sum += arr[i];
        int s = arr[n-1];
        int e = sum;
        int ans = 1000000000;
        while(s<=e){
            int mid = (s+e)/2;
            if(isPossible(arr,n,m,mid)){
                ans =Math.min(ans,mid);
                e = mid -1;
            }
            else {
                s =mid +1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int n, int m, int curent_mid) {
        int student=1;
        int pasges_reading =0;
        for(int i=0 ;i<n;i++){
            if(pasges_reading+arr[i]>curent_mid){
                student++;
                pasges_reading = arr[i];
                if(student>m)
                    return false;
            }
            else {
                pasges_reading  += arr[i];
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        int t ;
        Scanner sc =new Scanner(System.in);
        t =sc.nextInt();
        for(int i =0;i<t;i++){
            int n ,m;
            n = sc.nextInt();//number of book pages
            m =sc.nextInt();
            int arr[] =new int[n];
            for(int j =0 ;j<n;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(findpage(arr,n,m));
        }
    }
}

