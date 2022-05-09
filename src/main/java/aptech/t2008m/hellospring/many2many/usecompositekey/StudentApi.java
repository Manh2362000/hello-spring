package aptech.t2008m.hellospring.many2many.usecompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentApi {
    @Autowired
    StudentService studentService;
    @Autowired
    GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
        public List<Student> findAll(){
        return studentService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        System.out.println(student.getRollNumber());
        return studentService.save(student);
    }
    @RequestMapping(method = RequestMethod.GET,path = "add-grade")
    public ResponseEntity<String> addStudentToGrade(
            @RequestParam String studentRollNumber,
            @RequestParam int gradeId){
        //check su ton tai cua student
        Optional<Student> optionalStudent = studentService.findById(studentRollNumber);
        //check su ton tai cua grade
        Optional<Grade> optionalGrade = gradeService.findById(gradeId);
        //tra ve not found neu mot trong2 truong hop khong tim thay
        if (!optionalStudent.isPresent() || !optionalGrade.isPresent()){
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        boolean result = studentService.addStudentToClass(optionalStudent.get(),optionalGrade.get());
        if (!result){
            return new ResponseEntity<>("Add student erorr!",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Add student success!", HttpStatus.OK);
    }

}
