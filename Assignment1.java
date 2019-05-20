
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.*;


public class Assignment1 {
	
	
	public static void main(String[] args) {
		List<Subscription> subs = loadSubscriptions();
		TreeMap<Long, TreeMap<Integer, Integer>> treeception = new TreeMap<Long, TreeMap<Integer, Integer>>();
		// TreeMap<String, Integer> sort = new TreeMap<String, Integer>();
		for(Subscription sub: subs)
		{
			TreeMap<Integer, Integer> tree = treeception.get(sub.getUserId());
			if(tree == null)
			{
				treeception.put(sub.getUserId(), new TreeMap<Integer, Integer>());
				treeception.get(sub.getUserId()).put(sub.getProgramCode(), 1);
			}
			else 
			{
				
				// System.out.println(sub.getUserId() +" "+ sub.getProgramCode());
				// 	System.out.println(tree.get(sub.getProgramCode()));
				if(tree.get(sub.getProgramCode()) == null) {
					tree.put(sub.getProgramCode(), 1);
				} else {
					tree.replace(sub.getProgramCode(), 1+tree.get(sub.getProgramCode()));
					 // if (tree.get(sub.getProgramCode()) > 1 && sub.getProgramCode()!=42){
					 // sort.put(Integer.toString(sub.getUserId))
					 // }
						// System.out.println(sub.getUserId() +" "+ sub.getProgramCode());
					// System.out.println(tree.get(sub.getProgramCode()));
						
				}
			}
			
		}
		
		ArrayList<long[]> sort = new ArrayList<long[]>();
		for(Map.Entry<Long, TreeMap<Integer, Integer>> entry : treeception.entrySet()) {
		  long key = entry.getKey();
		  TreeMap<Integer, Integer> value = entry.getValue();
			for(Map.Entry<Integer, Integer> e : value.entrySet()) {
				if(e.getValue() >= 2 && e.getKey() !=42)
					sort.add(new long[]{key, (long)e.getKey(), (long)e.getValue()});
				 // System.out.println(key + " => " + e.getKey() + " " + e.getValue());
			}
		}

		sort.sort(Comparator.comparingLong(el -> el[2]));
		for(int i = sort.size()-1; i >= 0; i--){
			System.out.println(sort.get(i)[0] + " " + sort.get(i)[1]);
		}		
		// TODO: your code here
		
	}
	
	public static List<Subscription> loadSubscriptions() {
		List<Subscription> subs = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			Subscription s = new Subscription(in.nextLong(), in.nextInt(), in.nextInt());
			subs.add(s);
		}
		return subs;
	}
	
}

