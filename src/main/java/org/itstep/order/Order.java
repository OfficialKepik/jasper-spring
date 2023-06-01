package org.itstep.order;

import lombok.Data;
import org.itstep.customer.Customer;
import org.itstep.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    private Date orderDate;
    private Date shippedDate;
    private String shipName;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipPostalCode;
    private String shipCountry;
    private Double shippingFee;
    private String paymentType;
    private Date paidDate;
    private String orderStatus;
}