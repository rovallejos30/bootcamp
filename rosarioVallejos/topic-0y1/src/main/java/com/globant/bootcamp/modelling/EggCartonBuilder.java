package com.globant.bootcamp.modelling;

public abstract class EggCartonBuilder {
    protected EggCarton eggcarton;

    public EggCarton getEggcarton(){
        return eggcarton;
    }

    public void createEggCarton(){
        eggcarton = new EggCarton();
    }

    public abstract void buildEggCartonSize();
}
