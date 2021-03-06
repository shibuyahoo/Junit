package com.example.service;

import com.example.exception.InvalidArgumentException;
import com.example.model.ToDo;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CalculatorTest {
	@Test
	public void compareDatesTestWhenSecondDateLarger() throws InvalidArgumentException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2021-02-01");
		Date date2 = sdf.parse("2021-03-04");
		Calculator calculator = new Calculator();
		int result = calculator.compareDates(date1, date2);
		assertEquals(-1, result); // -1 , if date2 is larger

	}

	@Test
	public void compareDatesBothDateEqualTest() throws InvalidArgumentException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2021-02-01");
		Date date2 = sdf.parse("2021-02-01");
		Calculator calculator = new Calculator();
		int result = calculator.compareDates(date1, date2);
		assertEquals(0, result); // date 1 equals date 2

	}

	@Test
	public void compareDatesDate1IsLarger() throws InvalidArgumentException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2021-02-03");
		Date date2 = sdf.parse("2021-02-01");
		Calculator calculator = new Calculator();
		int result = calculator.compareDates(date1, date2);
		assertEquals(1, result); // date 1 greater than date2

	}

	@Test
	public void compareDatesWhenArgISNull() throws InvalidArgumentException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = sdf.parse("2021-02-01");
		Calculator calculator = new Calculator();
		try {
			calculator.compareDates(date1, date2);

		} catch (InvalidArgumentException ex) {

			assertEquals("Arguments cannot be null", ex.getMessage());

		}

	}
	
	//Testing exceptions with Junit5 it was @test(expected=InvalidArgumentException.class) in junit4
	@Test
	public void exceptionTesting() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = sdf.parse("2021-02-01");
		Calculator calculator = new Calculator();
		InvalidArgumentException thrown = assertThrows(
				InvalidArgumentException.class,
	           () -> calculator.compareDates(date1, date2),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("Arguments cannot be null"));
	}
	
	@Test
	public void exceptionTestingWithBothNull() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = null;
		Calculator calculator = new Calculator();
		InvalidArgumentException thrown = assertThrows(
				InvalidArgumentException.class,
	           () -> calculator.compareDates(date1, date2),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("Arguments cannot be null"));
	}
	
	@Test
	public void exceptionTestingWithSecondNull() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2021-02-01");
		Date date2 = null;
		Calculator calculator = new Calculator();
		InvalidArgumentException thrown = assertThrows(
				InvalidArgumentException.class,
	           () -> calculator.compareDates(date1, date2),
	           "Expected doThing() to throw, but it didn't"
	    );
	    assertTrue(thrown.getMessage().contains("Arguments cannot be null"));
	}

	}
