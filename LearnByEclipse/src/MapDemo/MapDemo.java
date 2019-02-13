package MapDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 三种Map的基本用法
 * @author kenanyang
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		MapBasics();
		
	}
	
	public static void MapBasics() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Mongey.D.Luffy", 18);
		hashMap.put("Nami", 19);
		hashMap.put("Sanji", 25);
		hashMap.put("Nico Robin", 26);
		hashMap.put("Roronoa Zoro", 21);
		System.out.println("hashMap: "+ hashMap); //无序的
		
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("Mongey.D.Luffy", 18);
		linkedHashMap.put("Nami", 19);
		linkedHashMap.put("Sanji", 25);
		linkedHashMap.put("Nico Robin", 26);
		linkedHashMap.put("Roronoa Zoro", 21);
		System.out.println("linkedHashMap: "+ linkedHashMap);//储存顺序与插入顺序一样
		
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.putAll(hashMap); 
		System.out.println("treeMap: "+ treeMap);//比较器默认按key值排序存储
		
		Map<String, Integer> treeMap2 = new TreeMap<String, Integer>(new MyTreeComparator());
		treeMap2.putAll(hashMap); 
		System.out.println("MytreeMap: "+ treeMap2);//比较器默认按key值排序存储,现在是降序 
		
		
		Map<String, Integer> treeMap3 = new TreeMap<>(new MyTreeValueComparator(hashMap));
		treeMap3.putAll(hashMap);
		System.out.println("MytreeMap sort by value: "+ treeMap3);//比较器默认按key值排序存储,现在是降序
		
		
		//Map的遍历方式
		//1. 通过Map.keySet遍历key，通过key取出对应的value -- 比较常用，易用，但是要二次取值
		for(String key : treeMap.keySet()) {
			System.out.println(key + "--" + treeMap.get(key));
		}
		//2. 通过Map.entrySet使用迭代器遍历key和value
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Entry<String, Integer>> entrySetIt = entrySet.iterator();
		while(entrySetIt.hasNext()) {
			Entry<String, Integer> entry = entrySetIt.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		
		//3. 直接遍历map.entrySet集合 - 容量大时，推荐使用本方法遍历map
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}

class MyTreeComparator implements Comparator<String>{

	@Override
	public int compare(String key1, String key2) {
		if(key1.compareTo(key2) > 0) return -1;
		if(key1.compareTo(key2) < 0) return 1; //倒续
		return 0;
	}
	
}
/**
 * 按value值比较的TreeMap
 * @author kenanyang
 *
 */
class MyTreeValueComparator implements Comparator<String>{
	private Map<String, Integer> map;
	public MyTreeValueComparator(Map<String, Integer> map) {
		this.map = map;
	}
	
	@Override
	public int compare(String key1, String key2) {
		if(map.get(key1).intValue() > map.get(key2).intValue()) {
			return 1;
		}
		if(map.get(key1).intValue() < map.get(key2).intValue()) {
			return -1;
		}
		return 0;
	}
	
}

