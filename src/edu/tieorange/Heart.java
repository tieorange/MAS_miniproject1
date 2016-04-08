package edu.tieorange;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Heart extends Organ {

    private static int minimalCaloriesConsumption = 20;


    public Heart(String name, String surname, int caloriesConsumptionPerMinute, List<String> sounds) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute, sounds);
    }

    public Heart(String name, String surname, int caloriesConsumptionPerMinute) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute);
    }

    public void TellAboutJob(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getSimpleName();

        if (otherOrgan.getClass() == Brain.class) {
            System.out.println(MessageFormat.format("Yo {0} {1} my job is to LISTEN TO YOUR SIGNALS, you know what I mean? mm?", otherOrganName, otherOrgan.getName()));
            return;
        }

        System.out.println(MessageFormat.format("Yo {0} {1} my job is to MAKE A BEAT, you know what I mean? mm?", otherOrganName, otherOrgan.getName()));
    }


}
