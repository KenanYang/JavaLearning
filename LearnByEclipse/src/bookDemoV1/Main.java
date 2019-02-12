package bookDemoV1;

public class Main {

	public static void main(String[] args) {
		new BookView();
		
//		Book newBook = new Book();
//		newBook.setBookId("10");
//		newBook.setBookName("天龙八部");
//		newBook.setCount(10);
//		 
//		BookBiz bookBiz = new BookBiz();
//		bookBiz.addBook(newBook);
//		
//		show();
//		bookBiz.inStore("10", 100);
//		show();
//		bookBiz.outStore("10", 100);
//		show();
	}
	
	public static void show() {
		BookBiz bookBiz = new BookBiz();
		if(bookBiz.getBookCount() == 0) {
			System.out.println("仓库空空如也！");
		}
		for(int i = 0; i < bookBiz.getBookCount(); i++) {
			System.out.println(Datas.bookStore[i].getBookId() + "\t" + Datas.bookStore[i].getBookName() + "\t" + Datas.bookStore[i].getCount());
		}
	}
}
