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
        this.hungerLevel -= 80;
        if (this.hungerLevel < 0) this.hungerLevel = 0;

        this.bathroomStat += 7;
        if (this.bathroomStat > 100) this.bathroomStat = 100;

        this.healthStat += 35;
        if (this.healthStat > 100) this.healthStat = 100;
    }

    /**
     * This method lowers the thirstLevel life stat of the virtual pet to represent the user giving water the pet
     */
    public void giveWaterToPet() {
        this.thirstLevel -= 80;
        if (this.thirstLevel < 0) this.thirstLevel = 0;

        this.bathroomStat += 4;
        if (this.bathroomStat > 100) this.bathroomStat = 100;

        this.healthStat += 35;
        if (this.healthStat > 100) this.healthStat = 100;
    }

    /**
     * This method lowers the hungerLevel life stat of the virtual pet less than feedPet
     */
    public void feedSelf() {
        this.hungerLevel -= 10;
        if (this.hungerLevel < 0) this.hungerLevel = 0;

        this.bathroomStat += 3;
        if (this.bathroomStat > 100) this.bathroomStat = 100;

        this.healthStat += 15;
        if (this.healthStat > 100) this.healthStat = 100;
    }

    /**
     * This method lowers the thirstLevel life stat of the virtual pet less than feedPet
     */
    public void getSelfWater() {
        this.thirstLevel -= 7;
        if (this.thirstLevel <= 0) this.thirstLevel = 0;

        this.bathroomStat += 2;
        if (this.bathroomStat > 100) this.bathroomStat = 100;

        this.healthStat += 15;
        if (this.healthStat > 100) this.healthStat = 100;
    }

    /** This method raises base stats of organic pets that can be directly manipulated */
    public void selfCare() {
        feedSelf();
        getSelfWater();
        entertainSelf();
        if (this.bathroomStat > 50 && this.returnType().equals("Organic Dog")) this.bathroomStat -= 10;
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