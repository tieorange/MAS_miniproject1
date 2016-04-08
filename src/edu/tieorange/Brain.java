package edu.tieorange;

import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Brain extends Organ {


    public Brain(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute, List<String> sounds) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute, sounds);
    }

    public Brain(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute);
    }

    @Override
    public void BroadcastYourFunction(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getName();

        System.out.println("Yo " + otherOrganName + " " + otherOrgan.getName() + "my job is to THINK, you know what I mean? mm?");
    }

    // class method
    public static void Think(){
        System.out.println("I'm thinking... hmm...");
    }
}
