import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static ParcelBox<StandardParcel> standartParcelBox = new ParcelBox<>(20);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(20);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels(standartParcelBox.getAllParcels());
                    sendParcels(fragileParcelBox.getAllParcels());
                    sendParcels(perishableParcelBox.getAllParcels());
                    break;
                case 3:
                    calculateCosts(standartParcelBox.getAllParcels());
                    calculateCosts(fragileParcelBox.getAllParcels());
                    calculateCosts(perishableParcelBox.getAllParcels());
                    break;
                case 4:
                    changeStatus();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Сменить статус доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберете тип посылки:");
        System.out.println("1 - Стандартная");
        System.out.println("2 - хрупкая");
        System.out.println("3 - Скоропортящаяся");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        if (typeChoice > 3 || typeChoice < 1) {
            System.out.println("Неверный выбор.");
            return;
        }

        System.out.println("Укажите название посылки:");
        String descriptionChoice = scanner.nextLine();

        System.out.println("Укажите вес посылки:");
        int weightChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Укажите адрес места назначения:");
        String deliveryAddressChoice = scanner.nextLine();

        System.out.println("Укажите день отправки:");
        int sendDayChoice = scanner.nextInt();
        scanner.nextLine();

        if (typeChoice == 1) {
            StandardParcel parcel = new StandardParcel(descriptionChoice, weightChoice, deliveryAddressChoice,
                    sendDayChoice);
            standartParcelBox.addParcel(parcel);
        } else if (typeChoice == 2) {
            FragileParcel parcel = new FragileParcel(descriptionChoice, weightChoice, deliveryAddressChoice,
                    sendDayChoice);
            fragileParcelBox.addParcel(parcel);
        } else {
            System.out.println("Добавьте срок годности в днях:");
            int liveTimeChoice = scanner.nextInt();
            scanner.nextLine();

            PerishableParcel parcel = new PerishableParcel(descriptionChoice, weightChoice, deliveryAddressChoice,
                    sendDayChoice, liveTimeChoice);
            perishableParcelBox.addParcel(parcel);
        }
    }

    private static <T extends Parcel> void sendParcels(ArrayList<T> parcels) {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : parcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void changeStatus() {
        System.out.println("Укажите посылку для корректировки статуса:");
        String descriptionChoice = scanner.nextLine();

        for (FragileParcel parcel : fragileParcelBox.getAllParcels()) {
            if (descriptionChoice.equals(parcel.getDescription())) {
                System.out.println("Укажите новое местоположение:");
                String newLocation = scanner.nextLine();

                parcel.reportStatus(newLocation);
                return;
            } else {
                System.out.println("Такой посылки нет!");
            }
        }
    }

    private static <T extends Parcel> void calculateCosts(ArrayList<T> parcels) {
        // Посчитать общую стоимость всех доставок и вывести на экран
        for (Parcel parcel : parcels) {
            System.out.println("Посылка " + parcel.getDescription() + " стоит " + parcel.calculateDeliveryCost());
        }
    }

}