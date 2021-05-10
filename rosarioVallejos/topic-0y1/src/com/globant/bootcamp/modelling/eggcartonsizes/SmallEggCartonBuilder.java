package com.globant.bootcamp.modelling.eggcartonsizes;

import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.EggCartonBuilder;

public class SmallEggCartonBuilder extends EggCartonBuilder {

    private final Egg[][] smalleggcarton= new Egg[2][4];

    @Override
    public void buildEggCartonSize() {
        eggcarton.setEggsize(smalleggcarton);
    }
}
