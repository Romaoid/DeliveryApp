public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected ParcelType parcelType;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay, ParcelType parcelType) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.parcelType = parcelType;
    }

    public void packageItem() {
    System.out.println("Посылка " + description + " упакована.");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public Integer calculateDeliveryCost() {
        return switch (parcelType) {
            case FRAGILE -> weight * 3;
            case PERISHABLE -> weight * 4;
            case STANDARD -> weight * 2;
            default -> null;
        };
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }
}
