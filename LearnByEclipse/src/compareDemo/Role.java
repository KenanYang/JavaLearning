package compareDemo;

public class Role {//implements Comparable<Role>{
	private String name;
	private String title;
	private int hp;
	private int attack;
	
	
	
	public Role(String name, String title, int hp, int attack) {
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.attack = attack;
	}
	
	//重写equals方法，以便在集合中可以自动通过对象比较的方式进行删除元素
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Role)) {
			return false; //传入对象类型不必配，直接返回false
		}
		Role role = (Role) obj;
		//两个对象的name属性相同，就表示两个对象相同
		return getName().equals(role.getName());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

//	@Override
//	public int compareTo(Role role) {
//		// 为了能够使用Colletions工具类中的sort方法进行默认的排序，实现类要实现Comparable接口
//		// 为了方便观察，我们在比较对象的时候，使用hp属性进行比较
//		if(hp > role.getHp()) return 1;
//		if(hp < role.getHp()) return -1;
//		return 0;
//	}

}
