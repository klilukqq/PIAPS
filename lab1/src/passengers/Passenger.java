package passengers;

abstract  public class Passenger {

    int amount;

    public boolean payForRide(int price){
        if(amount  < price)
            return false;
        amount -= price;
        return true;
    }

}
