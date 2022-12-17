package com.kodilla.testing.forum.statistics;

import org.mockito.Mock;
import org.junit.jupiter.api.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@DisplayName("Forum Statistics Test Suite")
public class StatisticsTestSuite {

    private List<String> generateUsersNamesList(int usersQt){
        List<String> resultList = new LinkedList<>();
        for (int i = 0; i<usersQt; i++) {
            byte[] array = new byte[10];
            new Random().nextBytes(array);
            String generatedString = new String(array);
            resultList.add(generatedString);
        }
        return resultList;
    }

    @Mock
    Statistics statisticsMock = mock(Statistics.class);
    StatisticsGetter getter;

    @Test
    void test0Posts(){
        //Given
            List<String> users = generateUsersNamesList(1);
            when(statisticsMock.usersNames()).thenReturn(users);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(1);
            getter = new StatisticsGetter();

        //When
            getter.calculateAdvStatistics(statisticsMock);
            double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
            double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
            double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
            Assertions.assertEquals(0, commentsPerPostAvrg);
            Assertions.assertEquals(1, commentsPerUserAvrg);
            Assertions.assertEquals(0, postPerUserAvrg);
    }

    @Test
    void test1000Posts(){
        //Given
        List<String> users = generateUsersNamesList(1);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(0.001, commentsPerPostAvrg);
        Assertions.assertEquals(1, commentsPerUserAvrg);
        Assertions.assertEquals(1000, postPerUserAvrg);
    }


    @Test
    void test0Comments(){
        //Given
        List<String> users = generateUsersNamesList(1);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1);
        when(statisticsMock.commentsCount()).thenReturn(0);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(0, commentsPerPostAvrg);
        Assertions.assertEquals(0, commentsPerUserAvrg);
        Assertions.assertEquals(1, postPerUserAvrg);
    }


    @Test
    void testCommentsLessPosts(){
        //Given
        List<String> users = generateUsersNamesList(1);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(10);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(0.1, commentsPerPostAvrg);
        Assertions.assertEquals(10, commentsPerUserAvrg);
        Assertions.assertEquals(100, postPerUserAvrg);
    }

    @Test
    void testPostsLessComments(){
        //Given
        List<String> users = generateUsersNamesList(1);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(100);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(10, commentsPerPostAvrg);
        Assertions.assertEquals(100, commentsPerUserAvrg);
        Assertions.assertEquals(10, postPerUserAvrg);
    }

    @Test
    void test0Users(){
        //Given
        List<String> users = new LinkedList<>();
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(1, commentsPerPostAvrg);
        Assertions.assertEquals(0, commentsPerUserAvrg);
        Assertions.assertEquals(0, postPerUserAvrg);
    }

    @Test
    void test1000Users(){
        //Given
        List<String> users = generateUsersNamesList(1000);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        getter = new StatisticsGetter();

        //When
        getter.calculateAdvStatistics(statisticsMock);
        double commentsPerPostAvrg = getter.getCommentsPerPostAvrg();
        double commentsPerUserAvrg = getter.getCommentsPerUserAvrg();
        double postPerUserAvrg = getter.getPostPerUserAvrg();

        //Then
        Assertions.assertEquals(1, commentsPerPostAvrg);
        Assertions.assertEquals(0.01, commentsPerUserAvrg);
        Assertions.assertEquals(0.01, postPerUserAvrg);
    }
}
