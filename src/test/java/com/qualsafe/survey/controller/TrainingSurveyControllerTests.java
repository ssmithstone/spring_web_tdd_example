package com.qualsafe.survey.controller;

import com.qualsafe.survey.TrainingSurvey;
import com.qualsafe.survey.TrainingSurveyDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * User: ssmithstone
 * Date: Aug 6, 2010
 * Time: 7:45:46 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans-context.xml"})
public class TrainingSurveyControllerTests {

    private HandlerAdapter handlerAdapter;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private TrainingSurveyController controller;
    private TrainingSurveyDAO dao;

    @Before
    public void setUp(){
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        controller = new TrainingSurveyController();
        dao = Mockito.mock(TrainingSurveyDAO.class);
        controller.setDAO(dao);
    }

    @Test
    public void weCanHandlePostsCorrectly() throws Exception {

        request.setMethod("POST");
        request.setRequestURI("/submit_training_survey.html");
        request.setParameter("name" , "Stephen Smithstone");
        handlerAdapter.handle(request, response, controller);
        Mockito.verify(dao).save(Mockito.any(TrainingSurvey.class));
    }

}


