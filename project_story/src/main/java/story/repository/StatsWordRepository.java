package story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import story.domain.StatsWord;

public interface StatsWordRepository extends JpaRepository<StatsWord, Long>{

}
