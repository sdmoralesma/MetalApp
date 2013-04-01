package com.metal.webservice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metal.webservice.Calculator;
import com.metal.webservice.CalculatorWs;

public class CalculatorIT {

	private Endpoint endpoint;
	private URL wsdlDocumentLocation;
	private QName serviceQN;
	private QName portQN;

	@Before
	public void setUp() throws MalformedURLException {		
		// Publishes the SOAP Web Service
		endpoint = Endpoint.publish("http://localhost:8080/Calculator", new Calculator());
		assertTrue(endpoint.isPublished());
		assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());
		
		// Data to access the web service
		wsdlDocumentLocation = new URL("http://localhost:8080/CalculatorService/Calculator?wsdl");
		String namespaceURI = "http://webservice.metal.com/";
		String serviceName = "CalculatorService";
		String portName = "CalculatorPort";
		serviceQN = new QName(namespaceURI, serviceName);
		portQN = new QName(namespaceURI, portName);
	}
	
	@After
	public void tearDown() {
		// Unpublishes the SOAP Web Service
		endpoint.stop();
		assertFalse(endpoint.isPublished());
	}
	
	@Test
	public void shouldCheckSumAndMultiply() throws MalformedURLException {
		// Creates a service instance
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		CalculatorWs calculatorWs = service.getPort(portQN, CalculatorWs.class);

		// Invokes the web service
		int a = 1;
		int b = 2;

		assertEquals("Sum must be valid", 3, calculatorWs.sum(a, b));
		assertEquals("Multiply must be valid", 2, calculatorWs.multiply(a, b));
	}
}