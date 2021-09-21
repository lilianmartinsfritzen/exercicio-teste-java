package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {
				// <AÇÃO> should <EFEITO> [when <CENÁRIO>]
	@Test		// Criar novo financiamento quando for elegível
	public void createShouldNewFundingWhenEligible() {
		
		// Arrange: instancie os objetos necessários

		// Act: execute as ações necessárias
		Financing financ = new Financing(100000.0, 5000.0, 32);
		
		// Assert: declare o que deveria acontecer (resultado esperado)
		Assertions.assertEquals(100000.0, financ.getTotalAmount());
		Assertions.assertEquals(5000.0, financ.getIncome());
		Assertions.assertEquals(32, financ.getMonths());
	}
	
	@Test
	public void createShouldThrowIllegalArgumentExceptionIneligible() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			Financing financ = new Financing(100000.0, 2000.0, 32);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateValueWhenDataIsValid() {

		Financing financ = new Financing(100000.0, 5000.0, 32);
		
		financ.setTotalAmount(90000.0);
		
		Assertions.assertEquals(90000.0, financ.getTotalAmount());
	}
}