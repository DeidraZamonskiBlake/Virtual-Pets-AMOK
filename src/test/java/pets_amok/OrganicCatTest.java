package pets_amok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrganicCatTest {

    private static OrganicCat organicCat;

    @BeforeEach
    public void setup() {
        organicCat = new OrganicCat("Organic Cat", "Organic Cat description");
    }

    @Test
    public void testSetAndGetIsFeelingRestless() {
        organicCat.setFeelingRestless(false);
        assertFalse(organicCat.isFeelingRestless(), "The isFeelingRestless instance variable was not set correctly.");
    }

    @Test 
    public void testHissLowersHappiness() {
        organicCat.hiss();
        assertEquals(90, organicCat.happinessLevel);
    }

    @Test
    public void testPurrRaisesHappiness() {
        organicCat.purr();
        assertEquals(100, organicCat.happinessLevel);
    }
}
