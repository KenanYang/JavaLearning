package SingleMode;

public class SingleModelTest{
    public static void main(String[] args) {
        //SingleMode single = new SingleMode();
        SingleModelDemo single1 = SingleModelDemo.getInstance();
        System.out.println(single1.count); // 1
        single1.count++;

        SingleModelDemo single2 = SingleModelDemo.getInstance();
        System.out.println(single2.count); // 2

        System.out.println(single1 == single2); // true
    }
}
