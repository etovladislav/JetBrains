package ru.kpfu.itis.group11408.etovladislav.jb.task1;

import java.util.HashMap;
import java.util.Map;

public class NonRecurring {
	Map<Character, Integer> map;

	public NonRecurring() {
		this.map = new HashMap<Character, Integer>();
	}

	public int find(String str) {
		//if V == v 
		//str = str.toLowerCase();
		char symbol;
		for (int i = 0; i < 2; i++) {
			for (int index = 0; index < str.length(); index++) {
				if (i == 0) {
					symbol = str.charAt(index);
					map.put(symbol, map.get(symbol) == null ? 0 : 1);
				} else if (i == 1) {
					if (map.get(str.charAt(index)) == 0) {
						return index;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		NonRecurring task1 = new NonRecurring();
		System.out.println(task1.find("Vladislav"));
	}
}
