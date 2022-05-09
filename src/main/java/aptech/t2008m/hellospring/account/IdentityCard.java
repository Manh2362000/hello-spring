package aptech.t2008m.hellospring.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "identity_cards")
public class IdentityCard {
    @Id
    private String number;
    private String fullName;
    private Integer gender;
    private Date birthday;
    private String Address;
    private String description;
    private String createdBy;
    private Date createAt;
    private Date updateAt ;
    private Integer status ;
    @OneToOne(mappedBy = "identityCard")
    private Account account;
}
