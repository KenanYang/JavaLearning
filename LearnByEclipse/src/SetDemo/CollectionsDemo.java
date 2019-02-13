package SetDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsDemo {
	public static void main(String[] args) {
		List<Integer> intCollection = new ArrayList<Integer>();
		intCollection.add(123);
		intCollection.add(120);
		intCollection.add(124);
		intCollection.add(122);
		intCollection.add(127);
		intCollection.add(126);
		
		intCollection.forEach(value -> System.out.print(value + ", "));
		
		Collections.shuffle(intCollection, new Random(20));
		System.out.println("\n乱序后：");
		intCollection.forEach(value -> System.out.print(value + ", "));
		
		Collections.shuffle(intCollection, new Random(20)); //当shuffle用的种子一样时，两次乱序后的结果一样
		System.out.println("\n乱序后：");
		intCollection.forEach(value -> System.out.print(value + ", "));
		
		System.out.println("\n集合的复制");
		List<Integer> int2Collection = new ArrayList<>();
		int2Collection.add(0); // 需要通过add先扩展空间
		int2Collection.add(0);
		int2Collection.add(0);
		int2Collection.add(0);
		int2Collection.add(0);
		int2Collection.add(0);
		Collections.copy(int2Collection, intCollection);//有了空间才能复制
		int2Collection.forEach(value -> System.out.print(value + ", "));
		
		//对比两个集合中有没有公共元素
		System.out.println(Collections.disjoint(intCollection, int2Collection));//有公共元素返回false，没有返回true
		
		System.out.println("返回集合中指定元素出现的次数：" + Collections.frequency(intCollection, 126));
		
		//补充：使用Arrays.asList转换成的List的集合中，无法使用add方法，因为数组大小已经固定
		List<String> strList = Arrays.asList("111","aaa","ddd");
//		strList.add("222");		
	}
}
