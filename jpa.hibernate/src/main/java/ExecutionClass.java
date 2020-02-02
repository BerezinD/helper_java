import entity.PhoneEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ExecutionClass {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PhoneEntity phone1 = new PhoneEntity();
        phone1.setModelName("G1");
        phone1.setPrice(1000L);
        phone1.setVendor("Gigabyte");
        session.persist(phone1);
        transaction.commit();
        session.close();
    }
}
