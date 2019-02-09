// 静态声明的String是static final的，会在字符串池中创建常量，该字符串地址不会改变
// 动态声明的String不会进字符串池，所创建的object在动态区有自己的新地址

public class CharPool{
    public static void main(String args[]){
        String value = "第一段";
        value += "第二段";
        String value2 = "第一段第二段";
        System.out.println(value == value2); //false
        System.out.println(value.equals(value2)); //true
        System.out.println(value +" "+value2);

        String value3 = new String("第三段");
        String value4 = "第三段";
        String value5 = "第三段";

        System.out.println(value3 == value4); //false
        System.out.println(value4 == value5); //true

        String value6[] = {"haha", "tryit"};
        String value7 = "haha";
        String value8[] = new String[]{"haha", "tryit"}; //静态声明
        String value9[] = new String[2];
        value9[0] = "haha"; //静态声明
        value9[1] = "tryit";

        System.out.println(value6[0] == value7); // true
        System.out.println(value7 == value8[0]); // true
        System.out.println(value7 == value9[0]); // true

    }
}
