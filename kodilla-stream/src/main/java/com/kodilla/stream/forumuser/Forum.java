package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    List<ForumUser> userList = new ArrayList<>();

    public Forum(){
        userList.add(new ForumUser(1, "Adam Adamski", 'M', LocalDate.of(1982, 1,1), 0));
        userList.add(new ForumUser(2, "Beata Beatowska", 'F', LocalDate.of(1994, 2,2), 422));
        userList.add(new ForumUser(3, "Czeslaw Czeslawski", 'M', LocalDate.of(2007, 3,3), 222));
        userList.add(new ForumUser(4, "Dawid Dawidowski", 'M', LocalDate.of(2010, 4,4), 252));
        userList.add(new ForumUser(5, "Ewelina Ewelinski", 'F', LocalDate.of(1997, 5,5), 52));
        userList.add(new ForumUser(6, "Feliks Feliksowski", 'M', LocalDate.of(1989, 6,6), 13));
    }

    public List<ForumUser> getUserList(){
        return userList;
    }
}
