import board.BoardBus;
import board.BoardTaxi;
import drivers.BusDriver;
import drivers.TaxiDriver;
import passengers.BusPassenger;
import passengers.TaxiPassenger;
import passengers.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
//https://app.diagrams.net/#G1sjGE34JpV62rMC4QItY9iTGqqHKnNcAd
    public static void main(String[] args) {
        Random random = new Random();
        List<BusPassenger> busPassengers = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if(random.nextInt(10)%5 == 0) busPassengers.add(new BusPassenger(category.FREE));
            else if(random.nextInt(10)%2 == 0) busPassengers.add(new BusPassenger(category.PRIVILEGED));
            else busPassengers.add(new BusPassenger(category.STANDARD));
        }

        List<TaxiPassenger> taxiPassengers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            taxiPassengers.add(new TaxiPassenger());
        }

        BusDriver  busDriver = new BusDriver();
        TaxiDriver taxiDriver = new TaxiDriver();

        BoardBus bus1 = new BoardBus();
        bus1.boardPassengers(busPassengers);
        bus1.boardDriver(taxiDriver);
        bus1.boardDriver(busDriver);
        boolean isBusGood = bus1.startTheRide();

        BoardTaxi taxi1 = new BoardTaxi();
        taxi1.boardDriver(taxiDriver);
        taxi1.boardPassengers(taxiPassengers);
        boolean isTaxiGood = taxi1.startTheRide();

        System.out.println("Автобус: " + isBusGood);
        System.out.println("Такси: " + isTaxiGood);
    }
}
