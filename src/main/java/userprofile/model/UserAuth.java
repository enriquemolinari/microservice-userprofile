package userprofile.model;

public interface UserAuth {
 String authenticate(String user, String password) throws RadioException;
 void validate(String token) throws RadioException;
}
