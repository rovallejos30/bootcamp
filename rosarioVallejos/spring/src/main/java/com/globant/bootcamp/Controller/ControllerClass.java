package com.globant.bootcamp.Controller;
import com.globant.bootcamp.enumClasses.CartonSize;
import com.globant.bootcamp.modelling.Egg;
import com.globant.bootcamp.modelling.Farmer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerClass {

    @RequestMapping("/eggcartons")
    public List<Egg[][]> eggcartons(){
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        Farmer farmer= context.getBean("farmerBean", Farmer.class);
        farmer.receiveOrder(2, 30, 70, CartonSize.LARGE);
        List<Egg[][]> cartons = farmer.placeEggsInCarton();
        return cartons;
    }

}