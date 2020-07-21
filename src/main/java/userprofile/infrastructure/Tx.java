package userprofile.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Tx {

 private String dbUri;
 private String user;
 private String pwd;

 public Tx(String uri, String user, String pwd) {
  this.dbUri = uri;
  this.user = user;
  this.pwd = pwd;
 }

 public <R> R execute(
   java.util.function.Function<DSLContext, R> codeBlock) {
  Connection c = getConnection();
  try {
   c.setAutoCommit(false);
   DSLContext create = DSL.using(c, SQLDialect.DERBY);
   R result = codeBlock.apply(create);
   c.commit();

   return result;
  } catch (Exception e) {
   try {
    c.rollback();
    throw new RuntimeException(e);
   } catch (SQLException s) {
    throw new RuntimeException(s);
   }
  } finally {
   try {
    c.setAutoCommit(true);
    c.close();
   } catch (SQLException s) {
    throw new RuntimeException(s);
   }
  }

 }

 private Connection getConnection() {
  try {
   Connection connection = DriverManager.getConnection(this.dbUri,
     this.user, this.pwd);

   return connection;
  } catch (Exception ex) {
   throw new RuntimeException(ex);
  }
 }

}
