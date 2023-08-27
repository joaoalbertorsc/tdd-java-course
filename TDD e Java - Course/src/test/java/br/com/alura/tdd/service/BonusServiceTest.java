package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    private BonusService bonusService;
    @BeforeEach
    public void inicializar(){
        this.bonusService = new BonusService();
    }

    @Test
    void bonusDeveSerZeroParaSalarioMuitoAlto(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
        assertEquals(new BigDecimal("0.00"), bonus);

    }

    @Test
    void bonusDeveriaSer10porCentoDoSalario(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    void bonusDeveriaSer10porCentoParaExatamente100000(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);

    }

}