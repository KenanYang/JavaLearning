package collectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListDemo {
	/**
	 * 在实际开发中，有可能两种情况（随机访问和删除、插入）交替出现
	 * 建议使用夫接口List，不用关心具体的实现
	 * 在具体的情况下，传入或转换成相应的子类型使用即可
	 * 使用list.addAll(c)进行转化 （ArrayList和LinkedList）之间
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("ArrayList耗时：" + CostTime(new ArrayList<>())); 
		System.out.println("LinkedList耗时：" + CostTime(new LinkedList<>())); 
	}
	
	public static long CostTime(List<Object> list) {
		Object obj = new Object();
		final int  N = 150000;
		//使用前根据任务类型，使用父类List的addAll进行转换为LinkedList或ArrayList
		List<Object> newList = new LinkedList<Object>();
		newList.addAll(list);
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
//			list.add(0, obj); // 2185ms - 8ms
//			list.add(obj); // 7ms - 10ms
			newList.add(0, obj); // 11ms - 7ms
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}
