package aptech.t2008m.hellospring.many2many.usecompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grade save(Grade grade){
        gradeRepository.save(grade);
        return grade;
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }
    public Optional<Grade> findById(int gradeId){
        return gradeRepository.findById(gradeId);
    }
}
