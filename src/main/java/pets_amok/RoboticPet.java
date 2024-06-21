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
    protected int maintenanceNeedLevel;

    /** This instance variable represents the battery level of the robotic pets */
    protected int batteryLevel = 100;

    /** This instance variable represents whether or not the robotic pet is currently malfunctioning */
    protected boolean isMalfunctioning = false;

    /** This method resets the oil level of robotic pets back to 100 */
    public void oilPet() {
        this.oilLevel = 100;
    }

    /** This method resets the maintenance needed level of robotic pets back to 0 */
    public void performMaintenance() {
        this.maintenanceNeedLevel = 0;
    }

    /** This method returns the robotic pet's battery level back to 100. */
    public void rechargeBattery() {
        this.batteryLevel = 100;
    }

    /** This method makes the robotic pet malfunction if the battery drops too low */
    public void malfunctionIfBatteryLow() {
        if (this.batteryLevel < 10) this.isMalfunctioning = true;
    }

    /** This method changes the isMalfunctioning instance variable back to false. */
    public void repairMalfunction() {
        this.isMalfunctioning = false;
    }

}
