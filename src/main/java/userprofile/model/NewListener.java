package userprofile.model;

import java.util.Map;

import com.google.gson.Gson;

public class NewListener {

 private static final String EMAIL = "email";
 private static final String ID_LISTENER = "idListener";
 private int idListener;
 private String email;

 public NewListener(int idListener, String email) {
  this.idListener = idListener;
  this.email = email;
 }

 public String toJson() {
  return new Gson()
    .toJson(Map.of(ID_LISTENER, idListener, EMAIL, this.email));
 }
}
