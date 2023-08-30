package story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import story.domain.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

}
