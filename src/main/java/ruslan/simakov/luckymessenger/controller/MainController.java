package ruslan.simakov.luckymessenger.controller;

import ruslan.simakov.luckymessenger.model.Comment;
import ruslan.simakov.luckymessenger.model.Notification;
import ruslan.simakov.luckymessenger.model.dto.CommentDto;
import ruslan.simakov.luckymessenger.service.CommentService;
import ruslan.simakov.luckymessenger.service.NotificationService;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    @Transactional(rollbackFor = RuntimeException.class)
    @PostMapping(value = "/add")
    public void addNewComment(@RequestBody CommentDto commentDto) {

        Comment newComment = new Comment();
        newComment.setComment(commentDto.getComment());
        newComment.setTimeGeneratingComment(LocalDateTime.now());
        newComment = commentService.addNewComment(newComment);
        commentService.doSomeWorkOnCommentCreation();
        if (commentService.isCommentPresent(newComment)) {
            Notification newNotification = new Notification();

        }
    }
}
