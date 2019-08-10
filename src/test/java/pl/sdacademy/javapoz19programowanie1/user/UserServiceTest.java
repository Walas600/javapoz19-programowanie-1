package pl.sdacademy.javapoz19programowanie1.user;

import org.junit.Assert;
import org.junit.Test;
import pl.sdacademy.javapoz11programowanie1.user.Gender;
import pl.sdacademy.javapoz11programowanie1.user.User;
import pl.sdacademy.javapoz11programowanie1.user.UserService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UserServiceTest {

    @Test
    public void findByGenderShouldReturnFillteredList(){
         UserService userService = new UserService();

        List<User> list = userService.findByGender(Gender.female);

        Assert.assertEquals("lista powinna zawierać 3 elementy", 3, list.size());

        Assert.assertTrue("Wszystkie elementy powinny mieć wartość female", list.stream()
        .map(user -> user.getGender())
                .allMatch(gender -> gender.equals(Gender.female)));

    }
    @Test
    public void mapToNameShouldReturnListWithNames(){
        UserService userService = new UserService();
        List<String> names = userService.mapToNames();

        Assert.assertEquals(Arrays.asList("Bird Ramsey",
                "Lillian Burgess",
                "Kristie Cole",
                "Leonor Cross",
                "Marsh Mccall"), names);

    }

    @Test
    public void sortByAgeSchouldReturnSortedByAgeListIfUsers(){
        UserService userService = new UserService();
        List<User> users = userService.sortByAge();

        users.forEach(user -> System.out.println(user));

    }

    @Test
    public void sortByBalanceShouldReturnSortedBybalanceListOfUsers(){
        UserService userService = new UserService();
        List<User> users = userService.sortByBalance();

        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void avgBalanceShouldReturnAvgValue(){
        UserService userService = new UserService();
        double avgBalance = userService.avgBalance();

        Assert.assertEquals(290318.2, avgBalance, 0.1);
    }

    @Test
    public void findWithHighestBalanceShouldReturnUserWithHigherBalance(){
        UserService userService = new UserService();
        User withHigherBalance = userService.findWithHighestBalance();

        Assert.assertEquals(Long.valueOf(394645), withHigherBalance.getBalance());
    }
}
