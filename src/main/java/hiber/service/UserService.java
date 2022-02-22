package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User findUserByCarParameters(String model, int series);
}
