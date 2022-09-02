package br.com.cd2.client;

import br.com.cd2.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface EnderecoClient {

    @GetMapping("/{cep}/json")
    EnderecoResponse getEndereco(@PathVariable String cep);
}


