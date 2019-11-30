package edu.cis.Y12Demo;

public class Y12User {

    public String birthday;
    public String favoriteFood;
    public Y12User bestFriend;

    public Y12User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Y12User(String birthday, String favoriteArtist) {
        this.birthday = birthday;
        this.favoriteFood = favoriteArtist;
    }

    public void setFavoriteArtist(String favoriteArtist) {
        this.favoriteFood = favoriteArtist;
    }

    public void setBestFriend(Y12User bestFriend) {
        this.bestFriend = bestFriend;
    }
}
