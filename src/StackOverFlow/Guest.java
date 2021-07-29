package StackOverFlow;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Guest extends User{

    @Override
    public Integer postQuestion(String title, String content) throws IllegalAccessException {
        throw new IllegalAccessException("Guests are not allowed");
    }

    @Override
    public Integer postAnswer(Integer questionId, String content) throws IllegalAccessException {
        // check if closed throw exception
        // this posts a given answer by the current user to the given question
        // update score
        throw new IllegalAccessException("Guests are not allowed");
    }

    @Override
    public Integer postComment(Integer postingId, String content) throws IllegalAccessException {
        throw new IllegalAccessException("Guests are not allowed");
    }

    @Override
    public void closeQuestion(Integer questionId) throws IllegalAccessException {
        throw new IllegalAccessException("Guests are not allowed");
    }

    @Override
    public void upVote(Integer postingId) throws IllegalAccessException {
        throw new IllegalAccessException("Guests are not allowed");
    }

    @Override
    public void downVote(Integer postingId) throws IllegalAccessException {
        throw new IllegalAccessException("Guests are not allowed");
    }
}
