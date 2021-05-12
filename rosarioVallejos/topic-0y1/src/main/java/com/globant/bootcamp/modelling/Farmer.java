package com.globant.bootcamp.modelling;

import com.globant.bootcamp.modelling.eggcartonsizes.LargeEggCartonBuilder;
import com.globant.bootcamp.modelling.eggcartonsizes.MediumEggCartonBuilder;
import com.globant.bootcamp.modelling.eggcartonsizes.SmallEggCartonBuilder;
import enumClasses.CartonSize;

import java.util.ArrayList;

public class Farmer {

    private final Hen hen= new Hen();
    private String name;
    private final HenHouse henhouse= new HenHouse();
    final int eggsperday=2;
    final double percentagewhiteeggs= 0.3;
    final double percentageredeggs= 0.7;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void classifyHen(String breed, String pounds){
        hen.setHenpounds(pounds);
        hen.setHenbreed(breed);
    }

    private Egg [] classifyEggs(){

        int capacity= ((henhouse.getHenHouseCapacity().length) * eggsperday);
        int whitecapacity=(int)(capacity*percentagewhiteeggs);
        Egg [] eggs= new Egg[capacity];
        for(int i=0;i<capacity;i++) {
            if(i<whitecapacity){
                eggs[i]= hen.PutEgg("WHITE");
            }
            else{
                eggs[i]= hen.PutEgg("RED");
            }
        }

        return eggs;
    }

    public ArrayList<Egg[][]> placeEggsInCarton(){

        Egg [] eggstoplace= classifyEggs();

        EggCartonSize eggCartonSize= new EggCartonSize();

        CartonSize cartonsize= CartonSize.LARGE;

        switch (cartonsize){
            case LARGE:
                EggCartonBuilder largeEggCarton= new LargeEggCartonBuilder();
                eggCartonSize.setEggCartonBuilder(largeEggCarton);
                break;
            case MEDIUM:
                EggCartonBuilder mediumEggCarton= new MediumEggCartonBuilder();
                eggCartonSize.setEggCartonBuilder(mediumEggCarton);
                break;
            case SMALL:
                EggCartonBuilder smallEggCarton= new SmallEggCartonBuilder();
                eggCartonSize.setEggCartonBuilder(smallEggCarton);
                break;
        }

        eggCartonSize.buildEggCarton();

        EggCarton eggCarton= eggCartonSize.getEggCarton();

        double whiteeggs=(eggstoplace.length*percentagewhiteeggs);
        double redeggs= (eggstoplace.length*percentageredeggs);

        Egg [][] cartons= eggCarton.getEggsize();

        int row=cartons.length;
        int column=cartons[0].length;
        double total= row*column;
        total= Math.ceil(whiteeggs/total)+Math.ceil(redeggs/total);
        int cartonsperday=(int)total;

        int pos= 0;

        String color= "WHITE";

        ArrayList<Egg[][]> listCartons= new ArrayList<>();

        for(int n=0;n<cartonsperday;n++){
            Egg [][] eggcarton= new Egg[row][column];

            for(int i=0;i<eggcarton.length;i++){
                for(int j=0;j<eggcarton[i].length;j++){
                    if(pos<eggstoplace.length) {
                        if (eggstoplace[pos].getColor().equals(color)) {
                            eggcarton[i][j] = eggstoplace[pos];
                            pos++;
                        } else {
                            eggcarton[i][j] = null;
                        }
                    }
                }
            }
            listCartons.add(eggcarton);
            if(pos<eggstoplace.length) {
                if(!eggstoplace[pos+1].getColor().equals(color)){
                    color= "RED";
                }
            }


        }

        return listCartons;

    }
}
