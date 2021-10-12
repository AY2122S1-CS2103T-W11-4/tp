package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedBuyer.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalBuyers.B_BENSON;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.field.Price;

public class JsonAdaptedBuyerTest {

    private static final String INVALID_MAX_PRICE = "42"; // fewer than 3 characters

    private static final String VALID_NAME = B_BENSON.getName().toString();
    private static final String VALID_PHONE = B_BENSON.getPhone().toString();
    private static final String VALID_EMAIL = B_BENSON.getEmail().toString();
    private static final String VALID_MAX_PRICE = B_BENSON.getMaxPrice().toString();

    @Test
    public void toModelType_validBuyerDetails_returnsBuyer() throws Exception {
        JsonAdaptedBuyer buyer = new JsonAdaptedBuyer(B_BENSON);
        assertEquals(B_BENSON, buyer.toModelType());
    }

    @Test
    public void toModelType_invalidPrice_throwsIllegalValueException() {
        JsonAdaptedBuyer buyer = new JsonAdaptedBuyer(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_MAX_PRICE);
        String expectedMessage = Price.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, buyer::toModelType);
    }

    @Test
    public void toModelType_nullPrice_throwsIllegalValueException() {
        JsonAdaptedBuyer buyer = new JsonAdaptedBuyer(VALID_NAME, VALID_PHONE, VALID_EMAIL, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Price.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, buyer::toModelType);
    }

    @Disabled
    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        // TODO: Tags not implemented yet
    }
}