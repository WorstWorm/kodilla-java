package com.kodilla.stream;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
                Forum forum = new Forum();
                Map<Integer, ForumUser> theResultMapOfUsers = forum.getUserList().stream()
                        .filter(user->user.getSex()=='M')
                        .filter(user->user.getBirthdate().getYear() - LocalDate.now().getYear() < -20)
                        .filter(user->user.getPostCount()>0)
                        .collect(Collectors.toMap(ForumUser::getId, user->user));
                theResultMapOfUsers.entrySet().stream()
                        .map(entry->entry.getKey() + ": " + entry.getValue())
                        .forEach(System.out::println);
    }
}
