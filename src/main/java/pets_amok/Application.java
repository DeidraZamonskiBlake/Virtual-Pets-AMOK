package pets_amok;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

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
     * The main method serving as the entry point of the application. It handles the user input and output, and it runs the game loop. It also utilizes the functions of our virtual pet shelter class as well as the functions of the individual virtual pets, the dog cages and the litter box.
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
        listAllOrganicPetsStats();

        System.out.println();
        System.out.println();
        System.out.println();
        listCleanlinessOfCages();

        System.out.println();
        listCleanlinessOfLitterBox();
        // print litter box position

        System.out.println();
        System.out.println();
        System.out.println();

        listAllRoboticPetsStats();

        System.out.println();
        System.out.println();
        System.out.println();

        // print Main Menu
        printMainMenu();
        int usersSelection = scanner.nextInt();
        scanner.nextLine();
        runUsersSelection(usersSelection);

        System.out.println();
        scanner.close();

        // give main menu functionality
        // add repair malfunctioned robot function for robots under individual interaction

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
         * decreaseHealthStatHighMaintenanceNeedLevel
         * decreaseHealthStatIsMalfunctioning
         * socializeAllPets
         * allOrganicsSelfCare
         * checkForDeadPets
         * removeDeadPets
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

         // Make bathroomStat increase when organic pets eat or drink

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

    // System.out.println("1: Feed Organic Pets");
    // System.out.println("2: Give Organic Pets Water");
    // System.out.println("3: Oil Robotic Pets");
    // System.out.println("4: Perform Maintenance on All Robotic Pets");
    // System.out.println("5: Walk All Dogs");
    // System.out.println("6: Interact With Individual Pet");
    // System.out.println("7: Clean All Cages");
    // System.out.println("8: Empty Litter Box");
    // System.out.println("9: Set Litter Box Upright");
    // System.out.println("10: Take In Homeless Pet");
    // System.out.println("11: Allow a Pet to Be Adopted");
    // System.out.println("12: Exit"); 

    private static void runUsersSelection(int usersSelection) {
        switch (usersSelection) {
            case 1:
                shelterForPets.feedAllOrganicPetsInShelter();
                break;
            case 2:
                shelterForPets.giveAllOrganicPetsInShelterWater();
                break;
            case 3: 
                shelterForPets.oilAllRoboticPets();
                break;
            case 4:
                shelterForPets.performMaintenanceOnAllRoboticPets();
                break;
            case 5:
                shelterForPets.walkAllDogs();
                break;
            case 6:
                runCase6();
            default:
                System.out.println("You have entered an invalid response, please try again.");
        }
    }

    private static void runCase6() {
        System.out.println();
        System.out.println("Pets in Shelter");
        int i = 1; 
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            System.out.println(i + ": " + virtualPet.petName);
            i++;
        }
    }

    /** This method prints the main menu output. */
    private static void printMainMenu() {
        System.out.println("1: Feed Organic Pets");
        System.out.println("2: Give Organic Pets Water");
        System.out.println("3: Oil Robotic Pets");
        System.out.println("4: Perform Maintenance on All Robotic Pets");
        System.out.println("5: Walk All Dogs");
        System.out.println("6: Interact With Individual Pet");
        System.out.println("7: Clean All Cages");
        System.out.println("8: Empty Litter Box");
        System.out.println("9: Set Litter Box Upright");
        System.out.println("10: Take In Homeless Pet");
        System.out.println("11: Allow a Pet to Be Adopted");
        System.out.println("12: Exit"); 
        System.out.println();
        System.out.println("Enter a number to make a selection:");
    }

    /** This method prints the waste level of the litter box. */
    private static void listCleanlinessOfLitterBox() {
        LitterBox litterBox = shelterForPets.getLitterBox();

        System.out.println();
        System.out.print("Litter Box Waste Level: " + litterBox.getWasteLevel());
    }

    /** This method lists the waste level of each organic dog's cage underneath a header. */
    private static void listCleanlinessOfCages() {
        printCleanlinessOfCagesHeader();
        listCagesStat();
    }

    /** This method prints the waste level of each organic dogs cage. */
    private static void listCagesStat() {
        System.out.println();
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = (OrganicDog) virtualPet;
                String dogsName = organicDog.petName;
                Cage dogsCage = organicDog.getCage();
                String cageWasteLevel = makeStatUniform(dogsCage.getWasteLevel());

                System.out.print(dogsName);
                for (int i = 0; i < 11 - dogsName.length(); i++) System.out.print(" ");
                System.out.print("|  " + cageWasteLevel + "\n");
            }
        }
        
    }

    /** This method prints the header for the list od organic dog cages. */
    private static void printCleanlinessOfCagesHeader() {
        System.out.print("Cage Owner |  Waste Level");
        System.out.println();
        for (int i = 0; i < 26; i++) System.out.print("-");
    }

    /** This method prints a list of all robotic pets underneath a header. */
    private static void listAllRoboticPetsStats() {
        printRoboticPetListHeader();
        listRoboticCatsStats();
        listRoboticDogStats();
    }

    /** This method prints a list of robotic dogs and their stats. */
    private static void listRoboticDogStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Dog")) {
                RoboticDog roboticDog = (RoboticDog) virtualPet;
                String dogName = roboticDog.petName;
                String dogOilLevel = Integer.toString(roboticDog.oilLevel);
                String dogMaintenanceNeed = Integer.toString(roboticDog.maintenanceNeedLevel);
                String dogBatteryLevel = Integer.toString(roboticDog.batteryLevel);
                String dogHealthStat = Integer.toString(roboticDog.healthStat);
                String dogHappinessStat = Integer.toString(roboticDog.happinessLevel);

                System.out.println();
                System.out.print(dogName);
                for (int i = 0; i < 13 - dogName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogOilLevel);
                for (int i = 0; i < 8; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogHappinessStat);
                for (int i = 0; i < 6; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogBatteryLevel);
                for (int i = 0; i < 10; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogHealthStat);
                for (int i = 0; i < 5; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogMaintenanceNeed);
            }
        }
    }

    /** This method prints a list of robotic cats and their stats. */
    private static void listRoboticCatsStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Cat")) {
                RoboticCat roboticCat = (RoboticCat) virtualPet;
                String catName = roboticCat.petName;
                String catOilLevel = Integer.toString(roboticCat.oilLevel);
                String catMaintenanceNeed = Integer.toString(roboticCat.maintenanceNeedLevel);
                String catBatteryLevel = Integer.toString(roboticCat.batteryLevel);
                String catHealthStat = Integer.toString(roboticCat.healthStat);
                String catHappinessStat = Integer.toString(roboticCat.happinessLevel);

                System.out.println();
                System.out.print(catName);
                for (int i = 0; i < 13 - catName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catOilLevel);
                for (int i = 0; i < 8; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catHappinessStat);
                for (int i = 0; i < 6; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catBatteryLevel);
                for (int i = 0; i < 10; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catHealthStat);
                for (int i = 0; i < 5; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catMaintenanceNeed);
            }
        }
        
    }

    /** This method prints a header for the list of robotic pets. */
    private static void printRoboticPetListHeader() {
        System.out.print("Robotic Pet  |  ");
        // 13 long
        System.out.print("Oil Level  | ");
        // 17 long
        System.out.print("Happiness | ");
        // 17
        System.out.print("Battery Level |  ");
        // 9
        System.out.print("Health  |  ");
        System.out.print("Maintenance Need");

        System.out.println();
        for (int i = 0; i < 88; i++) System.out.print("-");
    }

    /** This method prints a list of all organic pets underneath a header. */
    private static void listAllOrganicPetsStats() {
        printOrganicPetsListHeader();
        listOrganicDogsStats();
        listOrganicCatsStats();
    }

    /** This method prints a list of organic cats and their stats. */
    private static void listOrganicCatsStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = (OrganicCat) virtualPet;

                String catHealthStatString = makeStatUniform(organicCat.getHealthStat());
                String catHungerStatString = makeStatUniform(organicCat.getHungerLevel());
                String catThirstStatString = makeStatUniform(organicCat.getThirstLevel());
                String catBathroomStatString = makeStatUniform(organicCat.getBathroomStat());
                String catBoredomStatString = makeStatUniform(organicCat.getBoredomLevel());
                String catHappinessStatString = makeStatUniform(organicCat.getHappinessLevel());

                System.out.println();
                String catName = organicCat.petName;
                System.out.print(catName);
                for (int i = 0; i < 13 - catName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catHealthStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catHungerStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catThirstStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catBathroomStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catBoredomStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(catHappinessStatString);
            }
        }
    }

    /**
     * This method changes the integer it takes in into a string that always has a length of 3 or more.
     * @param petStat the pet stat to change
     * @return the changed pet stat
     */
    private static String makeStatUniform(int petStat) {
        if (petStat < 10) return Integer.toString(petStat) + "  ";
        else if (petStat < 100) return Integer.toString(petStat) + " ";
        else return Integer.toString(petStat);
    }

    /** This method prints a list of organic dogs and their stats. */
    private static void listOrganicDogsStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = (OrganicDog) virtualPet;

                String dogHealthStatString = makeStatUniform(organicDog.getHealthStat());
                String dogHungerStatString = makeStatUniform(organicDog.getHungerLevel());
                String dogThirstStatString = makeStatUniform(organicDog.getThirstLevel());
                String dogBathroomStatString = makeStatUniform(organicDog.getBathroomStat());
                String dogBoredomStatString = makeStatUniform(organicDog.getBoredomLevel());
                String dogHappinessStatString = makeStatUniform(organicDog.getHappinessLevel());

                System.out.println();
                String dogName = organicDog.petName;
                System.out.print(dogName);
                for (int i = 0; i < 13 - dogName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogHealthStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogHungerStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogThirstStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogBathroomStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogBoredomStatString);
                for (int i = 0; i < 6 ; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogHappinessStatString);
            }
        }
    }

    /** This method prints a header for the list of robotic pets. */
    private static void printOrganicPetsListHeader() {
        System.out.print("Organic Pet  ");
        System.out.print("|  ");

        System.out.print("Health");
        for (int i = 0; i < 3; i++) System.out.print(" ");
        System.out.print("|  ");

        System.out.print("Hunger");
        for (int i = 0; i < 3; i++) System.out.print(" ");
        System.out.print("|  ");

        System.out.print("Thirst");
        for (int i = 0; i < 3; i++) System.out.print(" ");
        System.out.print("|  ");

        System.out.print("Bathroom");
        System.out.print(" ");
        System.out.print("|  ");

        System.out.print("Boredom");
        for (int i = 0; i < 2; i++) System.out.print(" ");
        System.out.print("|  ");

        System.out.print("Happiness");

        System.out.println();
        for (int i = 0; i < 85; i++) System.out.print("-");
    }
}