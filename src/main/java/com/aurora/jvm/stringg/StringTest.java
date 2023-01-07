package com.aurora.jvm.stringg;


import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    /**
     * 1.对字符串重新赋值。
     */
    public void test1() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        System.out.println(s1 == s2);//true
        System.out.println(s1);//abc
        System.out.println(s2);//abc
        s1 = "hello";
        System.out.println(s1 == s2);//false
        System.out.println(s1);//hello
        System.out.println(s2);//abc
    }

    @Test
    /**
     * 2.对现有字符串进行连接操作。
     */
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);//true
        s2 += "def";
        System.out.println(s1 == s2);//false
        System.out.println(s1);//abc
        System.out.println(s2);//abcdef
    }

    @Test
    /**
     * 3.通过replace方法进行替换。
     */
    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');
        System.out.println(s1 == s2);//false
        System.out.println(s1);//abc
        System.out.println(s2);//mbc
    }

    @Test
    /**
     * 1.声明整体分两类，字面量和new。
     * 2.通过字面量方式声明的字符串在字符串的常量池中，jdk8的字符串常量池位于堆中。
     * 3.通过new方式声明的字符串在对空间中。
     * 4.StringBuffer和StringBuilder内部还是通过new声明。
     */
    public void test() {
        String s1 = "hello";//字面量
        String s2 = new String("hello world");//new
        String s3 = new StringBuffer().toString();//toString()内部还是new
        String s4 = new StringBuilder().toString();//toString()内部还是new
    }

    @Test
    public void compileOpt1() {
        String s1 = "a" + "b" + "c";//编译期优化：拼接符号左右都是字符串常量，等同于"abc"
        String s2 = "abc"; //"abc"存储在字符串常量池中，将此地址赋给s2
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
        final String s3 = "hello";
        final String s4 = "world";
        String s5 = s3 + s4;
        String s6 = s3 + "world111";
    }

    @Test
    public void newString() {
        String standard = "helloworld";
        String s1 = "hello";
        String s2 = "world";
        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：helloworld
        String s3 = s1 + "world";
        String s4 = "hello" + s2;
        String s5 = s1 + s2;

        System.out.println(standard == s3);//false
        System.out.println(standard == s4);//false
        System.out.println(standard == s5);//false
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s4 == s5);//false
    }

    @Test
    public void verifyTime() {
        long start = System.currentTimeMillis();
        String content = "";
        //每次循环都会创建一个StringBuilder、String
        for (int i = 0; i < 100000; i++) {//循环10w次
            content = content + "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Test
    public void verifyTime2() {
        long start = System.currentTimeMillis();
        //只需要创建一个StringBuilder
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {//循环10w次
            builder.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

}
