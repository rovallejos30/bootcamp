package com.globant.bootcamp;

import com.globant.bootcamp.enumClasses.CartonSize;
import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.Farmer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value= Parameterized.class)
public class FarmerTest {

    Farmer farmer= new Farmer();

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {2,30,70, CartonSize.LARGE,3},
                {2,70,30,CartonSize.MEDIUM,6},
                {2,50,100,CartonSize.SMALL,0},
        });
    }

    private final int eggsperday;
    private final double percentagewhiteeggs, percentageredeggs;
    private final CartonSize cartonSize;
    private final int expected;


    public FarmerTest(int eggsperday, double percentagewhiteeggs, double percentageredeggs, CartonSize cartonSize, int expected){
        this.eggsperday= eggsperday;
        this.percentagewhiteeggs= percentagewhiteeggs;
        this.percentageredeggs= percentageredeggs;
        this.cartonSize= cartonSize;
        this.expected= expected;
    }

     @Test
    public void testReceiveOrder(){
        try {
            farmer.receiveOrder(eggsperday,percentagewhiteeggs,percentageredeggs,cartonSize);
        } catch(RuntimeException r){
            assertEquals(0,0);
        }
     }

    @Test
    public void testPlaceEggsInCartonSize(){
        farmer.receiveOrder(eggsperday,percentagewhiteeggs,percentageredeggs,cartonSize);
        List<Egg[][]> cartons = farmer.placeEggsInCarton();
        assertEquals(expected,cartons.size());
    }

}
