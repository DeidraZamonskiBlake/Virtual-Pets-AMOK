package pets_amok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * This class holds the functions for the robotic dog object.
 */
public class RoboticDog extends RoboticPet implements Dog {

    /** The cage object instance variable of each virtual dog */
    private Cage cage;

    /** This is a blank constructor and it generates a cage upon creation */
    public RoboticDog() {
        this.cage = new Cage();
    }

    /** This is the full arguments (except for the cage) constructor for a robotic dog and it generates a cage upon creation */
    public RoboticDog(int lubricantIntegrityLevel, int maintenanceIntegrityLevel, int batteryLevel, boolean isMalfunctioning) {
        super(lubricantIntegrityLevel, maintenanceIntegrityLevel, batteryLevel, isMalfunctioning);
        this.cage = new Cage();
    }

    /** This constructor creates a robotic dog from a virtual pet and generates a cage upon creation */
    public RoboticDog(VirtualPet virtualPet) {
        this.cage = new Cage();
    }

    /** This method returns a string containing the type of the calling object */
    public String returnType() {
        return "Robotic Dog";
    }

    /** This method is implemented from the Dog interface and it raises the happiness of the robotic dog to signify that the dog has been walked */
    @Override
    public boolean walkDog() {
        this.happinessLevel += 35;
        return true;
    }
}
