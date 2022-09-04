package br.com.cd2.service;

import br.com.cd2.response.EnderecoResponse;

public interface EnderecoService {
    EnderecoResponse getEndereco(String cep);

}
