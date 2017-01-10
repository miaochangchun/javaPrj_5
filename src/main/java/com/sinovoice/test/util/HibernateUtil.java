package com.sinovoice.test.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

    static {
        try {
            // ����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��
            Configuration cfg = new Configuration().configure();

            cfg.addClass(com.sinovoice.test.bean.User.class);

            // ��Configurationʵ��������SessionFactoryʵ��
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��
    public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

    /**
     * ����Session
     * @return
     * @throws HibernateException
     */
    public static Session currentSession() throws HibernateException {
        //ͨ���̶߳���.get()������ȫ����Session
        Session s = session.get();
        // ������̻߳�û��Session,�򴴽�һ���µ�Session
        if (s == null) {
            s = sessionFactory.openSession();
            // ����õ�Session�����洢��ThreadLocal����session��
            session.set(s);
        }
        return s;
    }

    /**
     * �ر�Session
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session s = session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
}
