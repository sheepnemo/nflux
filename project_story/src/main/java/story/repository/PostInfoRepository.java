package story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import story.domain.PostInfo;

public interface PostInfoRepository extends JpaRepository<PostInfo, Long>{

}
