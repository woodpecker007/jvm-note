package com.aurora.jvm.stringg;

public class StringAccept {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        System.out.println(str);
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringAccept sa = new StringAccept();
        sa.change(sa.str, sa.ch);
        System.out.println(sa.str);//good
        System.out.println(sa.ch);//best
    }
}
