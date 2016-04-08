package edu.tieorange;

import org.jetbrains.annotations.Contract;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tieorange on 07/04/16.
 */
public abstract class Organ implements Serializable {

    //<editor-fold desc="Fields">
    private static List<Organ> extent = new ArrayList<>();
    private String Name;
    private String Surname; // optional
    private int CaloriesConsumptionPerMinute;
    private int MinimalCaloriesConsumption;
    // multi-value
    private List<String> Sounds = new ArrayList<>();
    // exact location in the body
    // complex attribute
    private Location Location; // optional
    // part of the body to which organ belongs
    private BodyPart BodyPart;
    //</editor-fold>


    //<editor-fold desc="Constructors">
    public Organ(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute, List<String> sounds) {
        this();
        setName(name);
        setSurname(surname);
        setCaloriesConsumptionPerMinute(caloriesConsumptionPerMinute);
        setMinimalCaloriesConsumption(minimalCaloriesConsumption);
        setSounds(sounds);
    }

    public Organ(String name, String surname, int minimalCaloriesConsumption, int caloriesConsumptionPerMinute) {
        this();
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
    public static void saveExtent() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/extent.body");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(extent);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/extent.body");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadExtent() {
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/extent.body");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            extent = (List<Organ>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Extent class not found");
            c.printStackTrace();
            return;
        }
    }

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
        System.out.println(MessageFormat.format("{0} {1} said to {2} {3} that he works well",
                this.getClass().getSimpleName(), Name,
                otherOrgan.getClass().getSimpleName(), otherOrgan.Name));
    }

    public abstract void TellAboutJob(Organ otherOrgan);

    @Override
    public String toString() {
        String result = this.getClass().getSimpleName();
        result += ", " + getName();
        if (getSurname() != null)
            result += " " + getSurname();
        result += MessageFormat.format("\nI consume {0} calories/minute", getCaloriesConsumptionPerMinute());
        result += "\nmy minimal consumption = " + getMinimalCaloriesConsumption();
        if (getBodyPart() != null)
            result += "\nI sit in a " + getBodyPart();
        if (Sounds != null && !Sounds.isEmpty())
            result += "\nI make such a sound(s) as " + getSoundsString();
        if (Location != null)
            result += MessageFormat.format("\nlocation: x={0}; y={1}; z={2}",
                    Location.getX(), Location.getY(), Location.getZ());
        return result + '\n';
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
        return new ArrayList<>(Sounds);
    }

    // jetBrains annotations
//    @Contract("null -> fail")
    private void setSounds(List<String> sounds) {
//        if (sounds == null || sounds.isEmpty())
//            throw new IllegalArgumentException("sounds is null or empty");
//        else
        this.Sounds = new ArrayList<>(sounds);
    }

    public void addSound(String sound) {
        if (sound == null || sound.length() <= 0)
            throw new IllegalArgumentException("Sound is null or empty");
        else
            Sounds.add(sound);
    }

    private String getSoundsString() {
        String result = "";
        if (this.Sounds == null || this.Sounds.isEmpty())
            return result;
        else {
            for (String str : Sounds) {
                result += str + "; ";
            }
            return result;
        }
    }

    public edu.tieorange.Location getLocation() {
        return Location;
    }

    public void setLocation(edu.tieorange.Location location) {
        if (this.Location == location) {
            throw new IllegalArgumentException("Location is null or duplicated");
        } else {
            this.Location = new Location(location);
        }
    }

    public edu.tieorange.BodyPart getBodyPart() {
        return BodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        if (bodyPart != null)
            this.BodyPart = bodyPart;

    }

    // derived attr
    public int getDeltaMinimalCaloriesConsumption() {
        return CaloriesConsumptionPerMinute - MinimalCaloriesConsumption;
    }


    //</editor-fold>

}
