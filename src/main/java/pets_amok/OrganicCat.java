package pets_amok;

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

    /** This is a blank constructor that creates an organic cat object from a virtual pet object. */
    public OrganicCat(VirtualPet virtualPet){
    }

    /** This method returns a string containing the type of the calling object. */
    public String returnType() {
        return "Organic Cat";
    }

    /** This method has a 33% chance to knock over the shelter litter box if the cat is feeling restless */
    public void knockOverLitterBoxIfUnlucky(LitterBox litterBox) {
        if (this.isFeelingRestless) {
            double randomNumber = Math.random() * 11 + 1;
            if (randomNumber > 9) {
                litterBox.setUpright(false);
            }
        }
    }

    /** This method has a 10% chance to make the cat feel restless */
    public void makeRestlessIfUnlucky() {
        double randomNumber = Math.random() * 11 + 1;
        if (randomNumber > 8) {
            this.isFeelingRestless = true;
        }
    }

    /** This method is implemented from the Cat interface and it raises the happiness level of the organic cat by 10. */
    @Override
    public void purr() {
        this.happinessLevel += 10;
    }

    /** This method is implemented from the Cat interface and it raises the happiness level of the organic cat by 10. */
    @Override
    public void hiss() {
        this.happinessLevel -= 10;
    }

    /** This method is implemented from the Cat interface and depending on the happiness level of the cat, the cat will call either the hiss or purr method. */
    @Override
    public void petCat() {
        if (this.happinessLevel >= 50) {
            this.purr();
        } else {
            this.hiss();
        }
    }
}
