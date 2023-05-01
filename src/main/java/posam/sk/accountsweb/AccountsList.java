// package posam.sk.accountsweb;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.client.RestTemplate;

// import posam.sk.accountsweb.domain.Account;

// @Controller
// public class AccountsList {

//     @Autowired
//     private IntegrationProperties integrationProperties;

//     @RequestMapping("/users")
//     @ResponseBody
//     private String getUser() {

//         String uri = integrationProperties.getBackend() + "/accounts";
//         RestTemplate restTemplate = new RestTemplate();     
//         ResponseEntity<List<Account>> accountsResponse =
//             restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>() {
//                 });     
//         List<Account> accounts = accountsResponse.getBody();

//         System.out.println("Users: " + accounts);
//         accounts.stream().forEach((c) -> System.out.println(c.getId()));
    

//     return "User detail page.";

//     }
	    
    
// }
