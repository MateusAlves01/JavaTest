package br.com.cd2.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnderecoResponse {

        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade;
        private String complemento;
        private String uf;
        private String ddd;

}
