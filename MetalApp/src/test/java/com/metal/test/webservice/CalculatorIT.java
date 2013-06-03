package com.metal.test.webservice;

import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.metal.webservice.Calculator;
import com.metal.webservice.CalculatorWs;

@RunWith(Arquillian.class)
public class CalculatorIT {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClasses(Calculator.class, CalculatorWs.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	CalculatorWs calculator;

	@Test
	public void shouldCheckSum() throws MalformedURLException {
		int a = 1;
		int b = 2;
		assertEquals("Sum must be valid", 3, calculator.sum(a, b));
	}

	@Test
	public void shouldCheckMultiply() {
		int a = 1;
		int b = 2;
		assertEquals("Multiply must be valid", 2, calculator.multiply(a, b));
	}
}