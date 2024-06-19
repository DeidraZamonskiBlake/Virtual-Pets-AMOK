package pets_amok;

import java.util.ArrayList;
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
     * This method performs the feedPet method for each virtual pet in the shelter
     */
    public void feedAllOrganicPetsInShelter() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            String virtualPetType = virtualPet.returnType();
            if (virtualPetType.equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet);
                organicCat.feedPet();
            } else if (virtualPetType.equals("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                organicDog.feedPet();
            }
        }
    }

    /**
     * This method performs the giveWaterToPet method for each virtual pet in the shelter
     */
    public void giveAllOrganicPetsInShelterWater() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            String virtualPetType = virtualPet.returnType();
            if (virtualPetType.equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet);
                organicCat.giveWaterToPet();
            } else if (virtualPetType.equals("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                organicDog.giveWaterToPet();
            }        }
    }

    /**
     * This method increases the basic life attributes (hunger and thirst) of each organic pet in the shelter
     */
    public void increaseOrganicBaseStats() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            // Need to do
        }
    }

    /**
     * This method runs the selfCare method for each pet in the shelter
     */
    public void allSelfCare() {
        // Need to do
    }

    /**
     * This method runs the socialize method for each pet in the shelter
     */
    public void socializeAllPets() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            virtualPet.socialize();
        }
    }

    /**
     * This method checks through all the pets in the shelter for any organic pets who's basic life attribute levels have reached the maximum limit or any pets who's health bar has reached 0. These are considered instances of pets passing away.
     * 
     * @return the list of pets who have died
     */
    public ArrayList<VirtualPet> checkForDeadPets() {
        ArrayList<VirtualPet> listOfDeadPets = new ArrayList<>();

        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            
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
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                organicDog.walkDog();
            } else if (virtualPet.returnType().equals("Robotic Dog")) {
                RoboticDog robotDog = new RoboticDog(virtualPet);
                robotDog.walkDog();
            }
        }
    }

    /** This method takes in a robotic and adds it to the list of pets in the shelter signifying that it has bee repaired */
    public void repairShortCircuitedCat(RoboticCat shortCircuitedRoboticCat) {
        this.virtualPetsInShelter.add(shortCircuitedRoboticCat);
    }

    /** This method has a 10% chance to make shelter cats feel restless. */
    public void makeCatsRestlessIfUnlucky() {
        for (VirtualPet virtualPetInShelter : this.virtualPetsInShelter) {
            if (virtualPetInShelter.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPetInShelter);
                organicCat.makeRestlessIfUnlucky();
            }
        }
    }

    /** This method gives all restless shelter cats a 10% chance to knock over the shelter litter box. */
    public void knockOverLitterBoxIfUnlucky() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet);
                organicCat.knockOverLitterBoxIfUnlucky(this.litterBox);
            }
        }
    }

    /** This method gives the cats the chance to use the litter box if they need to */
    public void catsUseLitterBoxIfNecessary() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet);    
                if (organicCat.getBathroomStat() > 75 && this.litterBox.isUpright()) {
                    this.litterBox.setWasteLevel(this.litterBox.getWasteLevel() + 30);
                } 
            }
        }
    }

    /** This method cleans all of the dog cages. */
    public void cleanDogCages() {
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                Cage dogsCage = organicDog.getCage();
                dogsCage.setWasteLevel(0);
                organicDog.setHealthStat(organicDog.getHealthStat() + 30);
            }
        }
    }

    /** This method empties the litter box. */
    public void emptyLitterBox() {
        this.litterBox.setWasteLevel(0);
        for (VirtualPet virtualPet : this.virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Cat")) {
                OrganicCat organicCat = new OrganicCat(virtualPet); 
                organicCat.setHealthStat(organicCat.getHealthStat() + 30);
            }
        }   
    }

    /** This method decreases the health stat of dogs with dirty cages */
    public void decreaseHealthStatSoiledCage() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().equals("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                Cage dogsCage = organicDog.getCage();
                if (dogsCage.getWasteLevel() > 20) {
                    organicDog.setHealthStat(organicDog.getHealthStat() - 10);
                } else if (dogsCage.getWasteLevel() > 40) {
                    organicDog.setHealthStat(organicDog.getHealthStat() - 15);
                } else if (dogsCage.getWasteLevel() > 60) {
                    organicDog.setHealthStat(organicDog.getHealthStat() - 20);
                } else if (dogsCage.getWasteLevel() > 80) {
                    organicDog.setHealthStat(organicDog.getHealthStat() - 25);
                }
            }
        }
    }

     /** This method decreases the health stat of all organic pets when the litter box is full. */
    public void decreaseHealthStatFullLitterBox() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().contains("Organic") && this.litterBox.getWasteLevel() > 100) virtualPet.setHealthStat(virtualPet.getHealthStat() - 30);
        }
    }

    /** This method decreases organic pets health stat if hunger and thirst are too high */
    public void decreaseHealthStatLowHungerThirst() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            if (virtualPet.returnType().contains("Organic Cat")) {
            // Have to split these into organic cat and dog because organic pet is abstract
            OrganicCat organicCat = new OrganicCat(virtualPet);
                if (organicCat.hungerLevel > 75) organicCat.setHealthStat(organicCat.getHealthStat() - 15);
                else if (organicCat.hungerLevel > 50) organicCat.setHealthStat(organicCat.getHealthStat() - 10);
                if (organicCat.thirstLevel > 75) organicCat.setHealthStat(organicCat.getHealthStat() - 15);
                else if (organicCat.thirstLevel > 50) organicCat.setHealthStat(organicCat.getHealthStat() - 10);
            } else if (virtualPet.returnType().contains("Organic Dog")) {
                OrganicDog organicDog = new OrganicDog(virtualPet);
                if (organicDog.hungerLevel > 75) organicDog.setHealthStat(organicDog.getHealthStat() - 15);
                else if (organicDog.hungerLevel > 50) organicDog.setHealthStat(organicDog.getHealthStat() - 10);
                if (organicDog.thirstLevel > 75) organicDog.setHealthStat(organicDog.getHealthStat() - 15);
                else if (organicDog.thirstLevel > 50) organicDog.setHealthStat(organicDog.getHealthStat() - 10);
            }
        }
    }

    /** This method decreases the health of robotic pets if their oil level is too low. */
    public void decreaseHealthStatLowOilLevel() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            String virtualPetType = virtualPet.returnType();
            // Have to split these into robotic cat and dog because robotic pet is abstract
            if (virtualPetType.equals("Robotic Cat")) {
                RoboticCat roboticCat = new RoboticCat(virtualPet);
                if (roboticCat.getOilLevel() > 75) roboticCat.setHealthStat(roboticCat.getHealthStat() - 30);
                else if (roboticCat.getOilLevel() > 50) roboticCat.setHealthStat(roboticCat.getHealthStat() - 15);
            }
            if (virtualPetType.equals("Robotic Dog")) {
                RoboticDog roboticDog = new RoboticDog(virtualPet);
                if (roboticDog.getOilLevel() > 75) roboticDog.setHealthStat(roboticDog.getHealthStat() - 30);
                else if (roboticDog.getOilLevel() > 50) roboticDog.setHealthStat(roboticDog.getHealthStat() - 15);
            }
        }
    }

    /** This method oils all robotic pets. */
    public void oilAllRoboticPets() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            String virtualPetType = virtualPet.returnType();
            if (virtualPetType.equals("Robotic Cat")) {
                RoboticCat roboticCat = new RoboticCat(virtualPet);  
                roboticCat.oilPet();
            }
            if (virtualPetType.equals("Robotic Dog")) {
                RoboticDog roboticDog = new RoboticDog(virtualPet);  
                roboticDog.oilPet();
            }
        }
    }

    /** This method lets all robotic cats check for threats. If they are detecting threats, they sound an alarm which will annoy the other pets. */
    public void checkForThreats() {
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            String virtualPetType = virtualPet.returnType();
            if (virtualPetType.equals("Robotic Cat")) {
                RoboticCat roboticCat = new RoboticCat(virtualPet);  
                if (roboticCat.isDetectingThreats()) {
                    ArrayList<VirtualPet> petsInShelter = this.virtualPetsInShelter;
                    petsInShelter.remove(roboticCat);
                    for (VirtualPet virtualPetAgain : petsInShelter) {
                        virtualPetAgain.setHappinessLevel(virtualPetAgain.getHappinessLevel() - 10);
                    }
                }
            }
        }
    }
}
