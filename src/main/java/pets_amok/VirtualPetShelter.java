package pets_amok;

import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;

@Getter
/**
 * The virtual pet shelter class holds the functions for the virtual pet shelter object.
 */
public class VirtualPetShelter {

/** The list of the virtual pets in the shelter */
private ArrayList<VirtualPet> virtualPetsInShelter;
private LitterBox litterBox;

    /**
     * Constructor for the VirtualPetInShelter object that creates the virtualPetsInShelter array list instance variable upon creation.
     */
    public VirtualPetShelter() {
        this.virtualPetsInShelter = new ArrayList<>();
        this.litterBox = new LitterBox();
    }

    /**
     * This method searches through the array list it takes in for an object with the pet name String it takes in. It returns the pet with that name if it's found and a null pet if it isn't found.
     * 
     * @param selectedVirtualPetName the name of the pet the user is searching for
     * @return either the pet with a name that matches the name given by the user or a null pet when the name the user is searching for was not found
     */
    public VirtualPet checkIfSelectedPetIsInShelter(String selectedVirtualPetName) {
        VirtualPet selectedVirtualPet = null;
    
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            String petInShelterName = virtualPet.getPetName();
            if (petInShelterName.toLowerCase().equals(selectedVirtualPetName.toLowerCase())) {
                selectedVirtualPet = virtualPet;
            }
        }

        return selectedVirtualPet;
    }

    /**
     * This method allows us to add a virtual pet to the list of pets in the shelter
     * @param virtualPet the virtual pet user would like to add to the shelter
     */
    public void takeInHomelessPet(VirtualPet virtualPet) {
        this.virtualPetsInShelter.add(virtualPet);
    }

    /**
     * This method allows us to remove a virtual pet from the list of pets in the shelter
     * @param virtualPet the virtual pet user would like to remove from the shelter
     */
    public void allowHomelessPetAdoption(VirtualPet virtualPet) {
        this.virtualPetsInShelter.remove(virtualPet);
    }

    /**
     * This method performs the feedPet method for each organic pet in the shelter
     */
    public void feedAllOrganicPetsInShelter() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.feedPet();

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.feedPet();
    }

    /**
     * This method performs the giveWaterToPet method for each organic pet in the shelter
     */
    public void giveAllOrganicPetsInShelterWater() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.giveWaterToPet();

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.giveWaterToPet();
    }

    /**
     * This method increases the basic life attributes (hunger, thirst, bathroom) of each organic pet in the shelter
     */
    private void increaseOrganicBaseStats() {
        Random random = new Random();

        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) {
            int randomHungerIncreaseForCat = random.nextInt(6, 17);
            organicCat.setHungerLevel(organicCat.getHungerLevel() + randomHungerIncreaseForCat);
    
            int randomThirstIncreaseForCat = random.nextInt(8, 19);
            organicCat.setThirstLevel(organicCat.getThirstLevel() + randomThirstIncreaseForCat);

            int randomBathroomStatIncreaseForCat = random.nextInt(4, 15);
            organicCat.setBathroomStat(organicCat.getBathroomStat() + randomBathroomStatIncreaseForCat);
        }

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            int randomHungerIncreaseForDog = random.nextInt(9, 20);
            organicDog.setHungerLevel(organicDog.getHungerLevel() + randomHungerIncreaseForDog);

            int randomThirstIncreaseForDog = random.nextInt(11, 22); 
            organicDog.setThirstLevel(organicDog.getThirstLevel() + randomThirstIncreaseForDog);

            int randomBathroomStatIncreaseForDog = random.nextInt(5, 16);
            organicDog.setBathroomStat(organicDog.getBathroomStat() + randomBathroomStatIncreaseForDog);
        }
    }

    /**
     * This method runs the selfCare method for each organic pet in the shelter
     */
    public void allOrganicsSelfCare() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.selfCare();

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.selfCare();
    }

    /**
     * This method runs the socialize method for each pet in the shelter
     */
    public void socializeAllPets() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) virtualPet.socialize();
    }

    /**
     * This method checks through all the pets in the shelter for any organic pets who's basic life attribute levels have reached the maximum limit or any pets who's health bar has reached 0. These are considered instances of pets passing away.
     * 
     * @return the list of pets who have died
     */
    public ArrayList<VirtualPet> listDeadPets() {
        ArrayList<VirtualPet> listOfDeadPets = new ArrayList<>();

        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) {
            if (organicCat.getHungerLevel() >= 100 || organicCat.getThirstLevel() >= 100) {
                if (organicCat.getHungerLevel() >= 100 && organicCat.getThirstLevel() < 100) organicCat.causeOfDeath = "starvation";
                else if (organicCat.getThirstLevel() >= 100 && organicCat.getHungerLevel() < 100) organicCat.causeOfDeath = "dehydration";
                listOfDeadPets.add(organicCat);
            } else if (organicCat.getHungerLevel() >= 100 && organicCat.getThirstLevel() >= 100) {
                organicCat.causeOfDeath = "starvation and dehydration";
                listOfDeadPets.add(organicCat);
            }
        }

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            if (organicDog.getHungerLevel() >= 100 || organicDog.getThirstLevel() >= 100) {
                if (organicDog.getHungerLevel() >= 100 && organicDog.getThirstLevel() < 100) organicDog.causeOfDeath = "starvation";
                else if (organicDog.getThirstLevel() >= 100 && organicDog.getHungerLevel() < 100) organicDog.causeOfDeath = "dehydration";
                listOfDeadPets.add(organicDog);
            } else if (organicDog.getHungerLevel() >= 100 && organicDog.getThirstLevel() >= 100) {
                organicDog.causeOfDeath = "starvation and dehydration";
                listOfDeadPets.add(organicDog);
            }
        }

        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.getHealthStat() <= 0) {
                virtualPet.causeOfDeath = "poor health";
                listOfDeadPets.add(virtualPet);
            }
        }

        return listOfDeadPets;
    }

    /**
     * This method is designed to check the name of the pet that is returned by the checkIfSelectedPetIsInShelter method for whether or not the pet is in the shelter
     * 
     * @param checkResultPet the pet returned by the checkIfSelectedPetIsInShelter method
     * @return true if the pet was found, false if it was not
     */
    public boolean wasPetOnList(VirtualPet checkResultPet) {
        String resultPetName = checkResultPet.getPetName();

        if (resultPetName.equals(null)) {
            return false;
        } else {
            return true;
        }
    }

    /** This method loops through all of the dogs in the shelter, checks for either organic or robotic dogs and walks the dogs it finds */
    public void walkAllDogs() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.walkDog();

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) roboticDog.walkDog();
    }

    /** This method has a 10% chance to make shelter cats feel restless. */
    private void makeCatsRestlessIfUnlucky() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.makeRestlessIfUnlucky();
    }

    /** This method gives all restless shelter cats a 10% chance to knock over the shelter litter box. */
    private void knockOverLitterBoxIfUnlucky() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.knockOverLitterBoxIfUnlucky(this.litterBox);
    }

    /** This method gives the cats the chance to use the litter box if they need to. */
    private void catsUseLitterBoxIfNecessary() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.useLitterBoxIfNecessary(this.litterBox);
    }

    /** This method cleans all of the dog cages. */
    public void cleanAllDogCages() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            Cage dogsCage = organicDog.getCage();
            dogsCage.setWasteLevel(0);
            organicDog.healthStat += 30; 
        }
    }

    /** This method empties the litter box and increases the health of all cats as a result. */
    public void emptyLitterBox() {
        this.litterBox.setWasteLevel(0);
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.healthStat += 30;
    }

    /** This method decreases the health stat of dogs when cages are dirty. */
    private void decreaseHealthStatSoiledCage() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            Cage dogsCage = organicDog.getCage();
            if (dogsCage.getWasteLevel() > 80) organicDog.healthStat -= 25;
            else if (dogsCage.getWasteLevel() > 60) organicDog.healthStat -= 20;
            else if (dogsCage.getWasteLevel() > 40) organicDog.healthStat -= 15;
            else if (dogsCage.getWasteLevel() > 20) organicDog.healthStat -= 10;
        }
    }

     /** This method decreases the health stat of all organic pets when the litter box is full. */
    private void decreaseHealthStatFullLitterBox() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().contains("Organic") && this.litterBox.getWasteLevel() > 100) virtualPet.setHealthStat(virtualPet.getHealthStat() - 30);
        }
    }

    /** This method decreases organic pets health stat if hunger and thirst are too high */
    private void decreaseHealthStatLowHungerThirstBoredom() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) {
            if (organicCat.hungerLevel > 75) organicCat.setHealthStat(organicCat.getHealthStat() - 15);
            else if (organicCat.hungerLevel > 50) organicCat.setHealthStat(organicCat.getHealthStat() - 10);

            if (organicCat.thirstLevel > 75) organicCat.setHealthStat(organicCat.getHealthStat() - 15);
            else if (organicCat.thirstLevel > 50) organicCat.setHealthStat(organicCat.getHealthStat() - 10);
        }

        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            if (organicDog.hungerLevel > 75) organicDog.setHealthStat(organicDog.getHealthStat() - 15);
            else if (organicDog.hungerLevel > 50) organicDog.setHealthStat(organicDog.getHealthStat() - 10);

            if (organicDog.thirstLevel > 75) organicDog.setHealthStat(organicDog.getHealthStat() - 15);
            else if (organicDog.thirstLevel > 50) organicDog.setHealthStat(organicDog.getHealthStat() - 10);
        }
    }

    /** This method decreases the health of robotic pets if their oil level is too low. */
    private void decreaseHealthStatLowOilLevel() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            if (roboticCat.getOilLevel() < 25) roboticCat.setHealthStat(roboticCat.getHealthStat() - 10);
            else if (roboticCat.getOilLevel() < 50) roboticCat.setHealthStat(roboticCat.getHealthStat() - 5);
        }

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) {
            if (roboticDog.getOilLevel() < 25) roboticDog.setHealthStat(roboticDog.getHealthStat() - 10);
            else if (roboticDog.getOilLevel() < 50) roboticDog.setHealthStat(roboticDog.getHealthStat() - 5);
        }
    }

    /** This method decreases the health of robotic pets if their maintenance need level is too high. */
    private void decreaseHealthStatHighMaintenanceNeedLevel() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            if (roboticCat.maintenanceNeedLevel > 75) roboticCat.healthStat -= 30;
            else if (roboticCat.maintenanceNeedLevel > 50) roboticCat.healthStat -= 15;
        }

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) {
            if (roboticDog.maintenanceNeedLevel > 75) roboticDog.healthStat -= 30;
            else if (roboticDog.maintenanceNeedLevel > 50) roboticDog.healthStat -= 15;
        }
    }

    /** This method decreases the health of organic dogs if their bathroom stat is too high. */
    private void decreaseHealthStatHighBathroomStatForDogs() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) {
            if (organicDog.bathroomStat > 75) organicDog.healthStat -= 30;
                else if (organicDog.bathroomStat > 50) organicDog.healthStat -= 15;
        }
    }

    /** This method oils all robotic pets. */
    public void oilAllRoboticPets() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) roboticCat.oilPet();

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) roboticDog.oilPet();
    }

    /** This method lets all robotic cats check for threats. If they are detecting threats, they sound an alarm which will annoy the other pets. */
    public void checkForThreats() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            if (roboticCat.isDetectingThreats()) {
                ArrayList<VirtualPet> petsInShelter = this.virtualPetsInShelter;
                petsInShelter.remove(roboticCat);
                for (VirtualPet virtualPetAgain : petsInShelter) {
                    virtualPetAgain.setHappinessLevel(virtualPetAgain.getHappinessLevel() - 10);
                }
            }
        }
    }

    /** This method resets the maintenance needed level of all robotic pets back to 0. */
    public void performMaintenanceOnAllRoboticPets() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) roboticCat.performMaintenance();

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) roboticDog.performMaintenance();
    }

    /** This method sets the litter box upright again. */
    public void setLitterBoxUpright() {
        this.litterBox.setUpright(true);
    }

    /** This method functions as passing time and makes necessary changes to pets stats. */
    public void tick() {
        resetDogWalkTracking();
        increaseOrganicBaseStats();
        increaseEveryonesBoredom();
        decreaseOrIncreaseRoboticBaseStats();
        checkForAlarms();
        makeCatsRestlessIfUnlucky();
        makeDogsSoilCageIfUnlucky();
        catsUseLitterBoxIfNecessary();
        knockOverLitterBoxIfUnlucky();
        decreaseHealthStatSoiledCage();
        decreaseHealthStatFullLitterBox();
        decreaseHealthStatLowHungerThirstBoredom();
        decreaseHealthStatLowOilLevel();
        decreaseHealthStatHighBathroomStatForDogs();
        decreaseHealthStatHighMaintenanceNeedLevel();
        decreaseHealthStatIsMalfunctioning();
        trackDogWalkingFrequency();
        socializeAllPets();
        allOrganicsSelfCare();
        listDeadPets();
    }

    /** This method sets the wasWalkedLastTick instance variable of organic dogs to true if they have been walked this tick. */
    private void trackDogWalkingFrequency() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) if (organicDog.isHasBeenWalkedThisTick()) organicDog.setWasWalkedLastTick(true);
    }

    /** This method decreases the health stat of the robotic pets if the are malfunctioning. */
    private void decreaseHealthStatIsMalfunctioning() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) if (roboticCat.isMalfunctioning()) roboticCat.healthStat -= 25;

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) if (roboticDog.isMalfunctioning()) roboticDog.healthStat -= 25;
    }

    /** This method sets the hasBeenWalkedThisTick instance variable of organic dogs to false.  */
    private void resetDogWalkTracking() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.setHasBeenWalkedThisTick(false);
    }

    /** This method gives each organic dog the chance to soil their cage. */
    private void makeDogsSoilCageIfUnlucky() {
        ArrayList<OrganicDog> organicDogs = listOrganicDogs();
        for (OrganicDog organicDog : organicDogs) organicDog.soilCageIfUnlucky();
    }

    /** This method checks to sse is any robotic cats are detecting threats. Any cats who are detecting threats sounds an alarm. This alarm sound annoys the rest of the pets, causing a slight decrease in happiness. */
    private void checkForAlarms() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            roboticCat.determineIfCatIsDetectingThreats();
            if (roboticCat.isDetectingThreats()) roboticCat.soundAlarm(virtualPetsInShelter);
        }
        
    }

    /** This method decreases the robotic base stats that start at 100 and increases the base stats that start at 0. */
    private void decreaseOrIncreaseRoboticBaseStats() {
        decreaseAllRobotsBatteryLevel();
        decreaseAllRobotsOilLevel();
        increaseAllRobotsMaintenanceNeededLevel();
    }

    /** This method increases the maintenance needed stat for each robotic pet. */
    private void increaseAllRobotsMaintenanceNeededLevel() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            Random random = new Random();
            roboticCat.maintenanceNeedLevel += random.nextInt(4, 15);
        }

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) {
            Random random = new Random();
            roboticDog.maintenanceNeedLevel += random.nextInt(5, 16);
        }
    }

    /** This method decreases the oil level of each robotic pet. */
    private void decreaseAllRobotsOilLevel() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            Random random = new Random();
            roboticCat.oilLevel -= random.nextInt(2, 8);
        }

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) {
            Random random = new Random();
            roboticDog.oilLevel -= random.nextInt(4, 13);
        }
    }

    /** This method decreases the battery level of each robotic pet. */
    private void decreaseAllRobotsBatteryLevel() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) {
            Random random = new Random();
            roboticCat.batteryLevel -= random.nextInt(5, 11);
            if (roboticCat.batteryLevel < 0) roboticCat.batteryLevel = 0;
        }

        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();
        for (RoboticDog roboticDog : roboticDogs) {
            Random random = new Random();
            roboticDog.batteryLevel -= random.nextInt(6, 12);
            if (roboticDog.batteryLevel < 0) roboticDog.batteryLevel = 0;
        }
    }

    /** This method increases the boredom stat of each pet. */
        private void increaseEveryonesBoredom() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            Random random = new Random();
            int randomNumber = random.nextInt(1, 11);
            virtualPet.boredomLevel = virtualPet.boredomLevel + randomNumber;
        }
    }

    /** This method puts all robotics cats that are detecting threats onto one array list. */
    public ArrayList<RoboticCat> listCatsDetectingThreats() {
        ArrayList<RoboticCat> catsDetectingThreats = new ArrayList<>();
        RoboticCat roboticCat = new RoboticCat();

        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Cat")) {
                roboticCat = (RoboticCat) virtualPet;
                if (roboticCat.isHasThreatAlarmOn()) catsDetectingThreats.add(roboticCat);
            }
        }

        return catsDetectingThreats;
    }

    /** This method puts all malfunctioning robotics cats onto one array list.  */
    public ArrayList<VirtualPet> listMalfunctioningCats() {
        ArrayList<VirtualPet> malfunctioningCats = new ArrayList<>();
        ArrayList<RoboticCat> roboticCats = listRoboticCats();

        for (RoboticCat roboticCat : roboticCats) if (roboticCat.isMalfunctioning) malfunctioningCats.add(roboticCat);

        return malfunctioningCats;
    }

    /** This method puts all robotics cats onto one array list.  */
    public ArrayList<RoboticCat> listRoboticCats() {
        ArrayList<RoboticCat> roboticCats = new ArrayList<>();
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Cat")) {
                RoboticCat roboticCat = (RoboticCat) virtualPet;
                roboticCats.add(roboticCat);
            }
        }
        return roboticCats;
    }

    /** This method puts all robotics dogs onto one array list.  */
    public ArrayList<RoboticDog> listRoboticDogs() {
        ArrayList<RoboticDog> roboticDogs = new ArrayList<>();
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Robotic Dog")) {
                RoboticDog roboticDog = (RoboticDog) virtualPet;
                roboticDogs.add(roboticDog);
            }
        }
        return roboticDogs;
    }

    /** This method puts all organic dogs onto one array list.  */
    public ArrayList<OrganicDog> listOrganicDogs() {
        ArrayList<OrganicDog> organicDogs = new ArrayList<>();
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = (OrganicDog) virtualPet;
                organicDogs.add(organicDog);
            }
        }
        return organicDogs;
    }

    /** This method puts all organic cats onto one array list.  */
    public ArrayList<OrganicCat> listOrganicCats() {
        ArrayList<OrganicCat> organicCats = new ArrayList<>();
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = (OrganicCat) virtualPet;
                organicCats.add(organicCat);
            }
        }
        return organicCats;
    }

    /** This method soothes all cats that are feeling restless. */
    public void sootheAllRestlessCats() {
        ArrayList<OrganicCat> restlessCats = listRestlessCats();
        for (OrganicCat restlessCat : restlessCats) restlessCat.sootheCat();
    }

    /**
     * 
     */
    public void repairAllMalfunctionedRobots() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();

        for (RoboticCat roboticCat : roboticCats) roboticCat.repairMalfunction();
        for (RoboticDog roboticDog : roboticDogs) roboticDog.repairMalfunction();
    }

    /**
     * 
     * @return
     */
    public ArrayList<OrganicCat> listRestlessCats() {
        ArrayList<OrganicCat> organicCats = listOrganicCats();
        ArrayList<OrganicCat> restlessCats = new ArrayList<>();

        for (OrganicCat organicCat : organicCats) if (organicCat.isFeelingRestless()) restlessCats.add(organicCat);

        return restlessCats;
    }

    /**
     *  This method resets the battery level of all robots back to 100.
     */
    public void rechargeAllRobots() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        ArrayList<RoboticDog> roboticDogs = listRoboticDogs();

        for (RoboticCat roboticCat : roboticCats) roboticCat.rechargeBattery();
        for (RoboticDog roboticDog : roboticDogs) roboticDog.rechargeBattery();
    }

    public void handleAllDetectedThreats() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) if (roboticCat.isHasThreatAlarmOn()) roboticCat.handleDetectedThreats();
    }

    public void playWithAllPets() {
        for (VirtualPet virtualPet : virtualPetsInShelter) virtualPet.playWithPet();
    }

    public void petAllCats() {
        ArrayList<RoboticCat> roboticCats = listRoboticCats();
        for (RoboticCat roboticCat : roboticCats) roboticCat.petCat();

        ArrayList<OrganicCat> organicCats = listOrganicCats();
        for (OrganicCat organicCat : organicCats) organicCat.petCat();
    }
}