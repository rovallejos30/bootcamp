package com.globant.bootcamp.modelling;

public class EggCartonSize {
   private EggCartonBuilder eggCartonBuilder;

   public void setEggCartonBuilder(EggCartonBuilder eggcartbuild){
       eggCartonBuilder= eggcartbuild;

   }

   public EggCarton getEggCarton(){
       return eggCartonBuilder.getEggcarton();
   }

   public void buildEggCarton(){
       eggCartonBuilder.createEggCarton();
       eggCartonBuilder.buildEggCartonSize();
   }
}
