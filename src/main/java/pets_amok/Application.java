package pets_amok;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the main program for our Virtual Pets Amok app. Contains the main method for user interaction.
 * 
 * @author Deidra Zamonski-Blake
 * @version 1.0
 */
public class Application {

    /** The virtual pet shelter instance variable of the main app */
    private static VirtualPetShelter shelterForPets;

    /** This instance variable represents the list of virtual pets in the shelter */
    private static ArrayList<VirtualPet> virtualPetsInShelter;

    /** This is the scanner instance variable of the main app */
    private static Scanner scanner;
    /**
     * The main method serving as the entry point of the application. It handles the user input and output, and it runs the game loop. It also utilizes the function of our virtual pet shelter class as well as the functions of the individual virtual pets.
     * 
     * @param args Command-line arguments passed down to the application.
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        shelterForPets = new VirtualPetShelter();
        virtualPetsInShelter = shelterForPets.getVirtualPetsInShelter();

        OrganicCat snuffles = new OrganicCat("Snuffles", "Orange tabby kitten");
        OrganicCat daisy = new OrganicCat("Daisy", "Black short hair");
        OrganicDog buddy = new OrganicDog("Buddy", "Brown lab");
        OrganicDog bella = new OrganicDog("Bella", "Grey husky");
        RoboticCat charlie = new RoboticCat("Charlie", "Green X12");
        RoboticCat lola = new RoboticCat("Lola", "Blue X14");
        RoboticDog cooper = new RoboticDog("Cooper", "Yellow Y7");
        RoboticDog lucy = new RoboticDog("Lucy", "White Y11");

        virtualPetsInShelter.add(snuffles);
        virtualPetsInShelter.add(daisy);
        virtualPetsInShelter.add(buddy);
        virtualPetsInShelter.add(bella);
        virtualPetsInShelter.add(charlie);
        virtualPetsInShelter.add(lola);
        virtualPetsInShelter.add(cooper);
        virtualPetsInShelter.add(lucy);

        System.out.println();
        System.out.println("Animal Shelter Manager App\n");

        // List all organic pets
        listAllOrganicPets();
        printMainMenu();



        /*
         * Inside main tick method:
         * increaseOrganicBaseStats
         * increaseEveryone'sBoredom
         * increaseBathroomStat
         * decreaseBatteryLevel
         * decreaseLubricantIntegrityLevel
         * decreaseMaintenanceIntegrityLevel
         * checkForThreats
         * makeCatsRestlessIfUnlucky
         * soilCageIfUnlucky
         * catsUseLitterBoxIfNecessary
         * knockOverLitterBoxIfUnlucky
         * decreaseHealthStatSoiledCage
         * decreaseHealthStatFullLitterBox
         * decreaseHealthStatLowHungerThirst
         * decreaseHealthStatLowOilLevel
         * socializeAllPets
         * allOrganicsSelfCare
         * checkForDeadPets
         * removeDeadPets
         */

        /*
         * Add displays for the following items
         * Base Stats for Organic Pets
         * Base Stats for Robotic Pets
         * Dirty Cages
         * Litter Box Cleanliness & Upright Status
         * Short Circuited Cats
          */

          // Need a notification system. Notify when:
        /*
         * When a dog soils a cage
         * When a cat uses the litter box
         * When a cat short circuits
         * When the litter box is knocked over
         * When a robot needs maintenance
         * When a robot needs oil
         */

        // How will we handle checking if the dog has been walked this tick and last tick?
        // boolean walkedDogLastTick = false at the beginning outside of loop
        // boolean walkedDogThisTick = false at the beginning inside of loop
        /*
         * If user presses the walk dog key {
         *      walkedDogThisTick = hasWalkedDog
         *      boolean walkedDogLastTick = true
         *  }
         * 
         * make walkedDogThisTick false before loop ends
         *  
         */

        /*
         * Add cleanliness stat to the shelter that goes up if the litter box is tipped over; 
         * Increases by the waste level the litter box was at
         * It also increases when dog's cages reach their cleanliness limit
         * It's increased by the soil overflow amount
         * Has a higher waste limit than litter boxes and cages
         * Add the ability to clean the shelter
         * If the shelter reaches the cleanliness limit, all pets are removed by the humane society

         */

         // Add a method that has pets run away if happiness reaches 0
    }

    private static void listAllOrganicPets() {
        System.out.println("Organic Pets in Shelter");
        StringBuilder organicPetsList = new StringBuilder();

        organicPetsList.append("Name");
        for (int i = 0; i < 6; i++) {
            organicPetsList.append(" ");
        }

        organicPetsList.append("|");
        organicPetsList.append("Hunger");
        for (int i = 0; i < 4; i++) {
            organicPetsList.append(" ");
        }

        organicPetsList.append("|");
        organicPetsList.append("Thirst");
        for (int i = 0; i < 4; i++) {
            organicPetsList.append(" ");
        }

        organicPetsList.append("|");
        organicPetsList.append("Boredom");
        for (int i = 0; i < 3; i++) {
            organicPetsList.append(" ");
        }

        organicPetsList.append("|");
        organicPetsList.append("Health");
        for (int i = 0; i < 4; i++) {
            organicPetsList.append(" ");
        }

        organicPetsList.append("|");
        organicPetsList.append("Happiness");
        organicPetsList.append(" \n");





        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }
        organicPetsList.append("|");
        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }
        organicPetsList.append("|");
        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }
        organicPetsList.append("|");
        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }
        organicPetsList.append("|");
        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }
        organicPetsList.append("|");
        for (int i = 0; i < 10; i++) {
            organicPetsList.append("-");
        }

        organicPetsList.append("\n");

        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet);
                organicPetsList.append(organicCat.getPetName());
                for (int i = 0; i < 10 - organicCat.getPetName().length(); i++) {
                    organicPetsList.append(" ");
                }
                organicPetsList.append("|");

                if (organicCat.getHungerLevel() < 10 && organicCat.getThirstLevel() < 10) {
                    organicPetsList.append(organicCat.getHungerLevel() + "         ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getThirstLevel() + "         ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getBoredomLevel());
                    organicPetsList.append("\n");
                } else if (organicCat.getHungerLevel() >= 10 && organicCat.getThirstLevel() < 10) {
                    organicPetsList.append(organicCat.getHungerLevel() + "        ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getThirstLevel() + "         ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getBoredomLevel());
                    organicPetsList.append("\n");  
                } else if (organicCat.getHungerLevel() < 10 && organicCat.getThirstLevel() >= 10) {
                    organicPetsList.append(organicCat.getHungerLevel() + "         ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getThirstLevel() + "        ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getBoredomLevel());
                    organicPetsList.append("\n");  
                } else {
                    organicPetsList.append(organicCat.getHungerLevel() + "        ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getThirstLevel() + "        ");
                    organicPetsList.append("|");

                    organicPetsList.append(organicCat.getBoredomLevel());
                    organicPetsList.append("\n");
                }
            }
        }

        System.out.println(organicPetsList.toString());
    }

    private static void printMainMenu() {
        
    }
}