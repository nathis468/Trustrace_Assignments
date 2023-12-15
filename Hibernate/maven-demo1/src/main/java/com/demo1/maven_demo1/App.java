package com.demo1.maven_demo1;

import java.io.InputStream;
import java.util.*;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
//import org.hibernate.Query;
//import org.hibernate.query.criteria.JpaCriteriaQuery;

import jakarta.persistence.criteria.CriteriaQuery;

public class App 
{
    public static void main( String[] args )
    {
        App p=new App();
        Configuration c=new Configuration().addProperties(p.loadConfig());
        SessionFactory sf =  c.addAnnotatedClass(Userdetails.class).buildSessionFactory();
        Session s = sf.openSession();
        Transaction tb = s.beginTransaction();

        System.out.println("connected: "+s.isConnected());

        
        // to insert data into DB
        Userdetails ud= new Userdetails();
        ud.userid = "202ct119";
        ud.email = "demo1@gmail.com";
        ud.verified = true;
        ud.phonenumber = "9876543210";
        ud.DOB="01/10/2003";
        ud.password="ngufdashf";
        // SessionFactory sf = c.addAnnotatedClass(c.getClass()).buildSessionFactory();// alternate
        s.persist(ud);
        tb.commit();
        s.close();
        sf.close();
    }
    public  Properties loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("hibernate.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
        }
}

