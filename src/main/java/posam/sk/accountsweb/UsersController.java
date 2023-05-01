package posam.sk.accountsweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import posam.sk.accountsweb.domain.Account;

@Controller
public class UsersController {
 
 @RequestMapping("/hello")
 @ResponseBody
 private String hello() {
  return "Hello World";
 }
 
 @RequestMapping("/user1")
 @ResponseBody
 private String getUser() {
  String uri = "http://localhost:8089/accounts/1";
  RestTemplate restTemplate = new RestTemplate();
  
  Account account = restTemplate.getForObject(uri, Account.class);
  System.out.println("User: " + account);
  
  System.out.println("Userid: " + account.getId());
  System.out.println("Name: " + account.getFirstName());
  System.out.println("Username: " + account.getLastName());
  System.out.println("Email: " + account.getEmail());

  return "User detail page.";
 }
}