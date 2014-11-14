package main;

import model.News;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NewsManager {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		News n = new News();
		n.setTitle("双11购物节即将到来");
		n.setContent("大家开始物色商品，到当天可以及时进行抢购");
		sess.save(n);
		tx.commit();
		sess.close();
	}
}
