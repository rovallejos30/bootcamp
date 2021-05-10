package com.globant.bootcamp.modelling.eggcartonsizes;

import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.EggCartonBuilder;

public class MediumEggCartonBuilder extends EggCartonBuilder {

    private final Egg[][] mediumeeggcarton= new Egg[4][4];

    @Override
    public void buildEggCartonSize() {
        eggcarton.setEggsize(mediumeeggcarton);
    }
}
