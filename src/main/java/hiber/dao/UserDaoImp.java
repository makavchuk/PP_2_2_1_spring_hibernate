package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
   public User findUserByCarParameters(String model, int series) {
      TypedQuery<Car> query = sessionFactory.getCurrentSession()
              .createQuery("from Car as c where c.model = :model and c.series = :series");

      query.setParameter("model", model);
      query.setParameter("series", series);

      List<Car> resultList = query.getResultList();

      if (resultList.size() > 0) {
         return resultList.get(0).getUser();
      } else {
         return null;
      }
   }
}
