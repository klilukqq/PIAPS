import builders.BusBuilder;
import builders.TaxiBuilder;


public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        TaxiBuilder taxi = new TaxiBuilder();
        BusBuilder bus = new BusBuilder();

        System.out.println("Запуск такси с 6-ю пассажирами");
        director.createTaxiTripWithSixPassengers(taxi);
        System.out.println();
        System.out.println("Другой тип прав");
        director.createBusTripWithDifferentDriver(bus);
        System.out.println();
        System.out.println("Заполненный автобус");
        director.createFullBusTrip(bus);
        System.out.println();
        System.out.println("Два водителя");
        director.createFullBusWithTwoDrivers(bus);
        System.out.println();
        System.out.println("Нет пассажиров");
        director.createBusTripNoPassengers(bus);
    }

}
