package entity;

public class Hotel {


    private String name;
    private int numberOfStars;

    public Hotel(String name, int numberOfStars) {
        this.name = name;
        this.numberOfStars = numberOfStars;
    }

    @Override
    public String toString() {
        return "Название отеля " + name +
                ", количество звезд " + numberOfStars;
    }
}
