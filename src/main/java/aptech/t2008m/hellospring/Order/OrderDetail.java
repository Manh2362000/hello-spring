package aptech.t2008m.hellospring.Order;

import aptech.t2008m.hellospring.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id",referencedColumnName = "id",nullable = false)
    private Order order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;
    // thông tin thêm.
    private int quantity;
    private double unitPrice;
}