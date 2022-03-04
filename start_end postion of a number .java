import java.util.Arrays;
import java.math.BigInteger;
public class BS {


    public static void main(String[] args) {

      int arr[] ={1,1};
      int key =1;
        System.out.println( first_ocurrance(arr,arr.length,key));
        System.out.println( second_ocurrance(arr,arr.length,key));

    }

    public static int first_ocurrance(int[] arr, int length, int key) {
        int start =0 ,ans =-1;
        int end = length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                ans = mid;
                end=mid-1;
            }
            else if(arr[mid]>key)
                end =mid-1;
            else
                start= mid+1;
        }
        return ans;
    }
    public static int second_ocurrance(int[] arr, int length, int key) {
        int start =0 ,ans =-1;
        int end = length;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                ans = mid;
                start=mid+1;
            }
            else if(arr[mid]>key)
                end =mid-1;
            else
                start= mid+1;
        }
        return ans;
    }


}

