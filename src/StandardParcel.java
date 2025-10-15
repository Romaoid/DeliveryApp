public class StandardParcel extends Parcel {
    public static final ParcelType parcelType = ParcelType.STANDARD;


    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, parcelType);
    }
}
