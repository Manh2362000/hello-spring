package aptech.t2008m.hellospring.Order;

import aptech.t2008m.hellospring.Product.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private double totalPrice;
    private String shipName;
    private String shipAddress;
    private int shipPhone;
    private Date createsAt;
    private Date updateAt;
    private int status;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;
}