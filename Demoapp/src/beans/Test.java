package beans;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Test
{
   public void save()
   {
	   Configuration cfg=new Configuration();
		  cfg.configure("resources/hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session s=sf.openSession();
		  Transaction tx=s.beginTransaction();
		  Studentdto st=new Studentdto();
		  
		  st.setSname("ajay");
		  st.setSaddress("indore");
		  s.save(st);
		  tx.commit();
		  
		  System.out.println("insert done");
		  try
		  {
			 Thread.sleep(10000); 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  s.close();
	      sf.close();
	      System.out.println("Drop all table success");
   }
   public void update()
   {
	   Configuration cfg=new Configuration();
		  cfg.configure("resources/hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session s=sf.openSession();
		  Transaction tx=s.beginTransaction();
		  
		  s.get(Studentdto.class,1);
		  Studentdto st=new Studentdto();
		  st.setSid(1);
		  st.setSname("dinesh");
		  st.setSaddress("khargone");
		  //s.update(st);
		  s.merge(st);
		  tx.commit();
		  
		  System.out.println("update done");
		  s.close();
	      sf.close();
   }
   public void Delete()
   {
	   Configuration cfg=new Configuration();
		  cfg.configure("resources/hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session s=sf.openSession();
		  Transaction tx=s.beginTransaction();
		 
		  Studentdto st=new Studentdto();
		  st.setSid(1);
		  s.delete(st);
		  tx.commit();
		  
		  System.out.println("delete done");
		  s.close();
	      sf.close();
   }
   public void select()
   {
	   Configuration cfg=new Configuration();
		  cfg.configure("resources/hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session s=sf.openSession();
		  //Transaction tx=s.beginTransaction();
		  Studentdto st=(Studentdto)s.load(Studentdto.class,811);
		  System.out.println("student id:"+st.getSid());
		  System.out.println("student name:"+st.getSname());
		  System.out.println("student address:"+st.getSaddress());
		  
		  
		  System.out.println("select done");
		  s.close();
	      sf.close();
   }
   public void selectall()
   {
	   Configuration cfg=new Configuration();
		  cfg.configure("resources/hibernate.cfg.xml");
		  SessionFactory sf=cfg.buildSessionFactory();
		  Session s=sf.openSession();
		  String hql="from Studentdto";
		  Query q=s.createQuery(hql);
		   List l=q.list();
		   Iterator it=l.iterator();
		   while(it.hasNext())
		   {
			   Studentdto st=(Studentdto)it.next();
			   System.out.println("student id:"+st.getSid());
				  System.out.println("student name:"+st.getSname());
				  System.out.println("student address:"+st.getSaddress());
				  
		   }
		  
		  
		  
		  System.out.println("select done");
		  s.close();
	      sf.close();
   }
	public static void main(String[] args) throws Exception
	{
	  Test t=new Test();
	 //t.save();
	  //t.update();
	 // t.Delete();
	  t.select();
	  //t.selectall();
	}

}
