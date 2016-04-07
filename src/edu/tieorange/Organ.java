package edu.tieorange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public abstract class Organ extends ParentObject {

    public String Name;
    public String Surname;
    public int CaloriesConsumptionPerMinute;
    public int MinimalCaloriesConsumption;

    public Organ(List<String> sounds, String surname, int caloriesConsumptionPerMinute, int minimalCaloriesConsumption, String name) {
        Sounds = sounds;
        Surname = surname;
        CaloriesConsumptionPerMinute = caloriesConsumptionPerMinute;
        MinimalCaloriesConsumption = minimalCaloriesConsumption;
        Name = name;
    }

    public List<String> Sounds = new ArrayList<>();

    // exact location in the body
    public Location Location;

    // part of the body to which organ belongs
    public BodyPart BodyPart;

    // return sum of all Calories used by all organs
    public static int CaloriesSum() {
        // TODO: mock
        return 0;
    }

    // true if the changes where successful
    public boolean ChangeCaloriesConsumption(int newConsumption) {
        if (newConsumption < MinimalCaloriesConsumption) {
            // TODO: komunikat
            return false;
        } else {
            this.CaloriesConsumptionPerMinute = newConsumption;
            return true;
        }
    }

    public void SignalTheExistance(Organ otherOrgan) {
        System.out.println(Name + " said to " + otherOrgan.Name + " that he works well");
    }

    public abstract void BroadcastYourFunction(Organ otherOrgan);

}
