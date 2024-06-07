package utils;

public interface UserPreferenceMapper {
	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
