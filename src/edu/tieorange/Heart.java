package edu.tieorange;

import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Heart extends Organ {
    public Heart(List<String> sounds, String surname, int caloriesConsumptionPerMinute, int minimalCaloriesConsumption, String name) {
        super(sounds, surname, caloriesConsumptionPerMinute, minimalCaloriesConsumption, name);
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
