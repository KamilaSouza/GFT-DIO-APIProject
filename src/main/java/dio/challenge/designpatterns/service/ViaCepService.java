package dio.challenge.designpatterns.service;

import dio.challenge.designpatterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Http client created to consume ViaCep api.


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {


  //  @GetMapping ("/{cep}/json/")  -  alternative
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);
}
