package project.todolist.dto;

import lombok.Getter;
import project.todolist.domain.DataList;

@Getter
public class DataListDTO {
    private Long id;

    private Long userId;

    private String todoDate;

    private String todoContent;

    private String todoCheck;

    public DataListDTO() {}

    public DataListDTO(Long userId, String todoDate, String todoContent, String todoCheck) {
        this.userId = userId;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.todoCheck = todoCheck;
    }

    public DataListDTO(Long id, Long userId, String todoDate, String todoContent, String todoCheck) {
        this.id = id;
        this.userId = userId;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.todoCheck = todoCheck;
    }

    public DataList toEntity() {return new DataList(userId, todoDate, todoContent, todoCheck); }
}
