package edu.tieorange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public class BodyPart extends ParentObject {
    public String Name;

    public List<Organ> Organs = new ArrayList<>();

    public void AssignOrgan(Organ organ) {
        if (Organs.contains(organ)) return;
        Organs.add(organ);
        organ.BodyPart = this;
    }

}
