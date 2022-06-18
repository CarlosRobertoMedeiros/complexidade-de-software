package br.com.roberto.complexidadedesoftware.interactors;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SorveteriaUseCaseRefatoracao1 {

    private static final int VALOR_COPO = 1;
    private static final int VALOR_CASQUINHA = 2;
    private static final int VALOR_SORVETE_NORMAL = 15;
    private static final int VALOR_SORVETE_PREMIO = 20;
    private static final int VALOR_POR_COBERTURA_NORMAL = 1;

    public BigDecimal getPrecoSorvete(boolean ePremium, boolean temCasquinha, Integer qtasCoberturas){

        if (!ePremium) return this.valorSorveteNormal(qtasCoberturas);
        int preco = VALOR_SORVETE_PREMIO;
        if(temCasquinha) preco += VALOR_CASQUINHA;
        preco += precoDaCobertura(qtasCoberturas);
        return new BigDecimal(preco);
    }

    private BigDecimal valorSorveteNormal(Integer qtdeCobertura){
        return new BigDecimal(VALOR_SORVETE_NORMAL +
                                  VALOR_COPO +
                                  VALOR_POR_COBERTURA_NORMAL * qtdeCobertura);
    }
    private int precoDaCobertura(Integer qtdeCobertura){
        return (qtdeCobertura>1)? 2 : VALOR_POR_COBERTURA_NORMAL;
    }

}
