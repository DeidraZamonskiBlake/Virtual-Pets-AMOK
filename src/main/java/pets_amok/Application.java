package pets_amok;

/**
 * This class represents the main program for our Virtual Pets Amok app. Contains the main method for user interaction.
 * 
 * @author Deidra Zamonski-Blake
 * @version 1.0
 */
public class Application {
    /**
     * The main method serving as the entry point of the application. It handles the user input and output, and it runs the game loop. It also utilizes the function of our virtual pet shelter class as well as the functions of the individual virtual pets.
     * 
     * @param args Command-line arguments passed down to the application.
     */
    public static void main(String[] args) {

        // First fill shelter with example pets
        // Remember to set their starting stats - different types have different starting stats

        /*
         * Inside main tick method:
         * increaseOrganicBaseStats
         * increaseEveryone'sBoredom
         * increaseBathroomStat
         * decreaseBatteryLevel
         * decreaseLubricantIntegrityLevel
         * decreaseMaintenanceIntegrityLevel
         * checkForThreats
         * makeCatsRestlessIfUnlucky
         * soilCageIfUnlucky
         * catsUseLitterBoxIfNecessary
         * knockOverLitterBoxIfUnlucky
         * decreaseHealthStatSoiledCage
         * decreaseHealthStatFullLitterBox
         * decreaseHealthStatLowHungerThirst
         * decreaseHealthStatLowOilLevel
         * socializeAllPets
         * roboticSelfCare
         * organicSelfCare
         * checkForDeadPets
         * removeDeadPets
         */

        /*
         * Add displays for the following items
         * Base Stats for Organic Pets
         * Base Stats for Robotic Pets
         * Dirty Cages
         * Litter Box Cleanliness & Upright Status
         * Short Circuited Cats
          */

          // Need a notification system. Notify when:
        /*
         * When a dog soils a cage
         * When a cat uses the litter box
         * When a cat short circuits
         * When the litter box is knocked over
         * When a robot needs maintenance
         * When a robot needs oil
         */

        // How will we handle checking if the dog has been walked this tick and last tick?
        // boolean walkedDogLastTick = false at the beginning outside of loop
        // boolean walkedDogThisTick = false at the beginning inside of loop
        /*
         * If user presses the walk dog key {
         *      walkedDogThisTick = hasWalkedDog
         *      boolean walkedDogLastTick = true
         *  }
         * 
         * make walkedDogThisTick false before loop ends
         *  
         */

        /*
         * Add cleanliness stat to the shelter that goes up if the litter box is tipped over; 
         * Increases by the waste level the litter box was at
         * It also increases when dog's cages reach their cleanliness limit
         * It's increased by the soil overflow amount
         * Has a higher waste limit than litter boxes and cages
         * Add the ability to clean the shelter
         * If the shelter reaches the cleanliness limit, all pets are removed by the humane society

         */
    }
}