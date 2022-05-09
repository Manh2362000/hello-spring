package aptech.t2008m.hellospring.many2many.usecompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/grades")
public class GradeApi {
    @Autowired
    GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Grade> findAll(){
        return gradeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Grade save(@RequestBody Grade grade){
        System.out.println(grade.getId());
        return gradeService.save(grade);
    }
}
