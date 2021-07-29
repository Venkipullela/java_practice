package StackOverFlow;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    String userName;
    String passWord;
    Integer score = 0;
    List<Integer> postedQuestionsList = new ArrayList<>();
    List<Integer> postedAnswersList = new ArrayList<>();

    public Integer postQuestion(String title, String content) throws IllegalAccessException {
        Question question = new Question();
        question.content = content;
        question.title = title;
        question.postedBy = this.userName;
        question.downVotes = 0;
        question.upVotes = 0;
        question.answerList = new ArrayList<>();
        question.commentList = new ArrayList<>();
        question.postedAt = ZonedDateTime.now();

        System system = System.getInstance();
        Integer postingId = system.addPosting(question);

        this.score += 5;
        this.postedQuestionsList.add(postingId);
        return postingId;
    }

    public Integer postAnswer(Integer questionId, String content) throws IllegalAccessException {
        // check if closed throw exception
        // this posts a given answer by the current user to the given question
        // update score
        return 0;
    }

    public Integer postComment(Integer postingId, String content) throws IllegalAccessException {
        // this posts a given comment by the current user to the given postingId
        // update score
        return 0;
    }

    public void closeQuestion(Integer questionId) throws IllegalAccessException {
        // close the question
    }

    public void upVote(Integer postingId) throws IllegalAccessException {
        // upVotes that particular post
    }

    public void downVote(Integer postingId) throws IllegalAccessException {
        // downVotes that particular post
    }

    public List<Question> searchQuestion(){
        // guests should be able to search questions
        return null;
    }
}
