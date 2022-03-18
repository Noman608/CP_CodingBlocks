	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n++; i++) {
			arr[i] = sc.nextInt();
		}

	}

	public static int find(int arr[], int n, int key) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[s] <= arr[mid]) {

				if (key >= arr[s] && key <= arr[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}

			} else {
				if (key >= arr[mid] && key <= arr[e]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
		}
		return -1;
	}
