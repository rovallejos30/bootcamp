import com.globant.bootcamp.modelling.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Farmer farmer = new Farmer();

        ArrayList<Egg[][]> cartons = farmer.placeEggsInCarton();

        for(int n=0;n<cartons.size();n++) {
            System.out.println("Egg Carton n°"+ (n+1));
            Egg[][] a= cartons.get(n);
            for (Egg[] eggs : a) {
                for (Egg egg : eggs) {
                    if (egg == null) {
                        System.out.print("(G)");
                    } else {
                        if (egg.getColor().equals("WHITE")) {
                            System.out.print("(O)");
                        } else {
                            System.out.print("(D)");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("***************");
        }
    }
}