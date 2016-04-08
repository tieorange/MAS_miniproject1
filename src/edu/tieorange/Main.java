package edu.tieorange;

import java.text.MessageFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // setup Brain:
        Brain brain = new Brain("Bob", null, 5000);
        brain.addSound("hh-hhh");
        brain.addSound("hrr-hrr");
        brain.setLocation(new Location(20, 1, 4));


        // setup Heart:
        Heart heart = new Heart("Daria", "Camblgen", 3000);
        heart.addSound("pubuf-pubuf");
        heart.addSound("tuf-tuf");
        heart.setLocation(new Location(18, 30, 5));


        // setup Stomach:
        Stomach stomach = new Stomach("John", "Big", 100);
        stomach.addSound("frr-frr");
        stomach.addSound("krrr-krr");
        stomach.setLocation(new Location(21, 40, 4));


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

        System.out.println("\n===========\n\t PRINT EVERY:");
        System.out.println(brain);
        System.out.println(heart);
        System.out.println(stomach);
        System.out.println("=================\n");

        // extent:
        System.out.println("\n===========\n\t EXTENT");
        System.out.println(Organ.CaloriesSum());
        List<Organ> allOrgansExtent = Organ.getOrgans();
        System.out.println(allOrgansExtent);
        System.out.println("=================\n");


        // filtered:
        int minConsumption = 4000;
        List<Organ> filteredOrgans = Organ.getOrgans(minConsumption);
        System.out.println("\n===========\n\t FILTERED");
        System.out.println(MessageFormat.format("\t more than {0} calories consumption{1}", minConsumption, filteredOrgans));
        System.out.println("=================\n");


        // body part extent check:
        System.out.println("\n===========\n\t BODY PARTS EXTENT");
        List<BodyPart> allBodyParts = BodyPart.extent;
        System.out.println(allBodyParts);
        System.out.println("=================\n");

    }
}
