package StackOverFlow;

import java.time.ZonedDateTime;

public abstract class Posting {
    Integer id;
    String postedBy;
    String content;
    Integer upVotes;
    Integer downVotes;
    ZonedDateTime postedAt;

    public void upVote() {
        this.upVotes++;
    }

    public void downVote() {
        this.downVotes++;
    }
}
