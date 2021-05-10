package com.globant.bootcamp.modelling;

public class Hen{

    private String henpounds;

    private String henbreed;

    public void setHenbreed(String henbreed) {
        this.henbreed = henbreed;
    }

    public void setHenpounds(String hensize) {
        this.henpounds = hensize;
    }

    public String getHenpounds() {
        return henpounds;
    }

    public String getHenbreed() {
        return henbreed;
    }

    public Egg PutEgg (String color){

        Egg egg= new Egg();

        if(color.equals("WHITE")){
            egg.setColor("WHITE");
        }
        else{
            egg.setColor("RED");
        }


        return egg;
    }

}
