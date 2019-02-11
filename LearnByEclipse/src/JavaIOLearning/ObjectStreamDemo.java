package JavaIOLearning;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化和反序列化操作
 * 前提：对象必须实现Serializable接口（序列化接口）
 * @author kenanyang
 *
 */

public class ObjectStreamDemo {
	private static final String FilePath = "src/JavaIOLearning/Object.dat";
	public static void main(String[] args) {
		Player player1 = new Player("我的世界你不懂", 99);
		
		//使用对象流将序列化的对象写入到文件中
		try(
			FileOutputStream fOutStream = new FileOutputStream(FilePath);
			ObjectOutputStream objOutStream = new ObjectOutputStream(fOutStream)
		){
			objOutStream.writeObject(player1);
			System.out.println("对象写入成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//从文件中读取对象内容，转换成我们可操作的对象
		try (
			FileInputStream fInStream = new FileInputStream(FilePath);
			ObjectInputStream objInStream = new ObjectInputStream(fInStream)
		){
			Player player2 = (Player) objInStream.readObject();
			System.out.println("读取出的对象内容：" + player2);
			System.out.println(player1 == player2); //false 比较的两个对象的地址
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Player implements Serializable{
	
	private static final long serialVersionUID = -2047225903353074769L;
	
	private String nickName;
	private int level;
	
	public Player() {}
	
	public Player(String nickName, int level) {
		setNickName(nickName);
		setLevel(level);
	}
	
	@Override
	public String toString() {
		return nickName + "\t" + level;
	}  
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}