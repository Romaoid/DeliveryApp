import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Тут у нас все тесты на цены посылок
class ParcelTest {

    static PerishableParcel perishableParcel = new PerishableParcel("testParcel", 1, "test address", 10, 20);
    static FragileParcel fragileParcel = new FragileParcel("testParcel", 1, "test address", 10);
    static StandardParcel standardParcel = new StandardParcel("testParcel", 1, "test address", 10);

    @Test
    void calculateDeliveryCostForStandardParcel() {
        Assertions.assertEquals(2, standardParcel.calculateDeliveryCost(),
                "Ошибка расчета для стандартной посылки");
    }

    @Test
    void calculateDeliveryCostForFragileParcel() {
        Assertions.assertEquals(3, fragileParcel.calculateDeliveryCost(),
                "Ошибка расчета для хрупкой посылки");
    }

    @Test
    void calculateDeliveryCostForPerishableParcel(){
        Assertions.assertEquals(4, perishableParcel.calculateDeliveryCost(),
                "Ошибка расчета для скоропортящейся посылки");
    }
}