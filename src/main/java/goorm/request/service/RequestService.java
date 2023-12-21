package goorm.request.service;

import goorm.request.repository.RequestRepository;
import goorm.request.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository repository;

    public Student save(String name, int grade) {
        return repository.save(new Student(name, grade));
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public List<Student> findByGrade(int grade) {
        return repository.findByGrade(grade);
    }

}
