package com.headbanging.webservice;

import com.headbanging.boundary.AdminBean;
import com.headbanging.boundary.JuryBean;
import com.headbanging.entity.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class StatisticsIT {

    @Inject
    Statistics statistics;
    @Inject
    AdminBean bean;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(StatisticsWs.class, Statistics.class)
                .addClasses(AdminBean.class, Admin.class, Jury.class, Participant.class, Song.class, Gender.class,
                        Artist.class).addClasses(JuryBean.class, SongMatrix.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void shouldGetRatingParticipants() {
        Assert.assertEquals("hey", statistics.getRatingParticipants());
    }

    @Test
    public void shouldGetStringTest() {
        Assert.assertEquals("This is a Test", statistics.getStringTest());
    }
}
