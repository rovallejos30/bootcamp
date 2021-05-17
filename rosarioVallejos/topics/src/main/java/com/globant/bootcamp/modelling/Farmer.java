package com.globant.bootcamp.modelling;

import enumClasses.CartonSize;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Farmer {

    private final Hen hen = new Hen();
    private String name;
    private final HenHouse henhouse = new HenHouse();
    int eggsperday;
    double percentagewhiteeggs;
    double percentageredeggs;
    CartonSize cartonSize;

    static Logger logger= Logger.getLogger(Farmer.class);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void classifyHen(String breed, String pounds) {
        hen.setHenpounds(pounds);
        hen.setHenbreed(breed);
    }

    public void receiveOrder(int eggsperday, double percentagewhiteeggs, double percentageredeggs, CartonSize cartonSize) {
            this.eggsperday= eggsperday;
            this.cartonSize= cartonSize;
            if (percentageredeggs+percentagewhiteeggs==100)  {
                this.percentagewhiteeggs= percentagewhiteeggs/100;
                this.percentageredeggs= percentageredeggs/100;
            }else {
                logger.fatal("Parámetros erróneos. El porcentaje total no es 100%");
            }
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

    public List<Egg[][]> placeEggsInCarton () {

        Egg[] eggstoplace= classifyEggs();

        EggCartonBuilder eggCartonBuilder;

        try{

        switch (cartonSize) {
            case LARGE:
                eggCartonBuilder = new EggCartonBuilder.Builder().eggcarton(new Egg[6][5]).build();
                break;
            case MEDIUM:
                eggCartonBuilder = new EggCartonBuilder.Builder().eggcarton(new Egg[4][4]).build();
                break;
            case SMALL:
                eggCartonBuilder = new EggCartonBuilder.Builder().eggcarton(new Egg[2][3]).build();
                break;
            default:
                eggCartonBuilder = null;
                logger.fatal("Se pasó un parámetro erroneo que no pertenece a ningún tamaño de cartón");
                break;
            }
        }
        catch(RuntimeException r){
            eggCartonBuilder = null;
            logger.fatal("Se pasó un parámetro erroneo que no pertenece a ningún tamaño de cartón") ;
            System.exit(1);
        }

        double whiteeggs=(eggstoplace.length*percentagewhiteeggs);
        double redeggs= (eggstoplace.length*percentageredeggs);

        int row= eggCartonBuilder.getEggcarton().length;
        int column= eggCartonBuilder.getEggcarton()[0].length;
        double total= row*column;
        String color= "WHITE";

        if (whiteeggs==0 && redeggs!=0){
            total= Math.ceil(redeggs/total);
            color= "RED";
        } else if(whiteeggs!=0 && redeggs==0) {
            total= Math.ceil(whiteeggs/total);
        }
        else{
            total= Math.ceil(whiteeggs/total)+Math.ceil(redeggs/total);
        }


        int cartonsperday=(int)total;

        int pos= 0;

        List<Egg[][]> listCartons= new ArrayList<>();

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
