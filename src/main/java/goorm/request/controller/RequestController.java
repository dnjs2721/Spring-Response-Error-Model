package goorm.request.controller;

import goorm.request.ApiResponse;
import goorm.request.entity.Student;
import goorm.request.exception.CustomException;
import goorm.request.exception.ErrorCode;
import goorm.request.exception.InputRestriction;
import goorm.request.service.RequestService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class RequestController extends BaseController{

    private final RequestService service;

    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Student> saveStudent(@RequestBody Student student) {
        if (student.getGrade() >= 6) {
            throw new CustomException(ErrorCode.SERVER_ERROR, "grade 는 6이상을 입력 할 수 없습니다.", new InputRestriction(6));
        } else {
            return makeResponse(service.save(student.getName(), student.getGrade()));
        }
    }

    @GetMapping("/searchAllStudent")
    @ResponseBody
    public ApiResponse<Student> searchAllStudent() {
        return makeResponse(service.getAll());
    }

    @GetMapping("/searchByGrade/{grade}")
    @ResponseBody
    public ApiResponse<Student> searchByGrade(@PathVariable("grade") int grade) {
        if (grade >= 6) {
            throw new CustomException(ErrorCode.SERVER_ERROR, "grade 는 6이상을 입력 할 수 없습니다.", null);
        } else {
            return makeResponse(service.findByGrade(grade));
        }
    }
}
