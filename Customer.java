package Exam;

import java.util.ArrayList;

public class Customer {
    private Type customerType;
    private long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String eMail;
    private String address;
    private int discount;
    ArrayList<Item> favoriteItems;
    private Giftable gift;

    public Customer(Type customerType, long id, String firstName, String lastName, String eMail, String address, int discount, ArrayList<Item> favoriteItems) {
        this.customerType = customerType;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.eMail = eMail;
        this.address = address;
        this.discount = discount;
        this.favoriteItems = favoriteItems;
    }
    public Customer(Type customerType, long id, String firstName, String lastName, String eMail, String address, int discount) {
        this.customerType = customerType;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.eMail = eMail;
        this.address = address;
        this.discount = discount;
        this.favoriteItems = setEmptyFavoriteList();
    }

    public Type getCustomerType() {
        return customerType;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
    public String geteMail() {
        return eMail;
    }

    public String getAddress() {
        return this.address;
    }

    public int getDiscount() {
        return discount;
    }

    public ArrayList<Item> getFavoriteItems() {
        return this.favoriteItems;
    }
    public Item getItemFromTheList(int index){
        return this.favoriteItems.get(index);
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public ArrayList<Item> setEmptyFavoriteList(){
        ArrayList<Item> emptyFavoriteItemList = new ArrayList<>();
        emptyFavoriteItemList.add(new Item());
        return emptyFavoriteItemList;
    }
    public void addItemToFavoriteList(Item item){
        int counter = 0;
        boolean isExist = this.favoriteItems.contains(item);
        if (!isExist){
            System.out.println(String.format("%s is not exist in the favorite list, so we ill add! :-)",item.getName()));
            this.favoriteItems.add(item);
        }else{
            System.out.println(String.format("%s already exist in the favorite list",item.getName()));
        }
    }
    public void removeItemFromFavoriteList(Item item){
        if(this.favoriteItems.size() == 0){
            System.out.println("Favorite list is empty");
            return;
        }
        boolean isExist = this.favoriteItems.remove(item);
        if (isExist){
            System.out.println(String.format("%s has removed from favorite list",item.getName()));
        }else{
            System.out.println(String.format("%s is not in the favorite list. cannot be removed.",item.getName()));
        }
    }

    public Giftable getGift() {
        return gift;
    }

    public void takeGift(Giftable gift){
        if (this.gift == null){
            this.gift = gift;
            System.out.println(String.format("“Congratulations %s!",this.getFullName()));
            gift.openGift();
        }
    }
    public void removeGift(){
        if (this.gift != null){
            this.gift = null;
        }
    }


}
