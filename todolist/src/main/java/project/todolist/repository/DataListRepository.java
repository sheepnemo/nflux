package project.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project.todolist.domain.DataList;

import java.util.List;
import java.util.Optional;

public interface DataListRepository extends JpaRepository<DataList, Long> {

    DataList save(DataList dataList);

    @Transactional
    Optional<Integer> deleteDataListById(Long id);

    List<DataList> findByTodoDateAndUserIdOrderByTodoDate(String todoDate, Long userId);

    List<DataList> findByTodoContentAndUserIdOrderByTodoDate(String todoContent, Long userId);

    List<DataList> findByTodoCheckAndUserIdOrderByTodoDate(String todoCheck, Long userId);

    List<DataList> findAllByUserIdOrderByTodoDate(Long userId);
}
