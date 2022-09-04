package br.com.cd2.service.impl;

import br.com.cd2.client.EnderecoClient;
import br.com.cd2.exception.EnderecoBadRequestException;
import br.com.cd2.exception.EnderecoNotFoundException;
import br.com.cd2.response.EnderecoResponse;
import br.com.cd2.service.EnderecoService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoClient enderecoClient;

    public EnderecoResponse getEndereco(String cep) {
        try {
            final EnderecoResponse enderecoResponse = enderecoClient.getEndereco(cep);
            if (ObjectUtils.isEmpty(enderecoResponse) || enderecoResponse.getCep() == null) {
                throw new EnderecoNotFoundException(cep);
            }
            return enderecoResponse;
        } catch (FeignException.BadRequest badRequest) {
            log.error("error: " + badRequest.getMessage());
            throw new EnderecoBadRequestException(cep);
        }
    }
}