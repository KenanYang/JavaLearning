package compareDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Business Class of Roles
 * @author kenanyang
 *
 */
public class RoleBiz {
//	Role[] roleArray = new Role[999];
	List<Role> roleList = null;
	
	public RoleBiz() {
		roleList = new ArrayList<Role>();
	}
	
	public void add(Role role) {
		if(role != null) {
			roleList.add(role);
		}
	}
	
	public void delete(Role role) {
		roleList.remove(role); //判断相同才可以删除，因此需要重写equals方法，否则判断的是两个obj的地址
	}
	/**
	 * 将传入的角色对象在集合中进行修改
	 * @param role
	 */
	public void update(Role role) {
		//1. 在集合中找到这个对象
		//2. 修改对象
		int index = roleList.indexOf(role);//默认是按照equals来找的
		if(index != -1) {
			roleList.set(index, role);
		}	
	}
	
	public void sort() {
		//1. 自己实现排序算法：冒泡、拆入、快速
		//2. 使用内置的工具类进行排序 - 前提条件：必须实现比较急接口
		//2-1: 实体类实现Comparable接口
//		Collections.sort(roleList);
//		Collections.reverse(roleList); // 反转达到逆序降序
		//2-2: 自定义一个比较器对象接口 	 - 更加灵活
		Collections.sort(roleList, new RoleComparator_Attack());//顺序
		//基于RoleComparator_Attack的逆序
//		Collections.sort(roleList, Collections.reverseOrder(new RoleComparator_Attack()));//逆序
		
		//乱序
//		Collections.shuffle(roleList);
	}
	
	
	public void show() {
		System.out.println("角色\t称号\t\t气血\t攻击力");
		System.out.println("---------------------------------------");
		Iterator<Role> roleIt = roleList.iterator();
		while(roleIt.hasNext()) {
			Role role = roleIt.next();
			System.out.println(role.getName() + "\t" + role.getTitle() + "\t\t" + role.getHp() + "\t" + role.getAttack());
		}
	}
}
/**
 * 角色类中攻击力的比较器
 * @author kenanyang
 *
 */
class RoleComparator_Attack implements Comparator<Role>{

	@Override
	public int compare(Role role1, Role role2) {
		if(role1.getAttack() > role2.getAttack()) return 1;
		if(role1.getAttack() < role2.getAttack()) return -1;
		return 0;
	}
	
}