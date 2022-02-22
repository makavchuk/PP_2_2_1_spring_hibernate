package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Audi", 8888)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 424322)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> allUsers = userService.listUsers();

      for (User user : allUsers) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      User carOwner = userService.findUserByCarParameters("Audi", 8888);

      if (carOwner != null) {
         System.out.println("*** Car owner:");
         System.out.println("Id = " + carOwner.getId());
         System.out.println("First Name = " + carOwner.getFirstName());
         System.out.println("Last Name = " + carOwner.getLastName());
         System.out.println("Email = " + carOwner.getEmail());
         System.out.println("Car = " + carOwner.getCar());
         System.out.println();
      }

      context.close();
   }
}
