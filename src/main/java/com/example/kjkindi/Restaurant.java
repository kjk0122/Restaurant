package com.example.kjkindi;

import com.example.kjkindi.entity.Food;
import com.example.kjkindi.entity.Member;
import com.example.kjkindi.entity.Order;
import com.example.kjkindi.repository.FoodRepository;
import com.example.kjkindi.repository.MemberRepository;
import com.example.kjkindi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Restaurant implements ApplicationRunner {

    private final FoodRepository foodRepository;
    private final OrderRepository ordersRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Food> foods = new ArrayList<>();
        Food food1 = new Food("후라이드", 10000);
        foods.add(food1);
        Food food2 = new Food("양념치킨", 12000);
        foods.add(food2);
        Food food3 = new Food("반반치킨", 13000);
        foods.add(food3);
        Food food4 = new Food("고구마피자", 9000);
        foods.add(food4);
        Food food5 = new Food("아보카도피자", 110000);
        foods.add(food5);
        foodRepository.saveAll(foods);

        List<Member> members = new ArrayList<>();
        Member member1 = new Member("삼식이");
        members.add(member1);
        Member member2 = new Member("먹깨비");
        members.add(member2);
        memberRepository.saveAll(members);

        System.out.println("==================================================================");

        System.out.println("Member 데이터");
        List<Member> findMembers = memberRepository.findAll();
        for (Member findMember : findMembers) {
            System.out.println("findMember = " + findMember.getMemberName());
        }

        System.out.println("==================================================================");

        System.out.println("Food 데이터");
        List<Food> findFoods = foodRepository.findAll();
        for (Food findFood : findFoods) {
            System.out.println("findFood = " + findFood.getFoodName());
        }

        List<Order> ordersList = new ArrayList<>();
        Order orders1 = new Order(findFoods.get(0), findMembers.get(0));
        ordersList.add(orders1);
        Order orders2 = new Order(findFoods.get(3), findMembers.get(1));
        ordersList.add(orders2);
        Order orders3 = new Order(findFoods.get(4), findMembers.get(1));
        ordersList.add(orders3);
        Order orders4 = new Order(findFoods.get(2), findMembers.get(0));
        ordersList.add(orders4);
        Order orders5 = new Order(findFoods.get(2), findMembers.get(0));
        ordersList.add(orders5);
        Order orders6 = new Order(findFoods.get(1), findMembers.get(1));
        ordersList.add(orders6);
        Order orders7 = new Order(findFoods.get(1), findMembers.get(0));
        ordersList.add(orders7);
        Order orders8 = new Order(findFoods.get(3), findMembers.get(1));
        ordersList.add(orders8);
        ordersRepository.saveAll(ordersList);

        System.out.println("==================================================================");
        int num = 1;

        System.out.println("Orders 데이터");
        List<Order> orderList = ordersRepository.findAll();

        for (Order orders : orderList) {
            System.out.println(num);
            System.out.println("주문한 사람 = " + orders.getMember().getMemberName());
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            num++;
        }

        System.out.println("==================================================================");
        System.out.println("삼식이 주문한 음식");
        Member samsik = memberRepository.findById(1L).orElseThrow(
                ()->new RuntimeException("없음")
        );

        num = 1;
        for (Order orders : samsik.getOrder()) {
            System.out.println(num);
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            System.out.println("주문한 음식 가격 = " + orders.getFood().getPrice());
            num++;
        }


        System.out.println("==================================================================");
        System.out.println("아보카도피자 주문한 사람");
        Food abocado = foodRepository.findById(5L).orElseThrow(
                ()->new RuntimeException("없음")
        );

        for (Order order : abocado.getOrder()) {
            System.out.println("주문한 사람 = " + order.getMember().getMemberName());
        }


    }
}