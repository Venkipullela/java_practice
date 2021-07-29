package StackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class Question extends Posting {
    String title;
    List<Comment> commentList = new ArrayList<>();
    List<Answer> answerList = new ArrayList<>();
    List<String> tags = new ArrayList<>();
    Integer bounty;
    Boolean isOpen;
}
