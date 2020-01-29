package inicio;

import java.io.File;
import java.util.List;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import tablas.idioma;
import tablas.literal;
import tablas.loghiv;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure(new File("Hibernate.cfg.xml") );	
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/tablasacesso?serverTimezone=UTC");
//                settings.put(Environment.USER, "root");
//                settings.put(Environment.PASS, "12345678");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                configuration.setProperties(settings);
                configuration.addAnnotatedClass(idioma.class);
                configuration.addAnnotatedClass(literal.class);
                configuration.addAnnotatedClass(loghiv.class);
          
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
