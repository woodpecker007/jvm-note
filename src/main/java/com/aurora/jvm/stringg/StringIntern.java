package com.aurora.jvm.stringg;

public class StringIntern {

    public static void main(String[] args) {
//        String s1 = new String("a");
//        String s2 = s1.intern();//在执行intern前"a"已经在常量池中创建。
//        String s3 = "a";
//        System.out.println(s1 == s3);//false s1和s3的地址不等
//        System.out.println(s2 == s3);//true s2和s3的地址相等

//        String s4 = new String("b") + new String("c");
//        // bc在执行s4.intern()前，在常量池中不存在，
//        // 执行intern()方法会在字符串常量池中bc的存储地址，设置s4的地址引用。
//        String s6 = s4.intern();
//        String s5 = "bc";
//        // bc的地址就是堆空间中s4的地址引用，和s4是同一地址。
//        System.out.println(s4 == s5);//true
//        // s6是s4.intern()返回的地址就是常量池的地址，但此时常量池中s6的地址就是s4的地址引用。
//        System.out.println(s6 == s5);//true

        String s4 = new String("b") + new String("c");
        // 字面量声明bc会放到常量池中，并返回地址，
        // 此时s4还只是堆中的地址，和常量池并没有关联。
        String s5 = "bc";
        // bc在执行s4.intern()前，在常量池中已存在，
        // 执行intern()方法，返回字符串常量池中bc的存储地址。
        String s6 = s4.intern();
        // bc在常量池中已存在，bc的地址和s4的地址无关联。
        System.out.println(s4 == s5);//false
        System.out.println(s5 == s6);//true
    }
}
