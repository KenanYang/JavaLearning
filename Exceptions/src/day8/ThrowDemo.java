package day8;
/**
 * 演示手动抛出异常
 * @author kenanyang
 *
 */
public class ThrowDemo {
	public static void main(String[] args) {
		Hero hero = new Hero("貂蝉");
		try {
			hero.setExp(-1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("当前英雄的经验值:" + hero.getExp());
	}
}


class Hero{
	private String name;
	private long exp;
	public Hero(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) throws Exception {
		if (exp >= 0)
			this.exp = exp;
		else
			throw new Exception("经验值不能为负数！");
		
	}
	
	
}