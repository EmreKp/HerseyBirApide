package com.emrekp.herseybirapide.Controller;

import com.emrekp.herseybirapide.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GorenController {
    private RestTemplate restTemplate;

    @Autowired
    public GorenController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/merhaba")
    public String hosgel(Model model, @RequestParam(value = "coin", required = false) String coin) {
        Response response = restTemplate.getForObject("http://localhost:8080/", Response.class);
        //acaba kendi API'ımızdan mı erişmek doğru yoksa direk servisten mi
        //bi de üste localhost yazıp almak ne kadar doğrudur
        Integer istanbul = response.getIstanbul();
        Integer crypto = response.getBitcoin();
        if (coin.equalsIgnoreCase("ethereum")) {
            crypto = response.getEthereum();
        }
        model.addAttribute("istanbul",istanbul);
        model.addAttribute("coin",crypto);
        return "hosgeldin";
        //TODO ayarla burayı sonradan
    }

    @RequestMapping("/coinler")
    public String coinView(Model model) {
        Response response = restTemplate.getForObject("http://localhost:8080/", Response.class);
        Integer bitcoin = response.getBitcoin();
        Integer ether = response.getEthereum();
        model.addAttribute("bitcoin",bitcoin);
        model.addAttribute("ethereum",ether);
        return "coins";
    }
}
