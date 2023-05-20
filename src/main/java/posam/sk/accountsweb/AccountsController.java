package posam.sk.accountsweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import posam.sk.accountsweb.domain.Account;

@Controller
public class AccountsController {

	@Autowired
    private IntegrationProperties integrationProperties;

	@GetMapping("/accounts")
	public String accounts(Model model) {
		String uri = integrationProperties.getBackend() + "/usersall";
        RestTemplate restTemplate = new RestTemplate();     
        ResponseEntity<List<Account>> accountsResponse =
            restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>() {
                });     
        List<Account> accounts = accountsResponse.getBody();

        System.out.println("Users: " + accounts);
		model.addAttribute("accounts", accounts);

		return "accounts";
	}

	@GetMapping("/account")
	public String account(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
		String uri = integrationProperties.getBackend() + "/userbyid/" + id;
	    RestTemplate restTemplate = new RestTemplate();
	    
	    Account account = restTemplate.getForObject(uri, Account.class);
		model.addAttribute("id", account.getId());
		model.addAttribute("firstName", account.getFirstName());
		model.addAttribute("lastName", account.getLastName());
		model.addAttribute("email", account.getEmail());
		return "account";
	}

}

