package bookDemoV1;

import java.util.Scanner;

/**
 * 图书系统的视图
 * @author kenanyang
 *
 */
public class BookView {
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("****************************");
		System.out.println("欢迎使用图书管理系统");
		System.out.println("1.登陆\t\t2. 退出系统");
		System.out.println("****************************");
		System.out.println("请选择：");
		String choice = input.next();
		if("1".equals(choice)) {
			//执行登陆操作
			//如果验证成功，就显示主菜单
			System.out.println("登陆功能暂未实现，默认已登陆"); 
//			while(showMainView()) {}
			showMainView();
		}
		System.out.println("图书系统已成功退出，欢迎再次使用！");
	}
	/**
	 * 显示主菜单
	 * @return true表示继续显示主菜单， false退出
	 */
	public void showMainView() {
		System.out.println("图书管理系统 》主菜单");
		System.out.println("1.新增图书\n2.删除图书\n3.查看所有图书\n4.按编号查询\n5.入库 \n6.出库\n7.退出");
		System.out.print("请选择：");
		String choice  = input.next();
		switch(choice) {
		case "1": //添加图书
			showAddNewBookView();
			showBooks(Datas.bookStore);
			break;
		case "2": //删除图书
			showDelBookView();
			break;
		case "3"://查看所有图书
			showBooks(null);
			break;
		case "4"://按编号查询
			showFindById();
			break;
		case "5": //入库
			showInStore();
			break;
		case "6":
			showOutStore();
			break;
		case "7":
			//System.exit(0);
//			return false;
			return;
		default:
			break;
		}
//		return true;
		showMainView();
	}
	
	public void showOutStore() {
		System.out.println("图书管理系统 》图书出库");
		System.out.print("出库的图书编号：");
		String bookId = input.next();
		System.out.print("出库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.outStore(bookId, bookCount)) {
			System.out.println("出库成功！");
			showBooks(null);
		}else {
			System.out.println("出库失败，请检查输入的图书编号或出库数量是否超限！");
		}
	}
	
	
	public void showInStore() {
		System.out.println("图书管理系统 》图书入库");
		//入库需要两个参数：图书id，入库的数量
		System.out.print("入库的图书编号：");
		String bookId = input.next();
		System.out.print("入库的数量：");
		int bookCount = input.nextInt();
		if(bookBiz.inStore(bookId, bookCount)) {
			System.out.println("入库成功");
			showBooks(null);
		}else {
			System.out.println("入库失败，请检查输入的图书编号");
		}
	}
	
	
	public void showFindById() {
		System.out.println("图书管理系统 》按编号查询");
		System.out.println("请输入要查询的图书编号：");
		String bookId = input.next();
		Book book = bookBiz.findById(bookId);
		if(book == null) {
			System.out.println("没有找到任何的图书信息！");
			return;
		}
		showBooks(book);
	}
	
	public void showDelBookView() {
		System.out.println("图书管理系统 》删除图书");
		//暂时根据id删除
		System.out.print("请输入要删除的图书编号：");
		String delId = input.next();
		Book delBook = new Book();
		delBook.setBookId(delId);
		if (bookBiz.delBook(delBook)) {
			System.out.println("删除成功！");
			showBooks(null); //打印默认的图书仓库
		}else {
			System.out.println("删除失败！");
		}
	}
	
	/**
	 * 新增图书界面
	 */
	public void showAddNewBookView() {
		System.out.println("图书管理系统 》新增图书");
		System.out.println("内部编号");
		String bookId = input.next();
		//验证用户输入的编号是否存在
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null) {
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("名称：");
			newBook.setBookName(input.next());
			System.out.print("库存：");
			newBook.setCount(input.nextInt());
			//.........
			bookBiz.addBook(newBook);
		}else {
			System.out.println("次内部编号已存在，请重新录入！");
			showAddNewBookView();
		}		
	}
	/**
	 * 显示所有图书信息
	 * 如果传入的是null，默认是显示图书仓库中的数组：Datas.bookStore
	 * @param bookArray
	 */
	public void showBooks(Book ... bookArray) {
		System.out.println("编号\t\t名称\t\t库存");
		if(bookArray == null) {
			bookArray = Datas.bookStore;
		}
		int bookCount = bookBiz.getBookCount(bookArray);
		for(int i=0;i<bookCount;i++) {
			System.out.printf("%s\t\t%s\t\t%d\n",
					bookArray[i].getBookId(), bookArray[i].getBookName(), bookArray[i].getCount());
		}
	}
}
