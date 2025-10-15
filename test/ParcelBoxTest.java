import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParcelBoxTest {
    static ParcelBox<StandardParcel> parcelBox;
    static StandardParcel parcel;

    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>(10);
        parcel = new StandardParcel("testParcel", 5,
                "testAddress", 1);
    }

    @Test
    public void shouldPositiveAfterAddParcelInBoxWithWeight5() {
        Assertions.assertEquals(0, parcelBox.getWeight(), "Список не пустой");
        parcelBox.addParcel(parcel);
        Assertions.assertEquals(5, parcelBox.getWeight(), "Посылка не добавилась");
    }

    @Test
    public void shouldBePositiveAfterAddParcelInBoxWithWeight10() {
        Assertions.assertEquals(0, parcelBox.getWeight(), "Список не пустой");
        parcelBox.addParcel(parcel);
        parcelBox.addParcel(parcel);
        Assertions.assertEquals(10, parcelBox.getWeight(), "Посылка не добавилась");
    }

    @Test
    public void shouldNotAddParcelInBoxWithWeightOverMaxWeight() {
        Assertions.assertEquals(0, parcelBox.getWeight(), "Список не пустой");
        parcelBox.addParcel(parcel);
        parcelBox.addParcel(parcel);
        StandardParcel parcelW1 = new StandardParcel("testParcel2", 1,
                "testAddress", 1);
        parcelBox.addParcel(parcelW1);
        Assertions.assertEquals(10, parcelBox.getWeight(), "Посылка добавилась");
    }
}