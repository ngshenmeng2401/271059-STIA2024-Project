package com.company;

public class Customer extends AddData{

    private String t1,t3,t4,t5a,t5b,t5c,t6,t7,t8,t9;
    private double totalUsage,currentCharge,totalcurrentCharge;
    private int accNo;

    public Customer(String t1, int accNo, String t3, String t4, String t5a, String t5b, String t5c, String t6, String t7, String t8, String t9, double totalUsage, double currentCharge, double totalcurrentCharge) {
        this.t1 = t1;
        this.accNo = accNo;
        this.t3 = t3;
        this.t4 = t4;
        this.t5a = t5a;
        this.t5b = t5b;
        this.t5c = t5c;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
        this.totalUsage = totalUsage;
        this.currentCharge = currentCharge;
        this.totalcurrentCharge = totalcurrentCharge;
    }


        public String toString(){

        return t1+" "+accNo+" "+t3+" "+t4+" "+t5a+" "+t5b+" "+t5c+" "+t6+" "+t7+" "+t8+" "+t9+" "+currentCharge+" "+totalcurrentCharge;
    }


    @Override
    public int getAccNo() {
        return accNo;
    }

    @Override
    public String getT4() {
        return t4;
    }
}
