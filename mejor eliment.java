import java.util.ArrayList;

import java.util.List;

public class Majority_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ec = 0;
		int e = 0;
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(1);
		a.add(1);

		for (int i = 0; i < a.size(); i++) {
			if (ec == 0)
				e = a.get(i);
			if (a.get(i) == e)
				ec++;
			else 
				ec--;
		}
		ec = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == e)
				ec++;
		}
		if (ec > a.size() / 3)
			System.out.println(e);

	}

}
