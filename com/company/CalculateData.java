package com.company;


public class CalculateData extends AddData{

    private double currentMeter,previousMeter,tunggakan,totalUsage,currentCharge,totalcurrentCharge;

    public CalculateData(double currentMeter, double previousMeter, double tunggakan) {
        this.currentMeter = currentMeter;
        this.previousMeter = previousMeter;
        this.tunggakan = tunggakan;
    }

    public void calculateBill(){

        totalUsage=currentMeter-previousMeter;

        if(totalUsage>=1&&totalUsage<=200){
            currentCharge=totalUsage*0.218;
        }else if (totalUsage>=201&&totalUsage<=300){
            currentCharge=((totalUsage-200)*0.334)+43.6;
        }else if (totalUsage>=301&&totalUsage<=600){
            currentCharge=((totalUsage-300)*0.516)+77;
        }else if (totalUsage>=601&&totalUsage<=900){
            currentCharge=((totalUsage-600)*0.546)+231.8;
        }else if (totalUsage>=901){
            currentCharge=((totalUsage-900)*0.571)+395.6;
        }

        totalcurrentCharge=tunggakan+currentCharge;

    }

    public void setCurrentMeter(double currentMeter) {
        this.currentMeter = currentMeter;
    }

    public void setPreviousMeter(double previousMeter) {
        this.previousMeter = previousMeter;
    }

    public double getTotalUsage() {
        return totalUsage;
    }

    public double getCurrentCharge() {
        return currentCharge;
    }

    public double getTotalcurrentCharge() {
        return totalcurrentCharge;
    }
}
