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
 * This class holds the functions for the organic pet object.
 */
public abstract class OrganicPet extends VirtualPet {

    /** Hunger status level of organic pet */
    protected int hungerLevel;

    /** Thirst status level of organic pet */
    protected int thirstLevel;

    /** The status of bathroom needs for the organic pet */
    protected int bathroomStat;

    /**
     * This method increases the bathroom stat
     */
    public void increaseBathroomStat() {
        this.bathroomStat += 13;
    }

    /**
     * This method lowers the hungerLevel life stat of the organic pet to represent the user feeding the pet
     */
    public void feedPet() {
        this.hungerLevel -= 45;

        if (this.hungerLevel < 0) {
            this.hungerLevel = 0;
        }        
    }

    /**
     * This method lowers the thirstLevel life stat of the virtual pet to represent the user giving water the pet
     */
    public void giveWaterToPet() {
        this.thirstLevel -= 45;

        if (this.thirstLevel < 0) {
            this.thirstLevel = 0;
        } 

        this.healthStat += 35;

        if (this.healthStat > 100) {
            this.healthStat = 100;
        }
    }

    /**
     * This method lowers the boredomLevel life stat of the virtual pet to represent the user playing with the pet
     */
    public void playWithPet() {
        this.boredomLevel -= 45;
        if (this.boredomLevel < 0) this.boredomLevel = 0;

        this.healthStat += 30;
        if (this.healthStat > 100) this.healthStat = 100;

        this.happinessLevel += 50;
        if (this.happinessLevel > 100) this.happinessLevel = 100;
    }

    /**
     * This method lowers the hungerLevel life stat of the virtual pet less than feedPet to represent the pet feeding itself
     */
    public void feedSelf() {
        this.hungerLevel -= 10;
        if (this.hungerLevel < 0) this.hungerLevel = 0;

        this.healthStat += 15;
        if (this.healthStat > 100) this.healthStat = 100;

    }

    /**
     * This method increases the health stat of the pet based on its hunger and thirst states
     */
    public void decreaseHealthStat() {
        if (this.hungerLevel >= 90 || this.thirstLevel >= 90 || this.boredomLevel >= 90) {
            this.healthStat -= 25;
        } else if (this.hungerLevel >= 80 || this.thirstLevel >= 80 || this.boredomLevel >= 80) {
            this.healthStat -= 20;
        } else if (this.hungerLevel >= 70 || this.thirstLevel >= 70 || this.boredomLevel >= 70) {
            this.healthStat -= 25;
        } else if (this.hungerLevel >= 60 || this.thirstLevel >= 60 || this.boredomLevel >= 60) {
            this.healthStat -= 10;
        } else if (this.hungerLevel >= 50 || this.thirstLevel >= 50 || this.boredomLevel >= 50) {
            this.healthStat -= 5;
        }
    }
}