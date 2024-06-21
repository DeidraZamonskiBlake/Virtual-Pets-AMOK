package pets_amok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 
 * This class holds the functions of the organic dog object.
 */
public class OrganicDog extends OrganicPet implements Dog {

    /** The cage object instance variable of each virtual dog */
    private Cage cage;

    /** This method represents whether or not the dog has been walked this tick. */
    private boolean hasBeenWalkedThisTick;

    /** This method represents whether or not the dog has been walked last tick. */
    private boolean wasWalkedLastTick;


    /** 
     * @param
     */
    public OrganicDog(int hungerLevel, int thirstLevel, int bathroomStat, boolean hasBeenWalkedThisTick, boolean wasWalkedLastTick) {
        super(hungerLevel, thirstLevel, bathroomStat);
        this.cage = new Cage();
        this.hasBeenWalkedThisTick = hasBeenWalkedThisTick;
        this.wasWalkedLastTick = wasWalkedLastTick;
        this.cage = new Cage();
    }

    /** This constructor doesn't take in any arguments and generates a cage upon creation. */
    public OrganicDog() {
        this.cage = new Cage();
    }

    public OrganicDog(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
        this.cage = new Cage();
    }

    /** This method returns a string containing the type of the calling object. */
    public String returnType() {
        return "Organic Dog";
    }

    /** This method is implemented from the Dog interface and it lowers the bathroom stat and raises the happiness of the robotic dog to signify that the dog has been walked. */
    @Override
    public void walkDog() {
        this.happinessLevel += 50;
        if (this.happinessLevel > 100) this.happinessLevel = 100;
        this.bathroomStat -= 80;
        if (this.bathroomStat < 0) this.bathroomStat = 0;
        this.hasBeenWalkedThisTick = true;
    }

    /** 
     * This method takes in a boolean representing whether the dog has been walked. 
     * It then generates a random number and decreases that number if the dog has been walked. 
     * Depending on the level of the bathroom stat and what the random number is, the waste level of the dog's cage will be increased.
     * */
    public void soilCageIfUnlucky() {
        int randomNumber = (int) (Math.random() * 11) + 1;

        if (hasBeenWalkedThisTick || wasWalkedLastTick) {
            randomNumber -= 2;
        }

        if ((this.bathroomStat >= 50 && this.bathroomStat <= 75) && (randomNumber >= 6 && randomNumber <= 9)) {
            this.cage.setWasteLevel(this.cage.getWasteLevel() + 20);
        } else if ((this.bathroomStat >= 76 && this.bathroomStat <= 99) && (randomNumber >= 3 && randomNumber <= 9)) {
            this.cage.setWasteLevel(this.cage.getWasteLevel() + 20);
        } 
    }
}
