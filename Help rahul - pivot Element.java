
public class BS {
    public static void main(String[] args) {
        int arr[]={4,5,1,2,3};
        int key = 1;
        System.out.println(findElement(arr,arr.length,key));
    }

    static int findElement(int arr[], int n, int key) {
        int s=0;
        int e = n-1;
        while(s<=e){
            int mid= (s+e)/2;
            if (arr[mid]==key)
                return mid;
            else if(arr[s]<=arr[mid]){
                if(key>=arr[s]&&key<=arr[mid])
                      e = mid-1;
                else
                      s=mid+1;
            }
            else {
                if(key>=arr[mid]&& key<=arr[e])
                    s = mid+1;
                else
                    e = mid -1;
            }
        }
        return -1;
    }

}

