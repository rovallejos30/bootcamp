package com.globant.bootcamp.modelling.eggcartonsizes;

import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.EggCartonBuilder;

public class LargeEggCartonBuilder extends EggCartonBuilder {

    private final Egg[][] largeeggcarton= new Egg[6][5];

    @Override
    public void buildEggCartonSize() {
        eggcarton.setEggsize(largeeggcarton);
    }
}
