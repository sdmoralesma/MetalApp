package com.metal.webservice.test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metal.model.Participant;
import com.metal.model.Song;
import com.metal.webservice.Statistics;
import com.metal.webservice.StatisticsWs;

public class StatisticsIT {

	private static Endpoint endpoint;
	private static URL wsdlDocumentLocation;
	private static QName serviceQN;
	private static QName portQN;

	@BeforeClass
	public static void setUp() throws MalformedURLException {
		endpoint = Endpoint.publish("http://localhost:8080/Statistics", new Statistics());
		assertTrue(endpoint.isPublished());
		assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

		wsdlDocumentLocation = new URL("http://localhost:8080/StatisticsService/Statistics?wsdl");
		String namespaceURI = "http://webservice.metal.com/";
		String serviceName = "StatisticsService";
		String portName = "StatisticsPort";
		serviceQN = new QName(namespaceURI, serviceName);
		portQN = new QName(namespaceURI, portName);
	}

	@AfterClass
	public static void tearDown() {
		endpoint.stop();
		assertFalse(endpoint.isPublished());
	}

	@Test
	public void testGetCadena() {
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		StatisticsWs statisticsWs = service.getPort(portQN, StatisticsWs.class);
		String cadena = statisticsWs.getCadena();
		assertEquals("Invalid String", "TEST", cadena);
	}

	@Test
	public void testGetRatingParticipants() {
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		StatisticsWs statisticsWs = service.getPort(portQN, StatisticsWs.class);

		List<Participant> participants = statisticsWs.getRatingParticipants();
		assertTrue("Invalid resultList", participants.size() > 0);
	}

	@Test
	public void testGetRatingSongs() {
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		StatisticsWs statisticsWs = service.getPort(portQN, StatisticsWs.class);

		List<Song> songs = statisticsWs.getRatingSongs();
		assertTrue("Invalid resultList", songs.size() > 0);
	}

	@Test
	public void testGetRatingPerParticipant() {
		Service service = Service.create(wsdlDocumentLocation, serviceQN);
		StatisticsWs statisticsWs = service.getPort(portQN, StatisticsWs.class);

		Participant participant = statisticsWs.getRatingPerParticipant(new Participant("pepe1", "participant", "", 30,
				"", "", "", ""));
		assertTrue("Participant does Not exists", participant.getName().equalsIgnoreCase("pepe1"));
	}

}
