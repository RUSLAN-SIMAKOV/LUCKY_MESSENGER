package ruslan.simakov.luckymessenger.service;

import ruslan.simakov.luckymessenger.model.Comment;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CommentService {

    void doSomeWorkOnCommentCreation();

    Comment addNewComment(Comment comment);

    List<Comment> getAllComments(Pageable pageable);

    boolean isCommentPresent(Comment comment);
}
