package pl.mitelski.a238006.betterfilmwebapp;

public class Actor {
    private String name;
    private String surname;
    private int age;
    private String avatarUrl;

    public Actor(String name, String surname, int age, String avatarUrl) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
