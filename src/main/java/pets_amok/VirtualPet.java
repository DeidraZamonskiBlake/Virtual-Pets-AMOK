package pets_amok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The virtual pet shelter class holds the functions for the virtual pet object.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class VirtualPet {

    /** Name of virtual pet */
    protected String petName;
    /** Description of virtual pet */
    protected String petDescription;
    /** Boredom status level of virtual pet */
    protected int boredomLevel;
    /** Happiness status level of virtual pet */
    protected int happinessLevel = 100;
    /** The health status of the virtual pet. */
    protected int healthStat = 100;

    /**
     * Constructor for the virtual pet object that takes in a pet name and description upon creation.
     * 
     * @param petName name of virtual pet
     * @param petDescription description of virtual pet
     */
    public VirtualPet(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
    }

    /**
     * This method lowers the boredomLevel life stat of the virtual pet less than entertainPet to represent the pet entertaining itself
     */
    public void entertainSelf() {
        this.boredomLevel -= 5;

        if (this.boredomLevel < 0) {
            this.boredomLevel = 0;
        }

        this.healthStat += 15;

        if (this.healthStat > 100) {
            this.healthStat = 100;
        }
    }

    /**
     * This method changes each life stat of the virtual pet slightly to represent socialization between pets 
     */
    public void socialize() {

        // Multiply Math.random by the length of the range you want the random number to fall within and adding 1 if inclusive, then add your minimum to place your range's distance from 0 
        int randomNumber = (int)(Math.random() * (7)) - 3;

        this.boredomLevel += randomNumber;

        if (this.boredomLevel < 0) {
            this.boredomLevel = 0;
        }
    }

    public abstract String returnType();
}
