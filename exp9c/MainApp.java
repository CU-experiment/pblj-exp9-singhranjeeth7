import config.AppConfig;
import entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import service.BankingService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankingService bankingService = context.getBean(BankingService.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        // Add two accounts for demo if needed
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Account("Alice", 1000));
        session.save(new Account("Bob", 500));

        tx.commit();
        session.close();

        // Perform transfer
        try {
            bankingService.transferMoney(1, 2, 200);
        } catch (Exception e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }

        context.close();
    }
}