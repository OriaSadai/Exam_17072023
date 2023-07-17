package Exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item playStation = new Item(1,"PlayStation",1000);
        Item xBox = new Item(2,"xBox",1000);
        Item gearsOfWar = new Item(10,"Gears of War",100);
        Item callOfDuty = new Item(11,"Call of Duty",110);
        Item fifa = new Item(12,"Fifa",95);
        Item joyStick = new Item(5,"JoyStick",200);
        Item gamingHeadphones = new Item(7,"Gaming Headphones",180);
        ArrayList<Item> benFavoriteItems = new ArrayList<>();
        benFavoriteItems.add(joyStick);
        benFavoriteItems.add(gearsOfWar);
        benFavoriteItems.add(0,playStation);
        Customer ben = new Customer(Type.VIP,11111l,"Ben","Meir","ben@meir.com","Hamada 1, Raanana",20,benFavoriteItems);
        ben.removeItemFromFavoriteList(fifa);
        ben.removeItemFromFavoriteList(joyStick);
        ben.addItemToFavoriteList(new Item(55,"Phone case",12));
        Customer gal = new Customer(Type.REGULAR,22222l,"Gal","Levy","gal@levi.com","Yehuda Hamacabi 12, Tel-Aviv",0);
        gal.addItemToFavoriteList(callOfDuty);
        gal.addItemToFavoriteList(xBox);
        Order benOrder = new Order(Type.VIP,11111111l,"Ben order",ben,Payment.CASH, LocalDate.now());
        benOrder.addItemToOrderList(new Item(17,"VR glasses",900));
        benOrder.removeItemOrderList(xBox);
        benOrder.removeItemOrderList(gearsOfWar);
        Order galOrder = new Order(Type.VIP,22222222l,"Gal order",gal,Payment.CREDIT_CARD,LocalDate.now());
        galOrder.addItemToOrderList(joyStick);


        CinemaTickets cinemaTickets = new CinemaTickets();
        ben.takeGift(cinemaTickets);
        ben.takeGift(new OnePlusOnePapagayo());

        gal.takeGift(new CarWashTicket());
        System.out.println(gal.getGift());
        gal.removeGift();
        System.out.println(gal.getGift());

    }
}
