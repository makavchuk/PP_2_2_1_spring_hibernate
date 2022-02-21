package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
      public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> listUsersByCar(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("select u from User as u left join Car as c on u.car = c.id where c.model = :model and c.series = :series");

      query.setParameter("model", model);
      query.setParameter("series", series);

      return query.getResultList();
   }
}
