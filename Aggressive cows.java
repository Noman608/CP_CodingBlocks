
public class BS {
    public  void main(String[] args) {
        int arr[]={1,2,4,8,9};
        int n = 5;
        int cows = 3;
        int s = 0;
        int e = arr[n-1]-arr[0];
        int answer= 0;
        while(s<=e){
            int mid = (s+e)/2;
            boolean x = CowRahkle(arr,n,cows,mid);
            if(x == true){
              answer =mid;
              s = mid + 1;
            }
            else
                e = mid-1;
        }

    }

      boolean CowRahkle(int arr[], int n, int cows, int mid){
             int last_cow = arr[0];
             int count = 1;
             for(int i = 1 ; i<n; i++){
                 if(arr[i]-last_cow>=mid){
                     last_cow = arr[i];
                     count++;
                     if (count==cows)
                         return true;
                 }
             }
        return false;
    }

}

