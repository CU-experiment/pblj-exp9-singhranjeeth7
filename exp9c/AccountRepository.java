package repository;

import entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AccountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findById(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void update(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }
}