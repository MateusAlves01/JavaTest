package br.com.cd2.controller;

import br.com.cd2.request.FreteRequest;
import br.com.cd2.response.FreteResponse;
import br.com.cd2.service.FreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("frete")
@RequiredArgsConstructor
public class FreteController {

    private final FreteService freteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FreteResponse calcularFrete(@RequestBody FreteRequest freteRequest) {
        return freteService.calcularFrete(freteRequest);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public FreteResponse getFrete() {
//        return freteService.getFrete();
//
//    }
}
