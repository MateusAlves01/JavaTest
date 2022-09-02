package br.com.cd2.service;

import br.com.cd2.entity.Frete;
import br.com.cd2.request.FreteRequest;
import br.com.cd2.response.FreteResponse;

public interface FreteService {
    FreteResponse calcularFrete(FreteRequest freteRequest);

}
