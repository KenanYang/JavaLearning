public class staticDemo{


    //单利模式：该类只能被实例化一次

    private static staticDemo me = null;
    // 将构造函数私有，以便实现外部无法使用new进行实例化的效果
    private staticDemo(){
        //将构造方法定义为私有
        me = this;
    }
    // 要获得当前类对象的实例，只能调用本方法
    public static staticDemo getInstance(){
        if(me == null){
            me = new staticDemo(); //在类中实例化，唯一的一次实例化
        }
        return me;
    }


    //类属性/方式是先于实例存在的
    public static int static_number = 1;

    public int normal_number = 1;

    // public void test(){
    //     static_number++;
    //     normal_number++;
    // }
    /**
    * 静态方法只能调用静态属性和静态方法
    */
    // public static void main(String[] args){
    //     staticDemo staticDemo1 = new staticDemo();
    //     staticDemo1.test();

    //     System.out.println(staticDemo1.static_number);
    //     System.out.println(staticDemo1.normal_number);

    //     staticDemo staticDemo2 = new staticDemo();
    //     staticDemo2.test();
    //     System.out.println(staticDemo.static_number); //可以直接用类名来调用类属性
    //     System.out.println(staticDemo2.normal_number);

    // }
}
