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
@Table(name = "students")
public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentGrade> studentGrades;
}
