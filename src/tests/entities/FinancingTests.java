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
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenDataIsInvalid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			Financing financ = new Financing(150000.0, 5000.0, 32);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateValueWhenDataIsValid() {

		Financing financ = new Financing(100000.0, 5000.0, 32);
		
		financ.setIncome(7000.0);
		
		Assertions.assertEquals(7000.0, financ.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenDataIsInvalid() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			Financing financ = new Financing(100000.0, 2000.0, 32);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateValueWhenDataIsValid() {

		Financing financ = new Financing(100000.0, 5000.0, 32);
		
		financ.setMonths(50);
		
		Assertions.assertEquals(50, financ.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenDataIsInvalid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			Financing financ = new Financing(100000.0, 5000.0, 12);
		});
	}
	
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		Financing financ = new Financing(100000.0, 5000.0, 32);		
		Assertions.assertEquals(20000.0, financ.entry());
	}
	
	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		Financing financ = new Financing(100000.0, 5000.0, 32);		
		Assertions.assertEquals(2500.0, financ.quota());
	}
}