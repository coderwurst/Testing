package example;

import java.util.ArrayList;
import java.util.List;

/**
 * more advanced as a stub, simplified but none the less real behaviors
 * typically used to simulate DBs
 *
 */

public class FakeUserStore implements UserStore{
	private ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public void store(User user) {
		users.add(user);
	}

	@Override
	public List<User> findAll() {
		return users;
	}

}
