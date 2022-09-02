package br.com.cd2.service.impl;

import br.com.cd2.request.FreteRequest;
import br.com.cd2.response.FreteResponse;
import br.com.cd2.service.FreteService;
import org.springframework.stereotype.Service;

@Service
public class FreteServiceImpl implements FreteService {

    @Override
    public FreteResponse calcularFrete(FreteRequest freteRequest) {
        //TODO buscar endereço

        //TODO Calcular Frete

        //TODO Gravar no banco

        //TODO Retornar frete calculado
        return null;
    }

}
