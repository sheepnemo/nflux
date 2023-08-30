package story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import story.domain.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>{

}
