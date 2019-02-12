package bookDemoV1;

public class Datas {
	/** 用来保存所有图书信息的数组 -  */
	public static Book[] bookStore = new Book[999];
	
	//使用静态块为图书仓库数组添加书籍信息，以便测试
	static {
		Book book1 = new Book();
		book1.setBookId("1000");
		book1.setBookName("老九君");
		book1.setIsbn("100-101");
		book1.setCount(10);
		book1.setPrice(99.9);
		bookStore[0] = book1;
		
		Book book2 = new Book();
		book2.setBookId("1001");
		book2.setBookName("老九君1");
		book2.setIsbn("100-102");
		book2.setCount(10);
		book2.setPrice(99.9);
		bookStore[1] = book2;
		
		Book book3 = new Book();
		book3.setBookId("1002");
		book3.setBookName("老九君3");
		book3.setIsbn("100-103");
		book3.setCount(10);
		book3.setPrice(99.9);
		bookStore[2] = book3;
		
		Book book4 = new Book();
		book4.setBookId("1003");
		book4.setBookName("老九君4");
		book4.setIsbn("100-104");
		book4.setCount(10);
		book4.setPrice(99.9);
		bookStore[3] = book4;
		
		Book book5 = new Book();
		book5.setBookId("1004");
		book5.setBookName("老九君5");
		book5.setIsbn("100-105");
		book5.setCount(10);
		book5.setPrice(99.9);
		bookStore[4] = book5;
	}
}
