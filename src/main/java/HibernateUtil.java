import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    public final static HibernateUtil INSTANCE = new HibernateUtil();
    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        this.sessionFactory = loadConfigFile();
    }

    private SessionFactory loadConfigFile() {

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
