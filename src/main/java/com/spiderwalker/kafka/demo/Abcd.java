package com.spiderwalker.kafka.demo;

public class Abcd {
    private String a;
    private String b;
    private String c;
    private String d;

    public Abcd() {
    }
    public Abcd(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }
    public String getC() {
        return c;
    }
    public String getD() {
        return d;
    }
    public void setA(String a) {
        this.a = a;
    }
    public void setB(String b) {
        this.b = b;
    }
    public void setC(String c) {
        this.c = c;
    }
    public void setD(String d) {
        this.d = d;
    }
    @Override
    public String toString() {
        return "Abcd [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
    }


   
}
