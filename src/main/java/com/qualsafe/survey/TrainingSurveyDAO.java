package com.qualsafe.survey;

/**
 * User: ssmithstone
 * Date: Aug 5, 2010
 * Time: 8:24:56 PM
 */
public interface TrainingSurveyDAO {
    void save(TrainingSurvey trainingSurvey);

    TrainingSurvey load(long id);
}
