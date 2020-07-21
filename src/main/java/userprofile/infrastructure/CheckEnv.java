package userprofile.infrastructure;

class CheckEnv {
 private String value;

 static final String PWD = "pwd";
 static final String USER = "user";
 static final String CONN_STRING = "conn-string";
 
 public CheckEnv(String value) {
  if (value == null) {
   throw new RuntimeException(
     "UserProfile Module requires these JVM args: conn-string, user, pwd");
  }
  this.value = value;
 }

 public String value() {
  return value;
 }
}