package com.example.kjkindi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    public Order(Food food, Member member) {
        this.food = food;
        this.member = member;
    }
}
