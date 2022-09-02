package br.com.cd2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "frete")
public class Frete {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "cep_origem")
        private String cepOrigem;

        @Column(name = "cep_destino")
        private String cepDestino;

        @Column(name = "nome_destinatario")
        private String nomeDestinatario;

        @Column(name = "valor_total_frete")
        private BigDecimal vlTotalFrete;

        @Column(name = "data_prevista_entrega")
        private LocalDate dataPrevistaEntrega;

        private BigDecimal peso;

        @Column(name = "data_consulta")
        private LocalDate dataConsulta;
}

