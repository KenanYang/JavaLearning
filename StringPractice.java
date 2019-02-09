public class StringPractice{
    public static void main(String[] args){
        // byte array and String  cast
        byte[] byteArray = {104, 101, 108, 108, 111};
        String str = new String(byteArray);
        // System.out.println(str); //hello

        String a = "abc";
        String b = "234";
        String c = a + b; //会创建新的String
        System.out.println("abc".equals("abc")); //true
        System.out.println("abc".compareTo("abcd")); // -1 //< 0 or 0 or > 0
        System.out.println("abc".startsWith("ab")); //前缀
        System.out.println("abcfg".endsWith("fg")); //后缀
        System.out.println("abcdefg".contains("de")); //包含

        //indexOf(ch)
        String password = "ab123456abc";
        System.out.println(password.indexOf('3')); // return 4
        System.out.println(password.indexOf("ab")); // return 0
        System.out.println(password.indexOf("ab", 2)); //return 8, 从index =

        //substring(i1, i2) [i1, i2)  substring(i1) [i1, end-1]

        //StringBuffer/ StringBuilder  -- 带缓存的字符串
        String str1 = "a";
        String str2 = "b";
        String str3 = str1 + str2;

        //底层实现
        //String str3 = new StringBuffer(String.valueOf(str1)).append(str2).toString() ;


        final int N = 500000;
        long startTime = System.currentTimeMillis();
        String str4 = "*";
        for(int i =0; i < N; i++){
            str4 += "*";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("+=用时："+(endTime - startTime) + "毫秒"); //66552 ms
        //使用StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer str5 = new StringBuffer("*");
        for(int i =0; i < N; i++){
            str5.append("*");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的append用时："+(endTime - startTime) + "毫秒"); //18 ms

        //StringBuilder --StringBuffer 的加强版
        startTime = System.currentTimeMillis();
        StringBuilder str6 = new StringBuilder("*");
        for(int i =0; i < N; i++){
            str6.append("*");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的append用时："+(endTime - startTime) + "毫秒"); // 7 ms
    }
}
