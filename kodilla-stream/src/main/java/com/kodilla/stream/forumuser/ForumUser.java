package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    final int id;
    final String username;
    final char sex;
    final LocalDate birthdate;
    final int postCount;

    public ForumUser(int id, String username, char sex, LocalDate birthdate, int postCount) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.postCount = postCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", postsCount=" + postCount +
                '}';
    }
}
