package pl.mitelski.a238006.betterfilmwebapp;

import java.util.Random;

public class FakeDataProvider {
    private Random rand = new Random();
    private static final String[] titles = {"Avengers", "Ojciec chrzestny", "Gladiator", "Pulp fiction", "12 gniewnych ludzi", "My Little Pony: Przyjaźń to Magia", "John Wick"};
    private static final String[] categories = {"animacja", "sci-fi", "komedia", "dramat", "akcja", "komedia romantyczna"};
    private static final String[] images = {
            "https://ia.media-imdb.com/images/M/MV5BMTkxMTA5OTAzMl5BMl5BanBnXkFtZTgwNjA5MDc3NjE@._V1_SY1000_CR0,0,673,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMTk4NTgxMjItZTU5ZS00NGE3LWJlODQtMTMzOTJlZmU5ODk1XkEyXkFqcGdeQXVyNjUzMDIyNzE@._V1_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_SY1000_CR0,0,666,1000_AL_.jpg",
            "https://ia.media-imdb.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
            };
    private static final Actor[] actors = {
            new Actor("Johnny", "Deep", 54, "https://ia.media-imdb.com/images/M/MV5BMTM0ODU5Nzk2OV5BMl5BanBnXkFtZTcwMzI2ODgyNQ@@._V1_SY1000_CR0,0,701,1000_AL_.jpg"),
            new Actor("Dwayne", "Johnson", 45, "https://ia.media-imdb.com/images/M/MV5BMTkyNDQ3NzAxM15BMl5BanBnXkFtZTgwODIwMTQ0NTE@._V1_SY1000_CR0,0,665,1000_AL_.jpg"),
            new Actor("Mark", "Hamill", 66, "https://pbs.twimg.com/profile_images/947789418328350720/YJ0hdsbA_400x400.jpg"),
            new Actor("Scarlett", "Johansson", 33, "https://timesofindia.indiatimes.com/thumb/msid-61932566,width-400,resizemode-4/61932566.jpg"),
            new Actor("Emma", "Watson", 28, "https://i.pinimg.com/originals/c8/64/74/c864741f0731c29ac7dd8bfbc5984054.jpg")
    };

    public String getTitle(){
        return (String) getArrayItem(titles);
    }

    public String getCategory(){
        return (String) getArrayItem(categories);
    }

    public String getImageUrl(){
        return (String) getArrayItem(images);
    }

    public Actor getActor() {
        return (Actor) getArrayItem(actors);
    }

    public Object getArrayItem(Object[] arr){
        return arr[rand.nextInt(arr.length)];
    }

}
