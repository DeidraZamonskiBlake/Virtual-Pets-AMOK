package pets_amok;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * This class holds the functions for the organic cat object.
 */
public class RoboticCat extends RoboticPet implements Cat {

    /*
     * When the cat is malfunctioning, it's threat detection accuracy is lowered by a random percentage between 50% and 75% 
     * detectThreatsMethod:
     * Every tick, a random number (between 1 and 5) of potential threats is detected
     * When functioning normally, only 2% of those potential threats register as actual threats
     * When malfunctioning, the 2% is increased by the inaccuracy amount
     * When a threat is detected, the cat will sound an alarm and the other animals will be annoyed by the sound
     * The alarm will have to be turned off, the cat will need repaired and charged
     * If the cat is repaired but not charged, user can only interact with the cat by charging it
     */

    private int threatDetectionPercentage;

    /** A blank constructor for the robotic cat that takes in a virtual pet, */
    public RoboticCat(VirtualPet virtualPet) {
    }

    /** This method returns a string containing the type of the calling object, */
    public String returnType() {
        return "Robotic Cat";
    }

    public RoboticCat(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
    }

    public boolean isDetectingThreats() {
        boolean isDetectingThreats = false;
        int potentialThreats = (int) Math.random() * 6 + 1;

        if (this.isMalfunctioning) {
            threatDetectionPercentage = (int) (Math.random() * 26 + 50) + 2;
            for (int counter = 0; counter < potentialThreats; counter++) {
                int randomNumber = (int) Math.random() * 101 + 1;
                if (randomNumber <= threatDetectionPercentage) {
                    isDetectingThreats = true;
                } else isDetectingThreats = false;
            }
        } else {
            threatDetectionPercentage = 2;
            for (int counter = 0; counter < potentialThreats; counter++) {
                int randomNumber = (int) Math.random() * 101 + 1;
                if (randomNumber <= threatDetectionPercentage) {
                    isDetectingThreats = true;
                } else isDetectingThreats = false;
            }
        }

        return isDetectingThreats;
    }

    public void terrorizeOtherPets(ArrayList<VirtualPet> virtualPetsInShelter) {
        int levelOfTerror = (int) Math.random() * 4 + 1;
        virtualPetsInShelter.remove(this);
        for (VirtualPet virtualPet : virtualPetsInShelter) {
            virtualPet.setHappinessLevel(virtualPet.getHappinessLevel() - (levelOfTerror * 10));
        }
    }

    /** This method is implemented from the Cat interface and it raises the happiness level of the robotic cat by 5. */
    @Override
    public void purr() {
        this.happinessLevel += 5;
    }

    /** This method is implemented from the Cat interface and it lowers the happiness level of the robotic cat by 10. */
    @Override
    public void hiss() {
        this.happinessLevel -= 15;
    }

    /** This method is implemented from the Cat interface and depending on the happiness level of the cat, the cat will call either the hiss or purr method. */
    @Override
    public void petCat() {
        if (this.happinessLevel >= 70) {
            this.purr();
        } else {
            this.hiss();
        }
    }
}
