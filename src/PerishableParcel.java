//скоропортящееся
public class PerishableParcel extends Parcel {
    public static final ParcelType parcelType = ParcelType.PERISHABLE;
    public final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, parcelType);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return (currentDay > (sendDay + timeToLive));
    }
}
