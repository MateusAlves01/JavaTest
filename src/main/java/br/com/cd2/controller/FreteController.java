package br.com.cd2.controller;

import br.com.cd2.exception.EnderecoBadRequestException;
import br.com.cd2.request.FreteRequest;
import br.com.cd2.response.FreteResponse;
import br.com.cd2.service.FreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("frete")
@RequiredArgsConstructor
public class FreteController {

    private final FreteService freteService;

    @PostMapping
    @Validated
    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler(EnderecoBadRequestException.class)
    public FreteResponse calcularFrete(@RequestBody @Valid FreteRequest freteRequest) {
        return freteService.calcularFrete(freteRequest);
    }

}
