package org.Clumsy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by slow_time on 2017/7/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class SimilarCasesServiceTest {
    @Autowired
    SimilarCaseService similarCaseService;

    @Test
    public void testRecommendCases() throws Exception{
//        596b2dbc39e14e6ddb1bb09b
//        System.out.println(similarCaseService.recommendCases("596b2dbc39e14e6ddb1bb09a"));
    }
}
