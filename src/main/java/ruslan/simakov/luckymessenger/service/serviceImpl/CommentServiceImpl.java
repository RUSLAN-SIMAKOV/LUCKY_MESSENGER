package ruslan.simakov.luckymessenger.service.serviceImpl;

import ruslan.simakov.luckymessenger.model.Comment;
import ruslan.simakov.luckymessenger.repository.CommentRepository;
import ruslan.simakov.luckymessenger.service.BusinessLogicService;
import ruslan.simakov.luckymessenger.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BusinessLogicService businessLogicService;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void doSomeWorkOnCommentCreation() {
        businessLogicService.sleepAndRandomThrowRuntimeException(1, 30);
    }

    @Override
    public Comment addNewComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable).getContent();
    }

    @Override
    public boolean isCommentPresent(Comment comment) {
        return commentRepository.existsById(comment.getId());
    }
}
