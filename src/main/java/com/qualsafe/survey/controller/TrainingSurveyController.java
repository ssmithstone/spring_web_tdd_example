package com.qualsafe.survey.controller;

import com.qualsafe.survey.TrainingSurvey;
import com.qualsafe.survey.TrainingSurveyDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: ssmithstone
 * Date: Aug 6, 2010
 * Time: 8:34:02 AM
 */
@Controller
@RequestMapping("/submit_training_survey.html")
class TrainingSurveyController {

    private TrainingSurveyDAO dao;

    @RequestMapping(method = RequestMethod.POST)
    public void handlePost(HttpServletRequest request , HttpServletResponse response) {

        this.dao.save(new TrainingSurvey());
    }

    public void setDAO(TrainingSurveyDAO dao) {
        this.dao = dao;
    }
}
