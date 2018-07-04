package com.example.levon.lebona;

public class Counters {
    int likeCounter = 0;
    int commentCounter = 0;
    boolean isLiked = false;

    public void plusLike() {
        ++likeCounter;
    }

    public void plusComment() {
        ++commentCounter;
    }

    public void minusLike(){
        --likeCounter;
    }

}
