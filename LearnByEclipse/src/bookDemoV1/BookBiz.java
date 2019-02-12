package bookDemoV1;
/**
 * 图书的业务类
 * 包含对图书以及图书数组的基本操作
 * @author kenanyang
 *
 */
public class BookBiz {
	//开始书写基本的业务方法
	//增加图书、出库、入库、查询、排序
	/**
	 * 获得图书仓库中Datas.bookStore数组中图书对象的个数
	 * @return
	 */
	public int getBookCount() {
		int count = 0;
		for(Book book : Datas.bookStore) {
			if(book == null) break;
			count ++;
		}
		return count;
	}
	
	public int getBookCount(Book ... books) {
		int count = 0;
		for(Book book : books) {
			if(book == null) break;
			count ++;
		}
		return count;
	}
	
	/**
	 * 将传入的图书对象放置到图书仓库（数组）中去
	 * @param book
	 * @return 是否放置成功 - 假设图书仓库已满，返回false
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		if(Datas.bookStore.length == bookCount) {
			return false;
		}
		//如果仓库不满，就将传入的图书对象放置在数组的最后一个位置
		Datas.bookStore[bookCount] = book;
		return true;
	}
	/**
	 * 删除传入的图书对象
	 * @param book
	 * @return 是否删除成功
	 */
	public boolean delBook(Book book) {
		int bookCount = getBookCount();
		int delIndex = -1; //要删除的元素的下标
		for(int i = 0; i < bookCount; i++) {
			if(book.equals(Datas.bookStore[i])) {
				delIndex = i;
				break;
			}			
		}	
		if(delIndex == -1) {
			return false; //没有找到要删除的元素时，直接结束方法， 返回false
		}
		//执行数组删除的套路
		for(int i = delIndex; i < bookCount - 1; i++) {
			Datas.bookStore[i] = Datas.bookStore[i+1];
		}
		//将最后一个元素置为 null
		Datas.bookStore[bookCount - 1] = null;
		return true;
	}
	
	/**
	 * 通过图书id查找图书对象
	 * @param bookId
	 * @return 如果没有，返回null
	 */
	public Book findById(String bookId) {
		int bookCount = getBookCount();
		for (int i =0; i < bookCount; i++) {
			if(bookId.equals(Datas.bookStore[i].getBookId())) {
				return Datas.bookStore[i];
			}
		}
		return null;
	}
	/**
	 * 入库：为仓库现有的图书增加库存
	 * @param bookId
	 * @param count
	 * @return 如果入库的bookId不存在，入库失败
	 */
	public boolean inStore(String bookId, int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;
		}
		book.setCount(book.getCount() + count);
		return true;
	}
	
	/**
	 * 出库：将仓库现有库存减少
	 * @param bookId
	 * @param count
	 * @return 现有库存小于count时，出库失败
	 */
	public boolean outStore(String bookId, int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;
		}
		if(book.getCount() < count) {
			return false;
		}
		book.setCount(book.getCount() - count);
		return true;
	}
}
