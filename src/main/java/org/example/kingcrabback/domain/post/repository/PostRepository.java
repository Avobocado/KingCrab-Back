package org.example.kingcrabback.domain.post.repository;

import org.example.kingcrabback.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllById (Long id);
=======
@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
>>>>>>> origin/post
}
