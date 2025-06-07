package models;

public class Basket extends Product {
    private long userId;
    private int count;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return super.getPrise() * count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\n" +
                "Номер товара " + super.getId() +
                ", Наименование '" + super.getName() + '\'' +
                ", Цена " + getTotalPrice() +
                ", кол-во товара " + getCount() +
                ", Тип товара " + super.getType();
    }
}
