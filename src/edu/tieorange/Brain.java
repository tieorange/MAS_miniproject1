package edu.tieorange;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class Brain extends Organ {

    private static int minimalCaloriesConsumption = 10;

    public Brain(String name, String surname, int caloriesConsumptionPerMinute, List<String> sounds) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute, sounds);
    }

    public Brain(String name, String surname, int caloriesConsumptionPerMinute) {
        super(name, surname, minimalCaloriesConsumption, caloriesConsumptionPerMinute);
    }



    @Override
    public void TellAboutJob(Organ otherOrgan) {
        String otherOrganName = otherOrgan.getClass().getSimpleName();

        System.out.println(MessageFormat.format("Yo {0} {1}my job is to THINK, you know what I mean? mm?",
                otherOrganName, otherOrgan.getClass().getSimpleName()));
    }

//    // class method
//    public static void Think() {
//        System.out.println("I'm thinking... hmm...");
//    }
}
