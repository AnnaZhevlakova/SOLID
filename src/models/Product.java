package models;

public class Product extends BaseModel {
    private String name;
    private double prise;
    private ProductType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n" +
                "Номер " + getId() +
                ", Наименование '" + name + '\'' +
                ", Цена " + prise +
                ", Тип товара " + type;
    }
}

