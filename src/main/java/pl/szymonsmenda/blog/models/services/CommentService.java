package pl.szymonsmenda.blog.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.blog.models.CommentEntity;
import pl.szymonsmenda.blog.models.PostEntity;
import pl.szymonsmenda.blog.models.forms.CommentForm;
import pl.szymonsmenda.blog.models.repositories.CommentRepository;

@Service
public class CommentService {
    final CommentRepository commentRepository;
    final SessionService sessionService;

    @Autowired
    public CommentService(CommentRepository commentRepository, SessionService sessionService) {
        this.commentRepository = commentRepository;
        this.sessionService = sessionService;
    }

    public void addComment(CommentForm commentForm, int postId){
        CommentEntity commentEntity = createCommentEntity(commentForm, postId);
        commentRepository.save(commentEntity);
    }

    private CommentEntity createCommentEntity(CommentForm commentForm, int postId) {
        CommentEntity commentEntity = new CommentEntity();
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postId);

        commentEntity.setContext(commentForm.getContext());
        commentEntity.setPost(postEntity);
        commentEntity.setUser(sessionService.getUserEntity());
        return commentEntity;
    }


}
