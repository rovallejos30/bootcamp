import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.Farmer;
import enumClasses.CartonSize;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    static Logger logger= Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.info("Comienzo de la ejecución del programa");

        Farmer farmer = new Farmer();

            farmer.receiveOrder(2, 30, 70, CartonSize.LARGE);

            List<Egg[][]> cartons = farmer.placeEggsInCarton();

            for (int n = 0; n < cartons.size(); n++) {
                System.out.println("Egg Carton n°" + (n + 1));
                Egg[][] a = cartons.get(n);
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