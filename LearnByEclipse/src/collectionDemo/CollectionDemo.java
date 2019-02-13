package collectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionDemo {

	public static void main(String[] args) {
		//多态：使用list接口的一个子类ArrayList进行实现
		List<String> list1 = new ArrayList<String>();
		list1.add("曹操");
		list1.add("曹冲");
		list1.add("曹植");
		list1.add("曹培");
		list1.add("曹仁");
		System.out.println(list1);
		list1.add(1, "刘玄德");
		System.out.println(list1);
		list1.set(1, "关云长");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("张飞");
		list2.add("赵云");
		
		list1.addAll(list2);
		System.out.println(list1);
		
		System.out.println("集合的遍历");
		//1. List 遍历
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + ", ");
		}
		System.out.println();
		//2. for-each
		for(String str : list1) {
			System.out.print(str + ", ");
		}
		System.out.println();
		//3. 使用迭代器
		Iterator<String> it = list1.iterator();
		//The method of using iterator
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		//4. 使用ListIterator迭代器
		ListIterator<String> listIt = list1.listIterator();
		while(listIt.hasNext()) {
			System.out.print(listIt.next() + ", ");
		}
		System.out.println();
		//ListIterator 与 Iterator 的区别
		//1、ListIterator不止可以向后访问，也可以向前访问
		//2、ListIterator可以修改集合中的元素， 传统的Iterator只能访问
		System.out.println("使用ListIterator从后向前遍历（逆序）");
		ListIterator<String> listIt2 = list1.listIterator(list1.size());
		while(listIt2.hasPrevious()) {
			System.out.print(listIt2.previous() + ", ");
		}
		System.out.println();
		
		ListIterator<String> listIt3 = list1.listIterator(3);
		if(listIt3.hasPrevious()) {
			listIt3.previous();
			listIt3.set("赵子龙");//使用迭代器修改元素
		}		
		System.out.println(list1);
		
		System.out.println("删除下标为4的元素：");
//		list1.remove(4);
		list1.remove("曹培");
		System.out.println(list1);
		
		System.out.println("subList(3,5):" + list1.subList(3, 5));
		
	}
	/**
	 * 使用迭代器的好处：在遍历集合时，不依赖某个类的实现
	 * @param it
	 */
	public void show(Iterator<? extends Employ> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class Employ{}