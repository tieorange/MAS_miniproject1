package edu.tieorange;

import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Stomach extends Organ {

    public Stomach(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute, List<String> sounds) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute, sounds);
    }

    public Stomach(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute);
    }

    @Override
    public void BroadcastYourFunction(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getName();
        System.out.printf("Yo %s %s, my job is to DIGEST FOOOOOOD, you know what I mean? mm?%n", otherOrganName, otherOrgan.Name);
    }
}
