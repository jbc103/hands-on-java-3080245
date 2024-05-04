package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  public static Customer login(String username, String password) throws LoginException{
    
    Customer customer = DataSource.getCustomer(username);
    if (customer == null){
      throw new LoginException("Username not found");
    }

 //   if (password.equals(customer.getPassword())){
      customer.setAuthenticated(true);
      return customer;
 //   }
   // else throw new LoginException("Incorrect Password");
  }

  public static void logout(Customer customer){
    customer.setAuthenticated(false);
  }

  public static void jbc(String[] args) {
    System.out.println("Welcome to Globe Bank International!");
    try{
      Customer customer = login("akayne4c@japanpost.jp","pass");
      System.out.println(customer.getName());
    }catch(LoginException e)
    {
    System.out.println("There was an error: " + e.getMessage());
    }

  }

}
