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
		n.setTitle("˫11����ڼ�������");
		n.setContent("��ҿ�ʼ��ɫ��Ʒ����������Լ�ʱ��������");
		sess.save(n);
		tx.commit();
		sess.close();
	}
}
