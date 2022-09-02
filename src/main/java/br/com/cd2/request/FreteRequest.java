package br.com.cd2.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreteRequest {

     private BigDecimal peso;
     private String cepOrigem;
     private String cepDestino;
     private String nomeDestinatario;

}
