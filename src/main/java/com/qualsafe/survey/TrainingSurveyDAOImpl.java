package com.qualsafe.survey;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * User: ssmithstone
 * Date: Aug 5, 2010
 * Time: 7:31:49 PM
 */
public class TrainingSurveyDAOImpl extends HibernateTemplate implements TrainingSurveyDAO {

    public void save(TrainingSurvey trainingSurvey) {
        super.save(trainingSurvey);    
    }

    public TrainingSurvey load(long id) {
        return super.get(TrainingSurvey.class , id);
    }
}
