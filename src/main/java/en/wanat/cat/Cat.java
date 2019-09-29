package en.wanat.cat;

//to jest przyklad modelu, czasmi sie dopuczacza metody ktore beda obliczac ale tylko te ktore dotycza pol w modelu

public class Cat {
    private String name;
    private String breed;
    private String color;


    public Cat(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
