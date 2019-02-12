package bookDemoV2;

import java.util.Scanner;

public abstract class AbstractBookView {
	
	
	
	public AbstractBookView() {
	}
	/**
	 * 本方法用来规定固定的程序逻辑
	 */
	public void doMainView() {
		String result = showMainView();
		switch(result) {
		case "1": //添加图书
			showAddNewBookView();
			showBooks(Datas.bookStore);
			break;
		case "2": //删除图书
			showDelBookView();
			break;
		case "3"://查看所有图书
			showBooks(Datas.bookStore);
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
			return;
		default:
			break;
		}
		doMainView();		
	}
	/**
	* 显示主菜单
	* @return 返回用户选择，“1”-“7”之间
	*/
	public abstract String showMainView();		
	
	public abstract void showOutStore();	
	
	public abstract void showInStore();	
	
	public abstract void showFindById();
	
	public abstract void showDelBookView();
	
	/**
	 * 新增图书界面
	 */
	public abstract void showAddNewBookView();
	/**
	 * 显示所有图书信息
	 * 如果传入的是null，默认是显示图书仓库中的数组：Datas.bookStore
	 * @param bookArray
	 */
	public abstract void showBooks(Book ... bookArray);
}
