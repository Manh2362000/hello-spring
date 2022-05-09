package aptech.t2008m.hellospring.many2many.usecompositekey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentGradeId implements Serializable {
    @Column(name = "grade_id")
    private int gradeId;
    @Column(name = "student_rollnumber")
    private String studentRollNumber;

    public StudentGradeId(int id, String rollNumber) {

    }

    public StudentGradeId() {

    }
}
