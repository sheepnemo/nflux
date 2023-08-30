package project.todolist.service;

import org.springframework.stereotype.Service;
import project.todolist.domain.DataList;
import project.todolist.dto.DataListDTO;
import project.todolist.repository.DataListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataListService {

    private DataListRepository dataListRepository;

    public DataListService(DataListRepository dataListRepository) {
        this.dataListRepository = dataListRepository;
    }

    //데이터 등록
    public void enrollData(DataListDTO dataListDTO) {
        DataList dataList = dataListDTO.toEntity();
        dataListRepository.save(dataList);
    }

    //데이터 검색 분류(전체 = 0, 날짜 = 1, 내용 = 2, 완료 = 3, 예외 = 9)
    public int sortData(String searchTDDate, String searchTDContent, String searchTDCheck) {
        searchTDDate = convertNull(searchTDDate);
        searchTDContent = convertNull(searchTDContent);
        searchTDCheck = convertNull(searchTDCheck);
        if (searchTDDate == null) {
            if ((searchTDContent == null) && (searchTDCheck == null)) {
                return 0;
            } else if ((searchTDContent != null) && (searchTDCheck == null)) {
                return 2;
            } else if ((searchTDContent == null) && (searchTDCheck != null)) {
                return 3;
            } else return 9;
        }
        else {
            if ((searchTDContent == null) && (searchTDCheck == null)) {
                return 1;
            } else if ((searchTDContent != null) && (searchTDCheck == null)) {
                return 9;
            } else if ((searchTDContent == null) && (searchTDCheck != null)) {
                return 9;
            } else return 9;
        }
    }

    //데이터 공백 변환
    public String convertNull(String data) {
        if ("".equals(data)) data = null;
        return data;
    }

    //날짜 데이터 조회
    public List<DataListDTO> searchDate(String TDDate, Long userId) {
        List<DataListDTO> dataListDTOS = new ArrayList<>();
        int listSize = dataListRepository.findByTodoDateAndUserIdOrderByTodoDate(TDDate, userId).size();
        for (int i = 0; i < listSize; i++) {
            dataListDTOS.add(dataListRepository.findByTodoDateAndUserIdOrderByTodoDate(TDDate, userId).get(i).toDTO());
        }
        return dataListDTOS;
    }

    //내용 데이터 조회
    public List<DataListDTO> searchContent(String TDContent, Long userId) {
        List<DataListDTO> dataListDTOS = new ArrayList<>();
        int listSize = dataListRepository.findByTodoContentAndUserIdOrderByTodoDate(TDContent, userId).size();
        for (int i = 0; i < listSize; i++) {
            dataListDTOS.add(dataListRepository.findByTodoContentAndUserIdOrderByTodoDate(TDContent, userId).get(i).toDTO());
        }
        return dataListDTOS;
    }

    //완료 데이터 조회
    public List<DataListDTO> searchCheck(String TDCheck, Long userId) {
        List<DataListDTO> dataListDTOS = new ArrayList<>();
        int listSize = dataListRepository.findByTodoCheckAndUserIdOrderByTodoDate(TDCheck, userId).size();
        for (int i = 0; i < listSize; i++) {
            dataListDTOS.add(dataListRepository.findByTodoCheckAndUserIdOrderByTodoDate(TDCheck, userId).get(i).toDTO());
        }
        return dataListDTOS;
    }

    //전체 데이터 조회
    public List<DataListDTO> searchAll(Long userId) {
        List<DataListDTO> dataListDTOS = new ArrayList<>();
        int listSize = dataListRepository.findAllByUserIdOrderByTodoDate(userId).size();
        for (int i = 0; i < listSize; i++) {
            dataListDTOS.add(dataListRepository.findAllByUserIdOrderByTodoDate(userId).get(i).toDTO());
        }
        return dataListDTOS;
    }

    //데이터 삭제
    public void deleteDataById(Long id) {
        dataListRepository.deleteDataListById(id);
    }
}
