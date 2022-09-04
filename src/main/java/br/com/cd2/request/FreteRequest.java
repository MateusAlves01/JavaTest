package br.com.cd2.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreteRequest {

    @NotNull
    private BigDecimal peso;

    @NotBlank
    private String cepOrigem;

    @NotBlank(message = "Campo cep destino obrigatório.")
    private String cepDestino;

    @NotBlank(message = "Campo nome destinatario obrigatório.")
    private String nomeDestinatario;

}
