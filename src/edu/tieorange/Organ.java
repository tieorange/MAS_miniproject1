package edu.tieorange;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tieorange on 07/04/16.
 */
public abstract class Organ {

    //<editor-fold desc="Fields">
    private static List<Organ> extent = new ArrayList<>();
    private String Name;
    private String Surname; // optional // TODO:
    private int CaloriesConsumptionPerMinute;
    private int MinimalCaloriesConsumption;
    // multi-value
    private List<String> Sounds = new ArrayList<>();
    // exact location in the body
    // complex attribute
    private Location Location;
    // part of the body to which organ belongs
    private BodyPart BodyPart;
    //</editor-fold>


    //<editor-fold desc="Constructors">
    public Organ(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute, List<String> sounds) {
        setName(name);
        setSurname(surname);
        setCaloriesConsumptionPerMinute(caloriesConsumptionPerMinute);
        setMinimalCaloriesConsumption(minimalCaloriesConsumption);
        setSounds(sounds);
    }

    public Organ(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute) {
        setName(name);
        setSurname(surname);
        setCaloriesConsumptionPerMinute(caloriesConsumptionPerMinute);
        setMinimalCaloriesConsumption(minimalCaloriesConsumption);
    }

    private Organ() {
        super();
        Organ.extent.add(this);
    }
    //</editor-fold>


    //<editor-fold desc="methods">
    // return sum of all Calories used by all organs
    public static int CaloriesSum() {
        int sum = 0;
        for (Organ organ : extent) {
            sum += organ.getCaloriesConsumptionPerMinute();
        }
        return sum;
    }

    // true if the changes where successful
    public boolean ChangeCaloriesConsumption(int newConsumption) {
        if (newConsumption < MinimalCaloriesConsumption) {
            return false;
        } else {
            this.CaloriesConsumptionPerMinute = newConsumption;
            return true;
        }
    }

    public void SignalTheExistence(Organ otherOrgan) {
        System.out.println(Name + " said to " + otherOrgan.Name + " that he works well");
    }

    public abstract void BroadcastYourFunction(Organ otherOrgan);

    @Override
    public String toString() {
        String result = this.getClass().getSimpleName();
        result += ", " + getName();
        if (getSurname() != null)
            result += " " + getSurname();
        return result;
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public static List<Organ> getOrgans() {
        List<Organ> tmp = new ArrayList<>(Organ.extent);
        return tmp;
    }

    // overloading
    public static List<Organ> getOrgans(int minConsumption) {
        List<Organ> tmp = new ArrayList<>(Organ.extent);

        List<Organ> results = tmp.stream().filter(t -> t.getCaloriesConsumptionPerMinute() > minConsumption).collect(Collectors.toList());
        return results;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null");
        } else {
            this.Name = name;
        }

    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public int getCaloriesConsumptionPerMinute() {
        return CaloriesConsumptionPerMinute;
    }

    public void setCaloriesConsumptionPerMinute(int caloriesConsumptionPerMinute) {
        if (caloriesConsumptionPerMinute <= this.MinimalCaloriesConsumption)
            throw new IllegalArgumentException("consumption has to be bigger than minimal");
        else
            CaloriesConsumptionPerMinute = caloriesConsumptionPerMinute;
    }

    public int getMinimalCaloriesConsumption() {
        return MinimalCaloriesConsumption;
    }

    public void setMinimalCaloriesConsumption(int minimalCaloriesConsumption) {
        if (minimalCaloriesConsumption > getCaloriesConsumptionPerMinute())
            throw new IllegalArgumentException("minimal can't be bigger than normal consumption");
        else
            MinimalCaloriesConsumption = minimalCaloriesConsumption;
    }

    public List<String> getSounds() {
        return Sounds;
    }

    // jetBrains annotations
    @Contract("null -> fail")
    private void setSounds(List<String> sounds) {
        if (sounds == null || sounds.isEmpty())
            throw new IllegalArgumentException("sounds is null or empty");
        else
            this.Sounds = new ArrayList<>(sounds);
    }

    public void addSound(String sound) {
        if (sound == null || sound.length() <= 0)
            throw new IllegalArgumentException("Sound is null or empty");
        else
            Sounds.add(sound);
    }

    public edu.tieorange.Location getLocation() {
        return Location;
    }

    public void setLocation(edu.tieorange.Location location) {
        if (this.Location == location || this.Location == null) {
            throw new IllegalArgumentException("Location is null or duplicated");
        } else {
            this.Location = location;
        }
    }

    public edu.tieorange.BodyPart getBodyPart() {
        return BodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        if (bodyPart == null)
            this.BodyPart = bodyPart;

    }

    // derived attr
    public int getDeltaMinimalCaloriesConsumption() {
        return CaloriesConsumptionPerMinute - MinimalCaloriesConsumption;
    }


    //</editor-fold>

}
