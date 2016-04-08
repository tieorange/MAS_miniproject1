package edu.tieorange;

public class Main {

    public static void main(String[] args) {
        // setup Brain:
        Brain brain = new Brain("Bob", null, 300, 5000);


        // setup Heart:
        Heart heart = new Heart("Daria", "Camblgen", 200, 3000);


        // setup Stomach:
        Stomach stomach = new Stomach("John", "Big", 2, 100);

        // bodyPart:
        BodyPart head = new BodyPart("head");
        head.AssignOrgan(brain);

        BodyPart core = new BodyPart("core");
        core.AssignOrgan(heart);
        core.AssignOrgan(stomach);

        System.out.println(brain);
        System.out.println(heart);
        System.out.println(stomach);

    }
}
