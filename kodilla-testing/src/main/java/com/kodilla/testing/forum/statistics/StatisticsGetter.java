package com.kodilla.testing.forum.statistics;


public class StatisticsGetter {
    int userAmount;
    int postAmount;
    int commentsAmount;
    double postPerUserAvrg;
    double commentsPerUserAvrg;
    double commentsPerPostAvrg;

    public void calculateAdvStatistics(Statistics statistics){
        userAmount = statistics.usersNames().size();
        postAmount = statistics.postsCount();
        commentsAmount = statistics.commentsCount();
        if(userAmount!=0){
            postPerUserAvrg = (double)postAmount/(double)userAmount;
            commentsPerUserAvrg = (double)commentsAmount/(double)userAmount;
        } else {
            postPerUserAvrg = 0.0;
            commentsPerUserAvrg = 0.0;
        }
        if(postAmount!=0) {
            commentsPerPostAvrg = (double)commentsAmount /(double)postAmount;
        } else {
            commentsPerPostAvrg = 0.0;
        }
        showStatistics();
    }

    public double getPostPerUserAvrg() {
        return postPerUserAvrg;
    }

    public double getCommentsPerUserAvrg() {
        return commentsPerUserAvrg;
    }

    public double getCommentsPerPostAvrg() {
        return commentsPerPostAvrg;
    }

    public void showStatistics(){
        System.out.println("======================\n" + "User amount: " + userAmount + "\n" +
                "Post amount: " + postAmount + "\n" +
                "Comments amount: " + commentsAmount + "\n" +
                "Post per user average: " + postPerUserAvrg + "\n" +
                "Comments per user average: " + commentsPerUserAvrg + "\n" +
                "Comments per post average: " + commentsPerPostAvrg);
    }

}
