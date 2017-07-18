package org.Clumsy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by slow_time on 2017/7/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class CaseServiceTest {

    @Autowired
    private CaseService caseService;


    @Test
    public void testGetAllCases() throws Exception {
        System.out.println(caseService.getAllCases().size());
    }

    @Test
    public void testCaseInfoByCaseNumber() throws Exception {
        System.out.println(caseService.getCaseInfoByCaseNumber("（2007）红民一初字第645号"));
    }


    @Test
    public void testGetCasesByCause() throws Exception {
        System.out.println(caseService.getCasesByCause("分家析产纠纷").size());
    }


    @Test
    public void testGetAllCauses() throws Exception {
        Set<String> causes = (caseService.getAllCauses().keySet());
        for (String cause : causes) {
            System.out.println(cause + caseService.getAllCauses().get(cause));
        }
    }


}