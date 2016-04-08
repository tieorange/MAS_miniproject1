package edu.tieorange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class BodyPart {
    public static List<BodyPart> extent = new ArrayList<>();

    public String Name;

    public List<Organ> Organs = new ArrayList<>();

    public BodyPart(String name) {
        this();
        setName(name);
    }

    public BodyPart() {
        super();
        BodyPart.extent.add(this);
    }

    public void AssignOrgan(Organ organ) {
        if (Organs.contains(organ)) return;
        Organs.add(organ);
        organ.setBodyPart(this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name == null || name.length() <= 0)
            throw new IllegalArgumentException("name is null or empty");
        else
            Name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
