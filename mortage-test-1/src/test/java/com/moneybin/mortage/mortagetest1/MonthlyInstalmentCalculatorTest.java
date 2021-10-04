package com.moneybin.mortage.mortagetest1;

import com.moneybin.mortage.mortagetest1.service.MonthlyInstalmentCalculator;
import com.moneybin.mortage.mortagetest1.service.MonthlyInstalmentCalculatorImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class MonthlyInstalmentCalculatorTest {

	private MonthlyInstalmentCalculator monthlyInstalmentCalculator;

	@Before
	public void setUp() {
		monthlyInstalmentCalculator = new MonthlyInstalmentCalculatorImpl();
	}

	@Test
	public void shouldCalculateMonthlyInstalment() {
		final String fileContent = "John,100000,10,5";
		Optional<String> message = monthlyInstalmentCalculator.calculate(fileContent);
		assertTrue(message.isPresent());
		assertEquals("John wants to borrow 100000.0 € for a period of 5 years and pay 2124.7044711268336 € each month", message.get());
	}

	@Test
	public void shouldCalculateMonthlyInstalmentWhenNameHasCommaDelimiter() {
		final String fileContent = "\"Johny, Walker\",1000,10,3";
		Optional<String> message = monthlyInstalmentCalculator.calculate(fileContent);
		assertTrue(message.isPresent());
		assertEquals("\"Johny, Walker\" wants to borrow 1000.0 € for a period of 3 years and pay 32.26718719383759 € each month", message.get());
	}

	@Test
	public void shouldCalculateMonthlyInstalmentWhenMoreThanExpectedNumberOfInputProvided() {
		final String fileContent = "Johny,5000,10,7,random,craps";
		Optional<String> message = monthlyInstalmentCalculator.calculate(fileContent);
		assertTrue(message.isPresent());
		assertEquals("Johny wants to borrow 5000.0 € for a period of 7 years and pay 83.00592013442976 € each month", message.get());
	}

	@Test
	public void shouldNotCalculateMonthlyInstalmentWhenNotEnoughInformationProvided() {
		final String fileContent = "Johny,1000,10";
		Optional<String> message = monthlyInstalmentCalculator.calculate(fileContent);
		assertFalse(message.isPresent());
	}

	@Test
	public void shouldNotCalculateMonthlyInstalmentForInvalidInput() {
		final String fileContent = "Johny,1000,10,5years";
		Optional<String> message = monthlyInstalmentCalculator.calculate(fileContent);
		assertFalse(message.isPresent());
	}

}
