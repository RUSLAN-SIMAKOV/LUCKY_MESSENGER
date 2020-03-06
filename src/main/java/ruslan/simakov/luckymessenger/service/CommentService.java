package ruslan.simakov.luckymessenger.service;

import ruslan.simakov.luckymessenger.model.Comment;

public interface CommentService {

    void doSomeWorkOnCommentCreation();

    Comment addNewComment(Comment comment);

    boolean isCommentPresent(Comment comment);
}
