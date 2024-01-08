package Algorithms;


/**
 * Класс продавцов написанный специально для поиска в ширину.<br>
 * @see BreadthFirstSearch
 * */
public class Trader {

    /**
     * String product_name – название продукта которым торгует продавец
     * */
    String product_name;
    /**
     * String name – имя продавца
     * */
    String name;

    public Trader(String name, String product_name){
        this.name = name;
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "product_name='" + product_name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
