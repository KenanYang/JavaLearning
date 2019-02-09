public class StaticDemoTest{
    public static void main(String[] args){
        //使用单例模式,所有创建的实例都指向同一个实例的地址
        staticDemo staticDemo1 = staticDemo.getInstance();

        System.out.println(staticDemo1.static_number);//1
        System.out.println(staticDemo1.normal_number);//1

        staticDemo staticDemo2 = staticDemo.getInstance();
        staticDemo2.normal_number = 1024;

        staticDemo staticDemo3 = staticDemo.getInstance();
        System.out.println(staticDemo3.normal_number);//1024

        System.out.println(staticDemo1 ==  staticDemo3); // true
    }
}
