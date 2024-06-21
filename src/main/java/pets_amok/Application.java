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

    private static ArrayList<VirtualPet> deadPets;

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

        runMainMenu();
        System.out.println();
        scanner.close();

        // update jocdoc so that methods have multiline comments

    }

    /**
     * This method prints all of the display lists and stats of the program.
     */
    private static void printListsAndStats() {
        listAllOrganicPetsStats();

        System.out.println();
        System.out.println();
        System.out.println();
        listCleanlinessOfCages();

        System.out.println();
        listCleanlinessOfLitterBox();
        printLitterBoxPosition();

        System.out.println();
        listRestlessCats();
        printThreatDetectionStatus();

        System.out.println();
        System.out.println();

        listAllRoboticPetsStats();

        System.out.println();
        System.out.println();
        System.out.println();

        listMalfunctioningCats();
    }

    /**
     * This method prints a list of dead pets, if there are any, and their cause of death.
     */
    private static void printIfAnyPetsDied() {
        System.out.println();
        if (deadPets.size() > 0) {
            for (VirtualPet deadPet : deadPets) System.out.println(deadPet.petName + " has died from " + deadPet.getCauseOfDeath() + "!");
        }
        System.out.println();
    }

    /**
     * This method prints out all restless cats in list form.
     */
    private static void listRestlessCats() {
        ArrayList<OrganicCat> restlessCats = shelterForPets.listRestlessCats();
        int i = 1;
        if (restlessCats.size() > 0) {
            System.out.println();
            System.out.println("Restless Cats - These cats knock over the litter box, making it unusable for all shelter cats. Soothe them to make them feel better!");
            for (OrganicCat restlessCat : restlessCats) {
                System.out.println(" " + i + ": " + restlessCat.petName);
                i++;
            }
        }
    }

    /**
     * This method prints all malfunctioning robotic cats in list form.
     */
    private static void listMalfunctioningCats() {
        ArrayList<VirtualPet> malfunctioningCats = shelterForPets.listMalfunctioningCats();
        if (malfunctioningCats.size() > 0) {
            System.out.println("Malfunctioning Robotic Cats - These cats will detect an unnaturally high number number of threats. Repair them to correct their accuracy!");
            int i = 1;
            for (VirtualPet malfunctioningCat : malfunctioningCats) {
                System.out.println(" " + i + ": " + malfunctioningCat.petName);
                i++;
            }
        }
        
    }

    /** 
     * This method prints the status of whether any cats are detecting threats and list the cats who are detecting threats if there are any.
     */
    private static void printThreatDetectionStatus() {
        if (shelterForPets.listCatsDetectingThreats().size() > 0) {
            System.out.println();
            System.out.println();
            System.out.print("Threat Detection Alarm Status: ON");
            System.out.println();
            System.out.println("Cats Detecting Threats - These cats will sound their threat alarm if they detect threats. The alarm annoys the other animals in the shelter. Handle their threats to turn off their alarm!");
            ArrayList<RoboticCat> catsDetectingThreats = shelterForPets.listCatsDetectingThreats();
            int i = 1;
            for (RoboticCat roboticCat : catsDetectingThreats) {
                System.out.println(" " + i + ": " + roboticCat.petName);
                i++;
            }
        } else {
            System.out.println();
            System.out.println();
            System.out.println("Threat Detection Alarm Status: OFF");
        }
    }

    /** 
     * This method prints the current position of the shelter litter box.
     */
    private static void printLitterBoxPosition() {
        System.out.println();
        System.out.print("Litter Box Position: ");
        LitterBox litterBox = shelterForPets.getLitterBox();
        if (litterBox.isUpright()) System.out.print(" Upright");
        else System.out.print("Fallen\nSet litter box upright so the cats can use it again!");

    }

    /** 
     * This method prints the output for interacting with an individual pet based on the pets category.
     */
    private static void interactWithPet(VirtualPet selectedPet) {
        if (selectedPet.returnType().equals("Organic Cat")) {
            OrganicCat organicCat = (OrganicCat) selectedPet;
            interactWithOrganicCat(organicCat);
        } else if (selectedPet.returnType().equals("Organic Dog")) {
            OrganicDog organicDog = (OrganicDog) selectedPet;
            interactWithOrganicDog(organicDog);
        } else if (selectedPet.returnType().equals("Robotic Cat")) {
            RoboticCat roboticCat = (RoboticCat) selectedPet;
            interactWithRoboticCat(roboticCat);
        } else {
            RoboticDog roboticDog = (RoboticDog) selectedPet;
            interactWithRoboticDog(roboticDog);
        }
    }

    /** 
     * This method prints the interaction menu for robotic dogs.
     */
    private static void interactWithRoboticDog(RoboticDog roboticDog) {
        String dogName = roboticDog.petName;
        System.out.println(dogName + " is an robotic dog. What would you like to do with this pet?");
        System.out.println("1: Recharge Dog's Battery");
        System.out.println("2: Give Dog Oil");
        System.out.println("3: Perform Maintenance on Dog");
        System.out.println("4: Play With Dog");
        System.out.println("5: Repair Dog's Malfunction");
        System.out.println("6: Walk Dog");
        System.out.println("7: Allow Adoption");
        System.out.println();
        System.out.println("Enter a number to make a selection:");
        int usersRoboticDogInteractionSelection = scanner.nextInt();
        scanner.nextLine();

        switch (usersRoboticDogInteractionSelection) {
            case 1:
                roboticDog.rechargeBattery();
                break;
            case 2:
                roboticDog.oilPet();
                break;
            case 3:
                roboticDog.performMaintenance();
                break;
            case 4:
                roboticDog.playWithPet();
                break;
            case 5:
                roboticDog.repairMalfunction();
                break;
            case 6:
                roboticDog.walkDog();
                break;
            case 7:
                shelterForPets.allowHomelessPetAdoption(roboticDog);
                System.out.println();
                System.out.println(roboticDog.petName + " has been adopted!");
            default:
                System.out.println("You have entered an invalid response, please try again.");
        }
    }

    /** 
     * This method prints the interaction menu for robotic cats.
     */
    private static void interactWithRoboticCat(RoboticCat roboticCat) {
        String catName = roboticCat.petName;
        System.out.println(catName + " is an robotic cat. What would you like to do with this pet?");
        System.out.println("1: Recharge Cat's Battery");
        System.out.println("2: Give Cat Oil");
        System.out.println("3: Perform Maintenance on Cat");
        System.out.println("4: Play With Cat");
        System.out.println("5: Repair Cat's Malfunction");
        System.out.println("6: Handle Cat's Detected Threats");
        System.out.println("7: Allow Adoption");
        System.out.println();
        System.out.println("Enter a number to make a selection:");
        int usersRoboticCatInteractionSelection = scanner.nextInt();
        scanner.nextLine();

        switch (usersRoboticCatInteractionSelection) {
            case 1:
                roboticCat.rechargeBattery();
                break;
            case 2:
                roboticCat.oilPet();
                break;
            case 3:
                roboticCat.performMaintenance();
                break;
            case 4:
                roboticCat.repairMalfunction();
                break;
            case 5:
                roboticCat.handleDetectedThreats();
                break;
            case 6:
                shelterForPets.allowHomelessPetAdoption(roboticCat);
                System.out.println();
                System.out.println(roboticCat.petName + " has been adopted!");
                break;
            default:
                System.out.println("You have entered an invalid response, please try again.");
        }
    }

        /** 
         * This method prints output for the interactions specific to the organic dog.
         */
        private static void interactWithOrganicDog(OrganicDog organicDog) {
            String dogName = organicDog.petName;
            System.out.println(dogName + " is an organic dog. What would you like to do with this pet?");
            System.out.println("1: Feed Dog");
            System.out.println("2: Give Dog Water");
            System.out.println("3: Play With Dog");
            System.out.println("4: Walk Dog");
            System.out.println("5: Clean Dog Cage");
            System.out.println("6: Allow Adoption");
            System.out.println();
            System.out.println("Enter a number to make a selection:");
            int usersOrganicDogInteractionSelection = scanner.nextInt();
            scanner.nextLine();
    
            switch (usersOrganicDogInteractionSelection) {
                case 1:
                    organicDog.feedPet();
                    break;
                case 2:
                    organicDog.giveWaterToPet();
                    break;
                case 3:
                    organicDog.playWithPet();
                    break;
                case 4:
                    organicDog.walkDog();
                    break;
                case 5:
                    Cage cage = organicDog.getCage();
                    cage.setWasteLevel(0);
                    break;
                case 6:
                    shelterForPets.allowHomelessPetAdoption(organicDog);
                    System.out.println();
                    System.out.println(organicDog.petName + " has been adopted!");
                    break;
                default:
                    System.out.println("You have entered an invalid response, please try again.");
            }
        }

    /** 
     * This method prints output for the interactions specific to the organic cat.
     */
    private static void interactWithOrganicCat(OrganicCat organicCat) {
        String catName = organicCat.petName;
        System.out.println(catName + " is an organic cat. What would you like to do with this pet?");
        System.out.println("1: Feed Cat");
        System.out.println("2: Give Cat Water");
        System.out.println("3: Play With Cat");
        System.out.println("4: Pet Cat");
        System.out.println("5: Soothe Cat");
        System.out.println("6: Allow Adoption");
        System.out.println();
        System.out.println("Enter a number to make a selection:");
        int usersOrganicCatInteractionSelection = scanner.nextInt();
        scanner.nextLine();

        switch (usersOrganicCatInteractionSelection) {
            case 1:
                organicCat.feedPet();
                break;
            case 2:
                organicCat.giveWaterToPet();
                break;
            case 3:
                organicCat.playWithPet();
                break;
            case 4:
                System.out.println();
                if (organicCat.petCat().equals("purr")) System.out.println(catName + " purred.");
                else System.out.println(catName + " hissed at you!");
                break;
            case 5:
                organicCat.sootheCat();
                System.out.println();
                System.out.println(organicCat.petName + " has been soothed.");
            case 6:
                shelterForPets.allowHomelessPetAdoption(organicCat);
                System.out.println();
                System.out.println(organicCat.petName + " has been adopted!");
                break;
            default:
                System.out.println("You have entered an invalid response, please try again.");
        }
    }

    /** 
     * This method prints the names of all pets in the shelter on a list.
     */
    private static void printAllPetNames() {
        System.out.println();
        System.out.println("Pets in Shelter");

        int i = 1; 
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            System.out.println(i + ": " + virtualPet.petName);
            i++;
        }
    }

    /**
     * This method prints the output for selecting a pet from the shelter.
     * @return virtual pet selected from shelter by user
     */
    private static VirtualPet selectAPetFromShelter() {
        printAllPetNames();
        System.out.println();
        System.out.println("Which pet would you like to interact with?");
        System.out.println("Enter a number to make a selection:");
        int usersPetSelection = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return virtualPetsInShelter.get(usersPetSelection - 1);
    } 

    /** 
     * This method prints the main menu output. 
    */
    private static void runMainMenu() {
        while (true) {
            shelterForPets.tick();
            deadPets = shelterForPets.listDeadPets();
            removeDeadPetsFromShelterListIfAny();
            printIfAnyPetsDied();
            printListsAndStats();

            System.out.println("1: Feed Organic Pets");
            System.out.println("2: Give Organic Pets Water");
            System.out.println("3: Play With All Pets");
            System.out.println("4: Oil Robotic Pets");
            System.out.println("5: Pet All Cats");
            System.out.println("6: Perform Maintenance on All Robotic Pets");
            System.out.println("7: Recharge All Robotic Pets");
            System.out.println("8: Walk All Dogs");
            System.out.println("9: Soothe All Restless Cats");
            System.out.println("10: Repair All Malfunctioned Robots");
            System.out.println("11: Handle All Detected Threats");
            System.out.println("12: Interact With Individual Pet");
            System.out.println("13: Clean All Cages");
            System.out.println("14: Empty Litter Box");
            System.out.println("15: Set Litter Box Upright");
            System.out.println("16: Take In Homeless Pet");
            System.out.println("17: Allow a Pet to Be Adopted");
            System.out.println("18: Exit"); 
            System.out.println();
            System.out.println("Enter a number to make a selection:");
            int usersSelection = scanner.nextInt();
            scanner.nextLine();

            switch (usersSelection) {
                case 1:
                    shelterForPets.feedAllOrganicPetsInShelter();
                    break;
                case 2:
                    shelterForPets.giveAllOrganicPetsInShelterWater();
                    break;
                case 3: 
                    shelterForPets.playWithAllPets();
                    break;
                case 4: 
                    shelterForPets.oilAllRoboticPets();
                    break;
                case 5:
                    shelterForPets.petAllCats();
                    break;
                case 6:
                    shelterForPets.performMaintenanceOnAllRoboticPets();
                    break;
                case 7:
                    shelterForPets.rechargeAllRobots();
                    break;
                case 8:
                    shelterForPets.walkAllDogs();
                    break;
                case 9:
                    shelterForPets.sootheAllRestlessCats();
                    break;
                case 10:
                    shelterForPets.repairAllMalfunctionedRobots();
                    break;
                case 11: 
                    shelterForPets.handleAllDetectedThreats();
                    break;
                case 12:
                    interactWithPet(selectAPetFromShelter());
                    break;
                case 13:
                    shelterForPets.cleanAllDogCages();
                    break;
                case 14:
                    shelterForPets.emptyLitterBox();
                    break;
                case 15:
                    shelterForPets.setLitterBoxUpright();
                    break;
                case 16:
                    printTakeInHomelessPet();
                    break;
                case 17:
                    printAllowPetAdoption();
                    break;
                case 18:
                    System.exit(0);
                default:
                    System.out.println("You have entered an invalid response, please try again.");
            }

            System.out.println();
            shelterForPets.tick();
        }
    }

    /**
     * This method removes dead pets from the list of pets in the shelter if there are any.
     */
    private static void removeDeadPetsFromShelterListIfAny() {
        ArrayList<VirtualPet> listOfDeadPets = shelterForPets.listDeadPets();

        for (VirtualPet deadPet : listOfDeadPets) {
            virtualPetsInShelter.remove(deadPet);
        }
    }

    /** 
     * This method prints the output for allowing a pet to be adopted out of the shelter.
     */
    private static void printAllowPetAdoption() {
        printAllPetNames();
        System.out.println();
        System.out.println("Which pet would you like to allow to be adopted?");
        int usersPetSelection = scanner.nextInt();

        VirtualPet adoptedPet = virtualPetsInShelter.get(usersPetSelection - 1);
        shelterForPets.allowHomelessPetAdoption(adoptedPet);

        System.out.println();
        System.out.println(adoptedPet.petName + " has been adopted!");
        System.out.println();
    }

    /** 
     * This method prints the output for taking a new homeless in to the shelter.
     */
    private static void printTakeInHomelessPet() {
        System.out.println();
        System.out.println("This shelter cares for four different kinds of pets:");
        System.out.println("1: Organic Cats");
        System.out.println("2: Organic Dogs");
        System.out.println("3: Robotic Cats");
        System.out.println("4: Robotic Dogs");
        System.out.println();
        System.out.println("Which type of pet would like to take in?");
        System.out.println("Enter a number to make a selection:");
        int usersNewPetSelection = scanner.nextInt();
        scanner.nextLine();

        switch (usersNewPetSelection) {
            case 1:
                System.out.println();
                System.out.println("What is the name of the new organic cat?");
                String newCatName = scanner.nextLine();

                System.out.println();
                System.out.println("What is the description of the new cat?");
                String newCatDescription = scanner.nextLine();

                OrganicCat organicCat = new OrganicCat(newCatName, newCatDescription);
                shelterForPets.takeInHomelessPet(organicCat);

                System.out.println();
                System.out.println(organicCat.petName + " has been added to the shelter!");
                break;
            case 2:
                System.out.println();
                System.out.println("What is the name of the new organic dog?");
                String newDogName = scanner.nextLine();

                System.out.println();
                System.out.println("What is the description of the new dog?");
                String newDogDescription = scanner.nextLine();

                OrganicDog organicDog = new OrganicDog(newDogName, newDogDescription);
                shelterForPets.takeInHomelessPet(organicDog);

                System.out.println();
                System.out.println(organicDog.petName + " has been added to the shelter!");
                break;
            case 3:
                System.out.println();
                System.out.println("What is the name of the new robotic cat?");
                String newRobotCatName = scanner.nextLine();

                System.out.println();
                System.out.println("What is the description of the new cat?");
                String newRobotCatDescription = scanner.nextLine();

                RoboticCat roboticCat = new RoboticCat(newRobotCatName, newRobotCatDescription);
                shelterForPets.takeInHomelessPet(roboticCat);

                System.out.println();
                System.out.println(roboticCat.petName + " has been added to the shelter!");
                break;
            case 4:
                System.out.println();
                System.out.println("What is the name of the new robotic dog?");
                String newRobotDogName = scanner.nextLine();

                System.out.println();
                System.out.println("What is the description of the new dog?");
                String newRobotDogDescription = scanner.nextLine();

                RoboticDog roboticDog = new RoboticDog(newRobotDogName, newRobotDogDescription);
                shelterForPets.takeInHomelessPet(roboticDog);

                System.out.println();
                System.out.println(roboticDog.petName + " has been added to the shelter!");
                break;
            default:
            System.out.println("You have entered an invalid response, please try again.");
        }
    }

    /** 
     * This method prints the waste level of the litter box.
     */
    private static void listCleanlinessOfLitterBox() {
        LitterBox litterBox = shelterForPets.getLitterBox();

        System.out.println();
        System.out.print("Litter Box Waste Level: " + litterBox.getWasteLevel());
    }

    /** 
     * This method lists the waste level of each organic dog's cage underneath a header.
     */
    private static void listCleanlinessOfCages() {
        printCleanlinessOfCagesHeader();
        listCagesStat();
    }

    /** 
     * This method prints the waste level of each organic dogs cage.
     */
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

    /** 
     * This method prints the header for the list od organic dog cages.
     */
    private static void printCleanlinessOfCagesHeader() {
        System.out.print("Cage Owner |  Waste Level");
        System.out.println();
        for (int i = 0; i < 26; i++) System.out.print("-");
    }

    /** 
     * This method prints a list of all robotic pets underneath a header.
     */
    private static void listAllRoboticPetsStats() {
        printRoboticPetListHeader();
        listRoboticCatsStats();
        listRoboticDogStats();
    }

    /** 
     * This method prints a list of robotic dogs and their stats.
     */
    private static void listRoboticDogStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Dog")) {
                RoboticDog roboticDog = (RoboticDog) virtualPet;
                String dogName = roboticDog.petName;
                String dogOilLevel = makeStatUniform(roboticDog.oilLevel);
                String dogMaintenanceNeed = makeStatUniform(roboticDog.maintenanceNeedLevel);
                String dogBatteryLevel = makeStatUniform(roboticDog.batteryLevel);
                String dogHealthStat = makeStatUniform(roboticDog.healthStat);
                String dogHappinessStat = makeStatUniform(roboticDog.happinessLevel);
                String dogBoredomLevel = makeStatUniform(roboticDog.boredomLevel);

                System.out.println();
                System.out.print(dogName);
                for (int i = 0; i < 13 - dogName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print("Dog");
                for (int i = 0; i < 6; i++) System.out.print(" ");
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

                System.out.print(dogBoredomLevel);
                for (int i = 0; i < 6; i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print(dogMaintenanceNeed);
            }
        }
    }

    /** 
     * This method prints a list of robotic cats and their stats.
     */
    private static void listRoboticCatsStats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Cat")) {
                RoboticCat roboticCat = (RoboticCat) virtualPet;
                String catName = roboticCat.petName;
                String catOilLevel = makeStatUniform(roboticCat.oilLevel);
                String catMaintenanceNeed = makeStatUniform(roboticCat.maintenanceNeedLevel);
                String catBatteryLevel = makeStatUniform(roboticCat.batteryLevel);
                String catHealthStat = makeStatUniform(roboticCat.healthStat);
                String catHappinessStat = makeStatUniform(roboticCat.happinessLevel);
                String catBoredomStat = makeStatUniform(roboticCat.boredomLevel);

                System.out.println();
                System.out.print(catName);
                for (int i = 0; i < 13 - catName.length(); i++) System.out.print(" ");
                System.out.print("|  ");

                System.out.print("Cat");
                for (int i = 0; i < 6; i++) System.out.print(" ");
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

                System.out.print(catBoredomStat);
                for (int i = 0; i < 6; i++) System.out.print(" ");
                System.out.print("|  ");


                System.out.print(catMaintenanceNeed);
            }
        }
        
    }

    /** 
     * This method prints a header for the list of robotic pets.
     */
    private static void printRoboticPetListHeader() {
        System.out.print("Robotic Pet  |  ");
        System.out.print("Species  |  ");
        System.out.print("Oil Level  | ");
        System.out.print("Happiness | ");
        System.out.print("Battery Level |  ");
        System.out.print("Health  |  ");
        System.out.print("Boredom  |  ");
        System.out.print("Maintenance Need");

        System.out.println();
        for (int i = 0; i < 110; i++) System.out.print("-");
    }

    /** 
     * This method prints a list of all organic pets underneath a header.
     */
    private static void listAllOrganicPetsStats() {
        printOrganicPetsListHeader();
        listOrganicDogsStats();
        listOrganicCatsStats();
    }

    /** 
     * This method prints a list of organic cats and their stats.
     */
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

                System.out.print("Cat");
                for (int i = 0; i < 6; i++) System.out.print(" ");
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

    /** 
     * This method prints a list of organic dogs and their stats.
     */
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

                System.out.print("Dog");
                for (int i = 0; i < 6; i++) System.out.print(" ");
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

    /** 
     * This method prints a header for the list of robotic pets.
     */
    private static void printOrganicPetsListHeader() {
        System.out.print("Organic Pet  ");
        System.out.print("|  ");

        System.out.print("Species");
        for (int i = 0; i < 2; i++) System.out.print(" ");
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
        for (int i = 0; i < 98; i++) System.out.print("-");
    }
}