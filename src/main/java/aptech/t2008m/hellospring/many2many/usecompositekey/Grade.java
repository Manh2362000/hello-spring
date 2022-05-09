package aptech.t2008m.hellospring.many2many.usecompositekey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "grade")
    private Set<StudentGrade> studentGrades;
}
