package bookDemoV2;

public class Main {

	public static void main(String[] args) {
//		new BookView();
//		AbstractBookView bookView = new BookViewConsoleImpl();
//		AbstractBookView bookView = new BookViewDialogImpl();  
//		bookView.doMainView();
		
		
//		FileUtil.SaveBooks(Datas.bookStore);
		Book[] bookArray = FileUtil.LoadBooks();
		for(Book book : bookArray) {
			if(book == null) break;
			System.out.println(book.getBookId() + "\t" + book.getBookName());
		}
	}
}