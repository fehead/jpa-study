package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by holyeye on 2014. 3. 11..
 */
@Entity
@Table(name = "ORDER_ITEM")
@Getter @Setter
@ToString
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item	item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order	order;

    private int orderPrice; //주문 가격
    private int count;      //주문 수량
}
