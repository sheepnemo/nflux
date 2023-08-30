package project.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import project.todolist.dto.DataListDTO;

@Getter
@Entity(name = "TDL_DATA")
public class DataList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "D_DATE")
    private String todoDate = null;

    @Column(name = "D_CONTENT")
    private String todoContent = null;

    @Column(name = "D_CHECK")
    private String todoCheck = null;

    public DataList() {}

    public DataList(Long userId, String todoDate, String todoContent, String todoCheck) {
        this.userId = userId;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.todoCheck = todoCheck;
    }

    public DataListDTO toDTO() {
        return new DataListDTO(id, userId, todoDate, todoContent, todoCheck);
    }
}
