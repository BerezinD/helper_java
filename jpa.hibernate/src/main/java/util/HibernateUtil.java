package util;

import entity.CarEntity;
import entity.PhoneEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configHibernate = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/example");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "postgres");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
            properties.put(Environment.SHOW_SQL, true);
            configHibernate.setProperties(properties);
            configHibernate.addAnnotatedClass(CarEntity.class);
            configHibernate.addAnnotatedClass(PhoneEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configHibernate.getProperties())
                    .build();
            sessionFactory = configHibernate.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
