package com.globant.bootcamp.modelling;

public class EggCartonBuilder{

    private final Egg[][] eggcarton;

    private EggCartonBuilder(Builder builder){
        this.eggcarton= builder.eggcarton;
    }

    public static class Builder{
        private Egg[][] eggcarton;

        public Builder eggcarton(final Egg[][] eggcarton){
            this.eggcarton= eggcarton;
            return this;
        }

        public EggCartonBuilder build(){
            return new EggCartonBuilder(this);
        }
    }

    public Egg[][] getEggcarton() {
        return eggcarton;
    }

}
