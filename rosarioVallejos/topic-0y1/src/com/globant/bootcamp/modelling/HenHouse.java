package com.globant.bootcamp.modelling;

public class HenHouse {

    private String henhousename;

    private Hen [] henHouseCapacity;

    public void setHenhousename(String location) {
        this.henhousename = location;
    }

    public String getHenhousename() {
        return henhousename;
    }

    public Hen[] getHenHouseCapacity() {
        return henHouseCapacity;
    }

    public HenHouse(){

        henHouseCapacity= new Hen[40];
        for (int i = 0; i< henHouseCapacity.length; i++){
            Hen hen= new Hen();
            henHouseCapacity[i]=  hen;
        }

    }

}
