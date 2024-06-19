package pets_amok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * This class holds the functions for the robotic pet object.
 */
public abstract class RoboticPet extends VirtualPet {

    /** This instance variable represents the robotic pets' need for oil. The lower it is, the higher the need for oil. */
    protected int oilLevel = 100;

    /** This instance variable represents the robots' need for regular maintenance. The lower it is, the higher the need for maintenance. */
    protected int maintenanceIntegrityLevel = 100;

    /** This instance variable represents the battery level of the robotic pets */
    protected int batteryLevel = 100;

    /** This instance variable represents whether or not the robotic pet is currently malfunctioning */
    protected boolean isMalfunctioning = false;

    /** This method allows us to oil individual robotic pets */
    public void oilPet() {
        this.oilLevel += 30;
    }

    /** This method resets the maintenance integrity level back to 100 */
    public void performMaintenance() {
        this.maintenanceIntegrityLevel = 100;
    }

    public void malfunctionIfBatteryLow() {
        if (this.batteryLevel <= 15) this.isMalfunctioning = true;
    }

}
