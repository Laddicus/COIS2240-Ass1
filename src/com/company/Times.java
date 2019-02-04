package com.company;
// Times is a class that holds both the iteTime and recTime so that they can be returned from a method
public class Times {
    private long iteTime;
    private long recTime;


    public Times(long iteTime, long recTime) {
        this.iteTime = iteTime;
        this.recTime = recTime;
    }

    public long getIteTime() {
        return iteTime;
    }

    public long getRecTime() {
        return recTime;
    }
}
