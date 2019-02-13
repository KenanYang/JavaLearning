package QueueDemo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
//		LinkedListDemo();
		ArrayDequeDemo();
	}

	public static void LinkedListDemo() {
		Queue<String> queue = new LinkedList<String>();
		System.out.println("出对操作：" + queue.poll());//尽量使用poll, remove如果没有元素的话会出错
		queue.offer("George Washingto");
		queue.offer("John Adams");
		queue.offer("Thomas Jefferson");
		queue.offer("James Madison");
		queue.offer("James Monroe");
		
//		System.out.println("出队操作：" + queue.poll());
		System.out.println("出对操作：" + queue.peek());

		queue.forEach(str -> System.out.println(str + ", "));
		//PriorityQueue优先队列
		//可以使用Comparable以元素的自然顺序进行排序，或使用自定义的Comparator子类按指定的顺序排序
		//拥有最小值的元素被赋予最高优先级，因此最先删除
		// It is a min heap
		queue = new PriorityQueue<String>();
	}
	
	public static void ArrayDequeDemo() {
		//ArrayDeque是一个基于数组实现的双端队列，默认底层数组的长度为16，不仅可以作为queue使用，还可以作为stack使用
		//当元素超过集合的大小时，系统会在底层重新分配一个Object数组来存储
		ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
		//queue  offer - poll
//		arrayDeque.offer("George Washingto");
//		arrayDeque.offer("John Adams");
//		arrayDeque.offer("Thomas Jefferson");
//		arrayDeque.offer("James Madison");
//		arrayDeque.offer("James Monroe");
//		System.out.println("出队操作：" + arrayDeque.poll());
//		arrayDeque.forEach(str -> System.out.println(str + ", "));
		
		//建议：尽量使用ArrayDeque当作stack，push - pull 避免使用Stack，该类较老
		
		arrayDeque.push("George Washingto");
		arrayDeque.push("John Adams");
		arrayDeque.push("Thomas Jefferson");
		arrayDeque.push("James Madison");
		arrayDeque.push("James Monroe");
		System.out.println("入栈：");
		arrayDeque.forEach(str -> System.out.println(str + ", "));
		
		System.out.println("出栈：" + arrayDeque.pop());
		arrayDeque.forEach(str -> System.out.println(str + ", ")); //FILO 
	}
	
	
}
