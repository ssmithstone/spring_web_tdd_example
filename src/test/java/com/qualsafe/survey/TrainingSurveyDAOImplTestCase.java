package com.qualsafe.survey;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * User: ssmithstone
 * Date: Aug 5, 2010
 * Time: 7:20:18 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class TrainingSurveyDAOImplTestCase {

    @Autowired
    TrainingSurveyDAO dao;

    @Rollback(true)
    @Test public void weCanStoreSurveys(){

        TrainingSurvey trainingSurvey = new TrainingSurvey();
        dao.save(trainingSurvey);
        assertNotNull(trainingSurvey.getId());
        assertTrue(trainingSurvey.getId() > 0);

    }

    @Rollback(true)
    @Test
    public void weCanLoadUpSurveys(){

        TrainingSurvey trainingSurvey = new TrainingSurvey();
        dao.save(trainingSurvey);
        TrainingSurvey loaded = null;
        loaded = dao.load(trainingSurvey.getId());
        assertNotNull(loaded);

    }


}
