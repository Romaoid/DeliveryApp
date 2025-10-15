import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {
    static PerishableParcel perishableParcel;

    @BeforeEach
    void beforeEach() {
        perishableParcel = new PerishableParcel("testParcel", 1, "test address", 10, 20);
    }
// 3 теста на isExpired

    @Test
    void shouldNotBeExpiredWhenCurrentDayMore() {
        Assertions.assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    void shouldNotBeExpiredWhenCurrentDayEquals() {
        Assertions.assertFalse(perishableParcel.isExpired(30));
    }

    @Test
    void shouldBeExpiredWhenCurrentDayLess() {
        Assertions.assertTrue(perishableParcel.isExpired(31));
    }

}