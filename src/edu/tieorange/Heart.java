package edu.tieorange;

import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Heart extends Organ {

    public Heart(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute, List<String> sounds) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute, sounds);
    }

    public Heart(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute);
    }

    public void BroadcastYourFunction(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getName();

        if (otherOrgan.getClass() == Brain.class) {
            System.out.println("Yo " + otherOrganName + " " + otherOrgan.Name + "my job is to LISTEN TO YOUR SIGNALS, you know what I mean? mm?");
            return;
        }

        System.out.println("Yo " + otherOrganName + " " + otherOrgan.Name + "my job is to MAKE A BEAT, you know what I mean? mm?");
    }


}
