package pets_amok;

import java.util.ArrayList;
import java.util.Random;

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

    /** This instance variable represents whether or not the robotic cat is detecting threats. */
    private boolean isDetectingThreats = false;

    private boolean hasThreatAlarmOn = false;

    /** This method returns a string containing the type of the calling object, */
    public String returnType() {
        return "Robotic Cat";
    }

    /** This is a constructor for the robotic cat object that takes in a pet name and description. */
    public RoboticCat(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
    }

    /** This method determines whether or not the cat is detecting threats, which is greatly influenced by whether or not it is malfunctioning. */
    public boolean determineIfCatIsDetectingThreats() {
        Random randomizer = new Random();
        int potentialThreats = randomizer.nextInt(1, 6);

        if (this.isMalfunctioning) {
            int threatDetectionPercentage = randomizer.nextInt(10, 21);
            for (int counter = 0; counter < potentialThreats; counter++) {
                int randomNumber = randomizer.nextInt(1, 101);
                if (randomNumber <= threatDetectionPercentage) {
                    isDetectingThreats = true;
                } else isDetectingThreats = false;
            }
        } else {
            int threatDetectionPercentage = 2;
            for (int counter = 0; counter < potentialThreats; counter++) {
                int randomNumber = randomizer.nextInt(1, 101);
                if (randomNumber <= threatDetectionPercentage) {
                    isDetectingThreats = true;
                } else isDetectingThreats = false;
            }
        }

        return isDetectingThreats;
    }

    /** This method has the cat sound an alarm that slight annoys the rest of the pets in the shelter; */
    public void soundAlarm(ArrayList<VirtualPet> virtualPetsInShelter) {
        for (VirtualPet virtualPet : virtualPetsInShelter) virtualPet.happinessLevel -= 7;
        this.happinessLevel += 7;
        this.hasThreatAlarmOn = true;
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
    public String petCat() {
        if (this.happinessLevel >= 70) {
            this.purr();
            return "purr";
        } else {
            this.hiss();
            return "hiss";
        }
    }

    /** This method changes the isDetectingThreats and the hasThreatAlarmOn instance variables back to false. */
    public void handleDetectedThreats() {
        this.isDetectingThreats = false;
        this.hasThreatAlarmOn = false;
    }
}
