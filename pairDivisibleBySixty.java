package pairSumDivBySixty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class pairDivisibleBySixty {
	int comb(int x){
		return x*(x-1)/2;
	}

	public static void main(String args[]) {
		pairDivisibleBySixty p = new pairDivisibleBySixty();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter numbers (comma separated): ");
		String input[] = s.nextLine().trim().split(" ");
		// System.out.println("Enter sum: ");
		// int sum = s.nextInt();
		s.close();
		float temp;
		//create hashmap of all values divided by 60
		HashMap<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i<input.length; i++){
			List<Integer> a = new ArrayList<Integer>();
			int rem = Integer.parseInt(input[i]) % 60;
			if(mp.containsKey(rem))
				a = mp.get(rem);
			a.add(Integer.parseInt(input[i]));
			mp.put( rem, a);  
		}
		int result = 0;
		if(mp.containsKey(0))
			result += p.comb(mp.get(0).size()) ;
		 
		if(mp.containsKey(30))
			result += p.comb(mp.get(30).size()) ; 
		
	    for(int i=1; i<30; i++){
	    		if(mp.containsKey(i) && mp.containsKey(60-i))
				result += mp.get(i).size() * mp.get(60-i).size();
	    }
	    
	    System.out.println(result);

	}
	

}
