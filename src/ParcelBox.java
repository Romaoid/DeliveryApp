import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int weight;
    private ArrayList<T> parcelsBox;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        parcelsBox = new ArrayList<>();
        this.weight = 0;
    }

    public void addParcel(T parcel) {
        if (parcel.getWeight() <= (maxWeight - weight)) {
            parcelsBox.add(parcel);
            weight += parcel.getWeight();
        } else {
            System.out.println("В коробке нет места для посылки " + parcel.getDescription());
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcelsBox;
    }

    public int getWeight() {
        return weight;
    }
}
