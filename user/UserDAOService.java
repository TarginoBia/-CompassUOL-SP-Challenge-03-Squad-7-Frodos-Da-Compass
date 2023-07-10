package br.com.compassuol.pb.challenge.products.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Maria","Beatriz","maria123@gmail.com","010203"));
		users.add(new User(++usersCount, "Maria","Fernanda","fernanda456@gmail.com","040506"));
		users.add(new User(++usersCount, "Joao","Silva","joao789@gmail.com","070809"));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(long id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().get();
	}
}
