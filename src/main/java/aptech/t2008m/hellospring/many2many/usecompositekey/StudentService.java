package aptech.t2008m.hellospring.many2many.usecompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public Student save(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String studentRollNumber) {
        return studentRepository.findById(studentRollNumber);
    }

    public boolean addStudentToClass (Student student,Grade grade){
        try{
            // lay thong tin lop hoc hien tai cua sinh vien
            Set<StudentGrade> studentGrades = student.getStudentGrades();
            if (studentGrades == null) {
                studentGrades = new HashSet<>();
            }
            // tao moi doi tuong studentGrade
            StudentGrade studentGrade =new StudentGrade();
            // set khoa chinh phuc hop
            studentGrade.setId(new StudentGradeId(grade.getId(),student.getRollNumber()));
            //set quan he nguoc lai voi student
            studentGrade.setStudent(student);
            //set quan he nguoc lai voi grade
            studentGrade.setGrade(grade);
            //dua thuong tin vao set
            studentGrades.add(studentGrade);
            //save thong tin student dong thoi la save thong tin student grade
            studentRepository.save(student);
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

}
