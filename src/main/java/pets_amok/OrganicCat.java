package pets_amok;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * This class holds the functions for the organic cat object.
 */
public class OrganicCat extends OrganicPet implements Cat{

    /** This instance variable represents whether or not the cat is feeling restless. */
    private boolean isFeelingRestless = false;

    /**
     * This method returns a string containing the type of the calling object.
     * @return string containing the type of the calling object
     */
    public String returnType() {
        return "Organic Cat";
    }

    /**
     * This is a constructor for the Organic Cat object that takes in a pet name and description.
     * @param petName
     * @param petDescription
     */
    public OrganicCat(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
    }

    /** 
     * This method has a 33% chance to knock over the shelter litter box if the cat is feeling restless.
     * @param litterBox the shelter litter box
     */
    public void knockOverLitterBoxIfUnlucky(LitterBox litterBox) {
        if (this.isFeelingRestless) {
            double randomNumber = Math.random() * 11 + 1;
            if (randomNumber > 9) {
                litterBox.setUpright(false);
            }
        }
    }

    /** 
     * This method has a 10% chance to make the cat feel restless.
     */
    public void makeRestlessIfUnlucky() {
        Random randomizer = new Random();
        double randomNumber = randomizer.nextInt(1, 101);
        if (randomNumber < 6) {
            this.isFeelingRestless = true;
        }
    }

    /** 
     * This method has organic cats use the litter box if it us upright and if their bathroom stat is high enough. If the litter box isn't upright, the cat can't use it and it's happiness decreases.
     */
    public void useLitterBoxIfNecessary(LitterBox litterBox) {
        if (this.bathroomStat > 75 && litterBox.isUpright()) {
            this.bathroomStat = 0;
            this.happinessLevel += 25;
            litterBox.setWasteLevel(litterBox.getWasteLevel() + 10);
        } else if (this.bathroomStat > 75 && !litterBox.isUpright()) this.happinessLevel -= 25;
    }

    /** 
     * This method is implemented from the Cat interface and it raises the happiness level of the organic cat by 10.
     */
    @Override
    public void purr() {
        this.happinessLevel += 10;
    }

    /** 
     * This method is implemented from the Cat interface and it raises the happiness level of the organic cat by 10.
     */
    @Override
    public void hiss() {
        this.happinessLevel -= 10;
    }

    /**
     * This method is implemented from the Cat interface and depending on the happiness level of the cat, the cat will call either the hiss or purr method
     * @return a String containing the name of the action that occurred as a result of the pet
     */
    @Override
    public String petCat() {
        if (this.happinessLevel >= 50) {
            this.purr();
            return "purr";
        } else {
            this.hiss();
            return "hiss";
        }
    }

    /** 
     * This method returns the isFeelingRestless instance variable back to false;
     */
    public void sootheCat() {
        this.isFeelingRestless = false;
    }
}
