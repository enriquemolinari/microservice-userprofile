package userprofile.web;

public class AuthData {

 private String user;
 private String pwd;
 
 public AuthData() {
  
 }

 public String user() {
  return this.user;
 }

 public String pwd() {
  return this.pwd;
 }

 private String getUser() {
  return user;
 }

 private void setUser(String user) {
  this.user = user;
 }

 private String getPwd() {
  return pwd;
 }

 private void setPwd(String pwd) {
  this.pwd = pwd;
 }
}
