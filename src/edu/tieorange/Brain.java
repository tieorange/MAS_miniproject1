package edu.tieorange;

import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Brain extends Organ {

    public Brain(List<String> sounds, String surname, int caloriesConsumptionPerMinute, int minimalCaloriesConsumption, String name) {
        super(sounds, surname, caloriesConsumptionPerMinute, minimalCaloriesConsumption, name);
    }

    @Override
    public void BroadcastYourFunction(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getName();

        System.out.println("Yo " + otherOrganName + " " + otherOrgan.Name + "my job is to THINK, you know what I mean? mm?");
    }

    // class method
    public static void Think(){
        System.out.println("I'm thinking... hmm...");
    }
}
