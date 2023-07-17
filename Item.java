package Exam;

public class Item {
    private long id;
    private String name;
    private int price;

    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Item(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
