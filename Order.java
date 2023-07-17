package Exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private Type orderType;
    long id;
    String name;
    private Customer customer;
    private String deliveryAddress;
    private ArrayList<Item> items;
    private int totalPrice;
    private Payment payment;
    private LocalDate dateOrder;

    public Order(Type orderType, long id, String name,Customer customer, Payment payment, LocalDate dateOrder) {
        System.out.println("An order has created!");
        this.orderType = orderType;
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.deliveryAddress = getDefaultAddress();
        this.items = customer.getFavoriteItems();
        this.totalPrice = calculateTotalPrice();
        this.payment = payment;
        this.dateOrder = dateOrder;
    }

    public Type getOrderType() {
        return orderType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Customer getCustomer() {
        return customer;
    }
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getDefaultAddress(){
        return this.customer.getAddress();
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int calculateTotalPrice(){
        try {
            if(this.customer.getCustomerType() != Type.VIP && this.orderType == Type.VIP) {
                throw new Error("Not recognize VIP section");
            }
        }catch (Error e){
            System.out.println(String.format("An issue has occur. %s has not recognized as a VIP but will continue",this.customer.getFullName()));
            System.out.println(e);
        }
        int sum = 0;
        for (Item item : this.items){
            sum += item.getPrice();
        }
        if(this.orderType == Type.VIP){
            System.out.println("The total price is " + (sum - customer.getDiscount()));
            return sum - customer.getDiscount();
        }else{
            System.out.println("The total price is " + sum);
            return sum;
        }
    }
    public void addItemToOrderList(Item item){
        int counter = 0;
        boolean isExist = false;
        //instead of using this.items.contains() for making it more diverse
        while (!isExist && counter<this.items.size()){
            if(this.items.get(counter).getName() == item.getName()){
                isExist = true;
            }else{
                counter++;
            }
        }
        if (!isExist){
            System.out.println(String.format("%s is not exist in the order list, but don't worry we will add! :-)",item.getName()));
            this.items.add(item);
            calculateTotalPrice();
        }else{
            System.out.println(String.format("%s already exist in the order list",item.getName()));
        }
    }
    public void removeItemOrderList(Item item){
        if(this.items.size() == 0){
            System.out.println("Order list is empty");
            return;
        }
        boolean isExist = this.items.remove(item);
        if (isExist){
            System.out.println(String.format("%s has removed from order list",item.getName()));
            calculateTotalPrice();
        }else{
            System.out.println(String.format("%s is not in the order list. cannot be removed.",item.getName()));
        }
    }
}
