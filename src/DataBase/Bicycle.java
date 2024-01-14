package DataBase;

public class Bicycle {
    private int id;
    private String make;
    private String type;
    private float price;



    public Bicycle(int id, String make, String type, float price){
        this.id = id;
        this.make = make;
        this.type = type;
        this.price = price;
    }
    public Bicycle(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
