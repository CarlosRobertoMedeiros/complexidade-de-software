package br.com.roberto.complexidadedesoftware.interactors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class SorveteriaUseCaseTest {
    private SorveteriaUseCase sorveteriaUseCase;
    private Boolean VALOR_NULO_BOLEANO_PARA_OBJETO = null;

    @BeforeEach
    void setup(){
        sorveteriaUseCase = new SorveteriaUseCase();
    }
    @Test
    void deveDarErroAoNaoInformarSeOSorveteEPremioOuNao(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            sorveteriaUseCase.getPrecoSorvete(Boolean.valueOf(VALOR_NULO_BOLEANO_PARA_OBJETO),false,0);
        });
    }

    void deveDarErroAoNaoInformarSeOSorveteTemOuNaoCasquinha(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            sorveteriaUseCase.getPrecoSorvete(true,VALOR_NULO_BOLEANO_PARA_OBJETO,0);
        });
    }

    void deveDarErroAoNaoInformarSeOSorveteNaoTemCobertura(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            sorveteriaUseCase.getPrecoSorvete(true,false,null);
        });
    }

    @Test
    void deveRetornarOValorDeUmSorveteSimplesSemCasquinhaSemCobertura() {
        Assertions.assertEquals(new BigDecimal(17), sorveteriaUseCase.getPrecoSorvete(false,false,0));
    }

    @Test
    void deveRetornarOValorDeUmSorvetePremiumSemCasquinhaSemCobertura() {
        Assertions.assertEquals(new BigDecimal(21),sorveteriaUseCase.getPrecoSorvete(true,false,0));
    }

    @Test
    void deveRetornarOValorDeUmSorvetePremiumComCasquinhaSemCobertura() {
        Assertions.assertEquals(new BigDecimal(23),sorveteriaUseCase.getPrecoSorvete(true,true,0));
    }

    @Test
    void deveRetornarOValorDeUmSorvetePremiumComCasquinhaComUmaCobertura() {
        Assertions.assertEquals(new BigDecimal(23),sorveteriaUseCase.getPrecoSorvete(true,true,1));
    }

    @Test
    void deveRetornarOValorDeUmSorvetePremiumComCasquinhaAcimaDeUmaCobertura() {
        Assertions.assertEquals(new BigDecimal(24),sorveteriaUseCase.getPrecoSorvete(true,true,2));
        Assertions.assertEquals(new BigDecimal(24),sorveteriaUseCase.getPrecoSorvete(true,true,3));
    }

}