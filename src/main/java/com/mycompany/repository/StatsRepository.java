/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderDetail;
import com.mycompany.pojo.Product;
import com.mycompany.thuchanhhibernate2.HibernateUtils;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author HP
 */
public class StatsRepository {

    public List<Object[]> countProductsByCate() {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rProduct = q.from(Product.class);
            Root rCate = q.from(Category.class);

            q.where(b.equal(rProduct.get("categoryId"), rCate.get("id")));

            q.multiselect(rCate.get("id"), rCate.get("name"), b.count(rProduct.get("id")));
            q.groupBy(rCate.get("id"));

            Query query = s.createQuery(q);
            return query.getResultList();

        }
    }

//    public List<Object[]> statRevenue(Map<String, String> params) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//            Root rProduct = q.from(Product.class);
//            Root rOrderDetails = q.from(OrderDetail.class);
//
//            q.where(b.equal(rOrderDetails.get("productId"), rProduct.get("id")));
//
//            q.multiselect(rProduct.get("id"), rProduct.get("name"), b.prod(rOrderDetails.get("unitPrice"), rOrderDetails.get("num")));
//            q.groupBy(rProduct.get("id"));
//
//            Query query = s.createQuery(q);
//            return query.getResultList();
//
//        }
//
//    }

}
