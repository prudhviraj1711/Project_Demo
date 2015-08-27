
Hai This is commited at 4:24pm

package com.coresoft;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OurLogic {
	public static void main(String args[])
	{
	 
	Configuration cfg = new Configuration();
	cfg.configure("com/coresoft/hibernate.cfg.xml");
	 
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	//parent object
	Vendor v =new Vendor();
	 
	v.setVendorId(101);
	v.setVendorName("prudhvi");
	 
	//creating 3 child objects
	CustomerOne c1=new CustomerOne();
	 
	c1.setCustomerOneId(504);
	c1.setCustomerOneName("customer4");
	 
	CustomerOne c2=new CustomerOne();
	 
	c2.setCustomerOneId(505);
	c2.setCustomerOneName("customer5");
	 
	CustomerOne c3=new CustomerOne();
	 
	c3.setCustomerOneId(506);
	c3.setCustomerOneName("customer6");
	 
	// adding child objects to set, as we taken 3rd property set in parent
	Set s=new HashSet();
	 
	s.add(c1);
	s.add(c2);
	s.add(c3);
	System.out.println("after hash set");
	 
	v.setChildren(s);
	System.out.println("vendor"+v);
	 
	Transaction tx = session.beginTransaction();
	 
	session.save(v);
	 
	tx.commit();
	session.close();
	System.out.println("One To Many is Done..!!");
	factory.close();
	 
	}

}
