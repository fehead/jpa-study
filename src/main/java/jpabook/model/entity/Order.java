package jpabook.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by holyeye on 2014. 3. 11..
 */
@Entity
@Table(name = "ORDERS")
@Getter @Setter
@ToString
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member	member;

    @OneToMany(mappedBy = "order")
    private	List<OrderItem>	orderItems = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;     //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;//주문상태

    public void setMember(Member member) {
    	if(this.member != null) {
    		this.member.getOrders().remove(this);
    	}
    	this.member = member;
    	member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
    	orderItems.add(orderItem);
    	orderItem.setOrder(this);
    }
}
