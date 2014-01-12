package test.service;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import service.SimpleService;
import service.SimpleService2;

@RunWith(MockitoJUnitRunner.class)
public class SimpleServiceTestCase {

	@Mock
	private SimpleService2 simpleService2;

	@InjectMocks
	private SimpleService simpleService = new SimpleService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("I'm BeforeClass.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("I'm AfterClass.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("I'm Before.");
		// MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("I'm After.");
	}

	@Test
	public void testGeneratePrefix() {
		String content = "Peter";
		String prefix = "Hayley";
		String assertion = "Hayley*Peter";
		String result = simpleService.generatePrefix(prefix, content);
		Assert.assertEquals(assertion, result);
	}

	@Test(expected = NullPointerException.class)
	public void testGeneratePrefixException() {
		simpleService.generatePrefix(null, null);
	}

	@Test
	public void testAddTenNoMock() {
		simpleService.setSimpleService2(new SimpleService2());
		int originalNum = 10;
		int result = simpleService.addTen(originalNum);
		Assert.assertEquals(20, result);
	}
	
	@Test
	public void testAddTen() {
		int originalNum = 10;
		Mockito.when(simpleService2.addFour(Mockito.anyInt())).thenReturn(10);
		int result = simpleService.addTen(originalNum);
		Assert.assertEquals(16, result);
	}
}
