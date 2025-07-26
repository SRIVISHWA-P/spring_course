package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sf  = new Configuration()
//                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Student s1 = new Student();
//        s1.setsAge(31);
//        s1.setsName("dinesh");
//        s1.setRollNo(106);

//        CRUD Operations....

//        Student s2 = session.get(Student.class,102); //for retrieving data
//        System.out.println(s2);

//        Transaction transaction = session.beginTransaction(); //for inserting data
//        session.persist(s1);
//        transaction.commit();

//        Transaction transaction = session.beginTransaction(); //for updating the data
//        session.merge(s1);
//        transaction.commit();
//        System.out.println(s1);

//        Transaction transaction = session.beginTransaction(); //for deleting the data(fetch first and delete)
//        s1 = session.get(Student.class,106);
//        System.out.println(s1);
//        session.remove(s1);
//        transaction.commit();

//        Laptop l1 = new Laptop();
//        l1.setLid(4);
//        l1.setBrand("Asus");
//        l1.setModel("zephyrus");
//        l1.setRam(32);

//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(32);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("Apple");
//        l3.setModel("MacBook");
//        l3.setRam(8);

//        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("navin");
//        a1.setTech("java");
//
//        Alien a2 = new Alien();
//        a2.setAid(102);
//        a2.setAname("vishwa");
//        a2.setTech("C++");
//
//        a1.setLaptops(Arrays.asList(l1,l2));
//        a2.setLaptops(Arrays.asList(l3));
//
//

//        Transaction transaction = session.beginTransaction();
//
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//        session.persist(a1);
//        session.persist(a2);

//        transaction.commit();

        Query<Object[]> query = session.createQuery("select brand,model,ram,lid from Laptop where brand like ?1", Object[].class);
        query.setParameter(1,"Asus");
//        List<Laptop> laptops = query.getResultList();
        List<Object[]> laptops = query.getResultList();
        for(Object[] data : laptops){
            System.out.println((String)data[0]+" "+(String)data[1]+(Integer)data[2]+(Integer)data[3]);
        }
//        Laptop l2 = session.get(Laptop.class,4); //fetching
//        System.out.println(laptops);

        session.close();
        sf.close();
    }
}