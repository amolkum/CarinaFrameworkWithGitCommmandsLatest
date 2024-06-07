package utils;

public interface UserMapper1 {

	void create(User customer);

	User findById(long id);

	User findByUserName(String username);

	void update(User customer);

	void delete(User customer);
}
