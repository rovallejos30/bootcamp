package com.globant.bootcamp.modelling;

public class EggCarton {
   private Egg[][] eggsize=new Egg[0][0];

   public void setEggsize(Egg[][] eggsize){
       this.eggsize= eggsize;
   }

    public Egg[][] getEggsize() {
        return eggsize;
    }
}
