package edu.tieorange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class BodyPart {
    public String Name;

    public List<Organ> Organs = new ArrayList<>();

    public BodyPart(String name) {
        setName(name);
    }

    public void AssignOrgan(Organ organ) {
        if (Organs.contains(organ)) return;
        Organs.add(organ);
        organ.BodyPart = this;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (this.Name == null || this.Name.length() <= 0)
            throw new IllegalArgumentException("name is null or empty");
        else
            Name = name;
    }
}
