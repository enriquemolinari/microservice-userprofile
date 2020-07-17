package userprofile.model.api;

import userprofile.model.RadioException;

public interface UserAuth {
 String authenticate(String user, String password) throws RadioException;
 void validate(String token) throws RadioException;
}
