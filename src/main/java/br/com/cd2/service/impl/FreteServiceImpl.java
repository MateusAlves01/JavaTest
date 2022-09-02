package br.com.cd2.service.impl;

import br.com.cd2.client.EnderecoClient;
import br.com.cd2.request.FreteRequest;
import br.com.cd2.response.EnderecoResponse;
import br.com.cd2.response.FreteResponse;
import br.com.cd2.service.FreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FreteServiceImpl implements FreteService {

    public static final BigDecimal DESCONTO_CIQUENTA = BigDecimal.valueOf(0.5);
    public static final BigDecimal DESCONTO_SETENTA_CINCO = BigDecimal.valueOf(0.75);
    public static final BigDecimal PRECO_KG = BigDecimal.valueOf(1);
    private final EnderecoClient enderecoClient;


    @Override
    public FreteResponse calcularFrete(FreteRequest freteRequest) {
        final EnderecoResponse enderecoOrigem = enderecoClient.getEndereco(freteRequest.getCepOrigem());
        final EnderecoResponse enderecoDestino = enderecoClient.getEndereco(freteRequest.getCepDestino());
        //TODO Calcular Frete
        // CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
        FreteResponse freteResponse = new FreteResponse();
        freteResponse.setCepDestino(freteRequest.getCepDestino());
        freteResponse.setCepOrigem(freteRequest.getCepOrigem());
        BigDecimal valorTotalFrete = BigDecimal.ZERO;
        BigDecimal valorTotalFreteDesconto = BigDecimal.ZERO;

        if (enderecoOrigem.getDdd().equals(enderecoDestino.getDdd())
                && enderecoOrigem.getLocalidade().equals(enderecoDestino.getLocalidade())) {
            valorTotalFrete = freteRequest.getPeso().multiply(PRECO_KG);
            BigDecimal valorDesconto = valorTotalFrete.multiply(DESCONTO_SETENTA_CINCO);
            valorTotalFreteDesconto = valorTotalFrete.subtract(valorDesconto);
            freteResponse.setVlTotalFrete(valorTotalFreteDesconto);
            freteResponse.setDataPrevistaEntrega(LocalDate.now().plusDays(3));
        }

        if (enderecoOrigem.getUf().equals(enderecoDestino.getUf())
                && !enderecoOrigem.getLocalidade().equals(enderecoDestino.getLocalidade())) {
            valorTotalFrete = freteRequest.getPeso().multiply(PRECO_KG);
            BigDecimal valorDesconto = valorTotalFrete.multiply(DESCONTO_CIQUENTA);
            valorTotalFreteDesconto = valorTotalFrete.subtract(valorDesconto);
            freteResponse.setVlTotalFrete(valorTotalFreteDesconto);
            freteResponse.setDataPrevistaEntrega(LocalDate.now().plusDays(1));
        }

        if (!enderecoOrigem.getUf().equals(enderecoDestino.getUf())) {
            valorTotalFrete = freteRequest.getPeso().multiply(PRECO_KG);
            freteResponse.setVlTotalFrete(valorTotalFrete);
            freteResponse.setDataPrevistaEntrega(LocalDate.now().plusDays(10));
        }

        //TODO Gravar no banco

        //TODO Retornar frete calculado
        return freteResponse;
    }

}
