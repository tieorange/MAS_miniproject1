package edu.tieorange;

import java.text.MessageFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // setup Brain:
        Brain brain = new Brain("Bob", null, 5000);
        brain.addSound("hhhhh");
        brain.setLocation(new Location(1,3,4));


        // setup Heart:
        Heart heart = new Heart("Daria", "Camblgen", 3000);


        // setup Stomach:
        Stomach stomach = new Stomach("John", "Big", 100);

        // Signal the existence:
        brain.SignalTheExistence(heart);
        // Broadcast:
        heart.TellAboutJob(brain); // special message for brain
        heart.TellAboutJob(stomach); // default message for other organs

        // derived attr:
        System.out.printf("\n Delta of consumption = %d%n \n", stomach.getDeltaMinimalCaloriesConsumption());

        // bodyPart:
        BodyPart head = new BodyPart("head");
        head.AssignOrgan(brain);

        BodyPart core = new BodyPart("core");
        core.AssignOrgan(heart);
        core.AssignOrgan(stomach);

        System.out.println(brain);
        System.out.println(heart);
        System.out.println(stomach);

        // extent:
        System.out.println(Organ.CaloriesSum());
        List<Organ> allOrgansExtent = Organ.getOrgans();
        System.out.println(allOrgansExtent);

        // filtered:
        int minConsumption = 4000;
        List<Organ> filteredOrgans = Organ.getOrgans(minConsumption);
        System.out.println(MessageFormat.format("\t more than {0} calories consumption{1}", minConsumption, filteredOrgans));


    }
}
