package SingleMode;

public class SingleModelDemo {

    private static SingleModelDemo me = null;

    public int count = 0;
    private SingleModelDemo(){
        count++;
    }

    public static SingleModelDemo getInstance(){
        if(null == me)
            me = new SingleModelDemo();
        return me;
    }

}
