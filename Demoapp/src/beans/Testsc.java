package beans;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Testsc {

	public static void main(String[] args) 
	{
	 Configuration cfg=new Configuration();
	 cfg.configure("resources/hibernate.cfg.xml");
	 SessionFactory sf=cfg.buildSessionFactory();
	 Session s=sf.openSession();
	 Transaction tx;
	 String choice="no";
	 Scanner sc=new Scanner(System.in);
     do
     {
    	 tx=s.beginTransaction();
    	 Studentdto dto=new Studentdto();
    	System.out.println("enter id");
    	dto.setSid(sc.nextInt());
    	System.out.println("enter  name");
    	dto.setSname(sc.next());
    	System.out.println("enter address");
    	dto.setSaddress(sc.next());
    	s.save(dto);
    	tx.commit();
    	System.out.println("one record insert");
    	System.out.println("you want insert new record");
    	choice=sc.next();
    	
     }
     while(choice.equalsIgnoreCase("y")|choice.equalsIgnoreCase("n"));
     s.close();
     sf.close();
	}

}
