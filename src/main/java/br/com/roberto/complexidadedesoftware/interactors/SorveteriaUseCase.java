package br.com.roberto.complexidadedesoftware.interactors;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SorveteriaUseCase {

    public BigDecimal getPrecoSorvete(Boolean ePremium, Boolean temCasquinha, Integer qtasCoberturas){

        int preco = 0;
        if(Boolean.TRUE.equals(ePremium)){
            preco = 20;
            if(Boolean.TRUE.equals(temCasquinha)){
                preco = preco + 2;
                if (qtasCoberturas > 1){
                    preco = preco + 2;
                }else{
                    preco = preco + 1;
                }
            }else{
                preco = preco + 1;
            }
        }else{
            preco = 15 + 1 + 1; //copo + 1cob
        }
        return new BigDecimal(preco);
    }
}
