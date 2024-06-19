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
 * This class holds the functions for the litter box object.
 */
public class LitterBox {

    /** The waste level instance variable if the litter box */
    private int wasteLevel;

    /** This instance variable represents whether or not the litter box is upright */
    private boolean isUpright;

}
