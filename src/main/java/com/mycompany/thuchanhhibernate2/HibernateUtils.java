/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanhhibernate2;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderDetail;
import com.mycompany.pojo.ProdTag;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.SaleOrder;
import com.mycompany.pojo.Tag;
import com.mycompany.pojo.User;
import org.hibernate.SessionFactory;
import java.util.Properties;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author HP
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb2");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "@12345ngosaiu@");
        props.put(Environment.SHOW_SQL, "true");
        conf.addAnnotatedClass(Category.class);
        
        conf.setProperties(props);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);
        
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    
}
