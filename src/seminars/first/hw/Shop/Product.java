package seminars.first.hw.Shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(Integer price, String title){
        this.title = title;
        this.cost = price;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}