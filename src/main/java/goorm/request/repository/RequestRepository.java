package goorm.request.repository;

import goorm.request.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RequestRepository {
    private static final Map<Long, Student> map = new HashMap<>();
    private static long sequence = 0L;

    public Student save(Student student) {
        student.setId(++sequence);
        map.put(student.getId(), student);
        return student;
    }

    public List<Student> findAll() {
        ArrayList<Student> res = new ArrayList<>(map.values());
        res.sort((o1, o2) -> o1.getGrade() - o2.getGrade());
        return res;
    }

    public List<Student> findByGrade(int grade) {
        List<Student> res = new ArrayList<>();

        for (Map.Entry<Long, Student> entry : map.entrySet()) {
            Student student = entry.getValue();
            if (student.getGrade() == grade) {
                res.add(student);
            }
        }

        res.sort((o1, o2) -> o1.getGrade() - o2.getGrade());

        return res;
    }
}
