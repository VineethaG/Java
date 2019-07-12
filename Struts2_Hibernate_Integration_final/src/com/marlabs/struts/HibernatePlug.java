package com.marlabs.struts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernatePlug {

	private static SessionFactory factory = getSessionFactory();

	public static synchronized SessionFactory getSessionFactory() {
		try {

			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure();

			SessionFactory sessionFactory = cfg.buildSessionFactory();
			System.out
					.println(" ----------   Factory Object Created  ------------");
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
