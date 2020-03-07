package ruslan.simakov.luckymessenger.controller;

import static java.util.stream.Collectors.toList;
import ruslan.simakov.luckymessenger.model.Comment;
import ruslan.simakov.luckymessenger.model.Notification;
import ruslan.simakov.luckymessenger.model.dto.CommentDto;
import ruslan.simakov.luckymessenger.model.dto.NotificationDto;
import ruslan.simakov.luckymessenger.service.CommentService;
import ruslan.simakov.luckymessenger.service.NotificationService;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    @Transactional(rollbackFor = RuntimeException.class)
    @PostMapping(value = "/add")
    public String addNewComment(@RequestBody CommentDto commentDto) {

        Comment newComment = new Comment();
        newComment.setComment(commentDto.getComment());
        newComment.setTimeGeneratingComment(LocalDateTime.now());
        newComment = commentService.addNewComment(newComment);
        commentService.doSomeWorkOnCommentCreation();
        if (commentService.isCommentPresent(newComment)) {
            Notification newNotification = new Notification();
            newNotification.setCommentId(newComment.getId());
            newNotification.setTimeGeneratingNotification(LocalDateTime.now());
            newNotification.setIsNotificationDelivered(false);
            notificationService.addNewNotification(newNotification);
            try {
                notificationService.doSomeWorkOnNotification();
                newNotification.setIsNotificationDelivered(true);
                notificationService.addNewNotification(newNotification);
            } catch (RuntimeException e) {
                e.printStackTrace();
                return "Message created successful. Notification fail!";
            }
        }
        return "Success";
    }

    @GetMapping(value = "/allcomments")
    public List<CommentDto> getAllComments(@RequestParam(
            value = "page", required = false, defaultValue = "0") Integer page,
                                           @RequestParam(
                                                   value = "limit", required = false, defaultValue = "10") Integer limit,
                                           @RequestParam(
                                                   value = "sort", required = false, defaultValue = "id") String sort,
                                           @RequestParam(
                                                   value = "order", required = false, defaultValue = "asc") String order) {

        Sort.Direction orderDirection = Sort.Direction.fromString(order);
        Sort sortRequest = Sort.by(orderDirection, sort);
        Pageable pageRequest = PageRequest.of(page, limit, sortRequest);
        List<Comment> allComments = commentService.getAllComments(pageRequest);
        return allComments.stream().map(this::getCommentDto).collect(toList());
    }


    @GetMapping(value = "/allnotifications")
    public List<NotificationDto> getAllNotifications(@RequestParam(
            value = "page", required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(
                                                             value = "limit", required = false, defaultValue = "10") Integer limit,
                                                     @RequestParam(
                                                             value = "sort", required = false, defaultValue = "id") String sort,
                                                     @RequestParam(
                                                             value = "order", required = false, defaultValue = "asc") String order) {

        Sort.Direction orderDirection = Sort.Direction.fromString(order);
        Sort sortRequest = Sort.by(orderDirection, sort);
        Pageable pageRequest = PageRequest.of(page, limit, sortRequest);
        List<Notification> allNotifications = notificationService.getAllNotifications(pageRequest);
        return allNotifications.stream().map(this::getNotificationDto).collect(toList());
    }

    private CommentDto getCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setComment(comment.getComment());
        commentDto.setTimeGeneratingComment(comment.getTimeGeneratingComment());
        return commentDto;
    }

    private NotificationDto getNotificationDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setCommentId(notification.getCommentId());
        notificationDto.setTimeGeneratingNotification(notification.getTimeGeneratingNotification());
        notificationDto.setIsNotificationDelivered(notification.getIsNotificationDelivered());
        return notificationDto;
    }
}
