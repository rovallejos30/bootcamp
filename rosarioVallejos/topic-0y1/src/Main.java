import com.globant.bootcamp.modelling.*;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Farmer farmer = new Farmer();

        ArrayList<Egg[][]> cartons = farmer.placeEggsInCarton();

        for(int n=0;n<cartons.size();n++) {
            System.out.println("Egg Carton n°"+ Integer.toString(n+1));
            Egg[][] a= cartons.get(n);
            for (int i=0;i<a.length;i++){
                for (int j=0;j<a[i].length;j++){
                    if(a[i][j]==null){
                        System.out.print("(G)");
                    }
                    else{
                        if(a[i][j].getColor().equals("WHITE")){
                            System.out.print("(O)");
                        }else{
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