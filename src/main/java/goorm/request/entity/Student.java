package goorm.request.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class Student {
    @JsonIgnore
    private Long id;
    private final String name;
    private final int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
