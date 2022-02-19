package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      Car rentCar = new Car("Audi", 8888);
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", rentCar));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("BMW", 424322)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", rentCar));


      List<User> allUsers = userService.listUsers();
      for (User user : allUsers) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      List<User> users = userService.listUsersByCar("Audi", 8888);

      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
