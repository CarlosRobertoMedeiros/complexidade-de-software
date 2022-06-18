package br.com.roberto.complexidadedesoftware.transportlayer.restapi;

import br.com.roberto.complexidadedesoftware.interactors.SorveteriaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/sorveteria")
public class SorveteriaRest {

    private final SorveteriaUseCase sorveteriaUseCase;

    public SorveteriaRest(SorveteriaUseCase sorveteriaUseCase) {
        this.sorveteriaUseCase = sorveteriaUseCase;
    }

    @GetMapping()
    public ResponseEntity<BigDecimal> getPrecoSorvete(@RequestParam(name = "ePremium", required = true) Boolean ePremium,
                                                      @RequestParam(name = "temCasquinha", required = true) Boolean temCasquinha,
                                                      @RequestParam(name = "qtasCoberturas", required = true) Integer qtasCoberturas) {

        BigDecimal valorSorvete = sorveteriaUseCase.getPrecoSorvete(ePremium, temCasquinha, qtasCoberturas);
        return ResponseEntity.ok().body(valorSorvete);
    }

}
