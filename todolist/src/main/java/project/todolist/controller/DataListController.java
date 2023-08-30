package project.todolist.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.todolist.dto.DataListDTO;
import project.todolist.service.DataListService;
import project.todolist.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DataListController {

    private UserService userService;

    private DataListService dataListService;

    public DataListController(UserService userService, DataListService dataListService) {
        this.userService = userService;
        this.dataListService = dataListService;
    }

    //데이터 등록
    @PostMapping(value = "/enroll/data")
    @ResponseBody
    public String enrollTDData(String enrollDate, String enrollContent, String enrollCheck, HttpSession session) {
        Long loginId = userService.searchPKId((String)session.getAttribute(SessionConst.LOGIN_USER));

        DataListDTO dataListDTO = new DataListDTO(loginId, enrollDate, enrollContent, enrollCheck);

        dataListService.enrollData(dataListDTO);
        return "success";
    }

    //데이터 검색
    @PostMapping(value = "/search/data")
    @ResponseBody
    public List<DataListDTO> searchData(String searchDate, String searchContent, String searchCheck, HttpSession session) {
        Long loginId = userService.searchPKId((String)session.getAttribute(SessionConst.LOGIN_USER));
        List<DataListDTO> dataListDTOS = new ArrayList<>();

        switch (dataListService.sortData(searchDate, searchContent, searchCheck)) {
            case 0: return dataListService.searchAll(loginId);
            case 1: return dataListService.searchDate(searchDate, loginId);
            case 2: return dataListService.searchContent(searchContent, loginId);
            case 3: return dataListService.searchCheck(searchCheck, loginId);
            default: return dataListDTOS;
        }
    }

    //데이터 삭제
    @PostMapping(value = "/delete/data")
    @ResponseBody
    public String deleteData(Long deleteId) {
        dataListService.deleteDataById(deleteId);
        return "/login/menu";
    }

    //데이터 수정
    @PostMapping(value = "/update/data")
    @ResponseBody
    public String updateData(Long updateId) {

        return "/login/menu";
    }
}
