package story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import story.domain.PostContent;

public interface PostContentRepository extends JpaRepository<PostContent, Long>{

}
