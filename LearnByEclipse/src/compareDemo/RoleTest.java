package compareDemo;

public class RoleTest {

	public static void main(String[] args) {
		RoleBiz biz = new RoleBiz();
		biz.add(new Role("梅长苏", "麒麟才子1", 50, 450));
		biz.add(new Role("梅短苏", "麒麟才子2", 150, 350));
		biz.add(new Role("梅中苏", "麒麟才子3", 250, 250));
		biz.add(new Role("梅狼苏", "麒麟才子4", 350, 150));
		biz.add(new Role("梅有苏", "麒麟才子5", 450, 50));	
		
		biz.show();
		System.out.println();
//		Role role4 = new Role("梅狼苏", "麒麟才子4", 350, 150);
//		biz.delete(role4);
//		biz.show();
		
		biz.update(new Role("梅狼苏", "4麒麟才子", 350, 150));
		biz.show();
		System.out.println();
		
		System.out.println("排序：");
		biz.sort();
		biz.show();
	}

}
