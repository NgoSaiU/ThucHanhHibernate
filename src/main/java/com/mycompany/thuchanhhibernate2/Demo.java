/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhhibernate2;

import com.mycompany.pojo.Category;
import com.mycompany.repository.ProductRepository;
import com.mycompany.repository.StatsRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class Demo {

    public static void main(String[] args) {
        StatsRepository s = new StatsRepository();
        s.countProductsByCate().forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));

//        StatsRepository s = new StatsRepository();
//        s.statRevenue(null).forEach(o -> System.out.printf("%d - %s: %d\n", o[0], o[1], o[2]));
//        
        
        
        
    }

}
