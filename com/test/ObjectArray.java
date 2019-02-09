package com.test;  //terminal执行的时候，在Java这个目录下，javac com/test/ObjectArray.java  java com/test/ObjectArray

public class ObjectArray{

    public static void main(String[] args){
        String[] arrays = new String[5];
        for(String array: arrays){
            System.out.println(array); //null null null null null, 若要使用array，一定要初始化，否则没有String的功能
        }

        int [] is = new int[5]; //基础类型不需要手动初始化
        for (int i:is){
            System.out.println(i); // 0 0 0 0 0
        }

        TestClass[] tc = new TestClass[5];
        for (TestClass t:tc){
            t = new TestClass(); //类的对象一定要单独初始化
            System.out.println(t.getName());
            System.out.println(t);  //t在heap memory中的地址
        }
    }

}
