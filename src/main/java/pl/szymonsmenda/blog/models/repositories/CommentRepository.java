package pl.szymonsmenda.blog.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.blog.models.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer>{
    List<CommentEntity> findAllByPost_Id(int id);
}
