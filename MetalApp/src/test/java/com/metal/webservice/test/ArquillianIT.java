package com.metal.webservice.test;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.metal.service.AdminBean;
import com.metal.webservice.Statistics;

@RunWith(Arquillian.class)
public class ArquillianIT {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Statistics.class).addClass(AdminBean.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	Statistics statistics;

//	@EJB
//	AdminBean adminBean;

	@Test
	public void shouldPrintCadena() {
		Assert.assertEquals("Hello, Earthling!", statistics.getCadena());
	}

//	@Test
//	public void sholdGetSongList() {
//		Assert.assertEquals("hey", adminBean.songList().get(0).getTitle());
//	}
}
