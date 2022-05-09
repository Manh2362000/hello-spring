package aptech.t2008m.hellospring.many2many.usecompositekey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_grades")
public class StudentGrade {
    /**
    //gradeId: lop nao
    //studentRollNumber: hoc sinh nao
     */
    @EmbeddedId
    private StudentGradeId id; // khoa chinh phuc hop
    @ManyToOne
    @MapsId("gradeId")
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @ManyToOne
    @MapsId("studentRollNumber")
    @JoinColumn(name = "student_rollnumber")
    private Student student;

}
