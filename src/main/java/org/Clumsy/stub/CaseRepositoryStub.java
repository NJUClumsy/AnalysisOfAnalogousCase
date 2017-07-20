package org.Clumsy.stub;

import org.Clumsy.dao.operations.CaseOperations;
import org.Clumsy.entity.Case;
import org.Clumsy.util.ReadXMLHelper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by green-cherry on 2017/7/20.
 */
public class CaseRepositoryStub implements CaseOperations {
    @Override
    public List<Case> findCauses() {
        List<Case> cases = new ArrayList<>();
        Case c = getCase();

        cases.add(c);
        return cases;
    }

    @Override
    public Case findIdByCaseNumber(String caseNumber) {
        Case c = getCase();
        return c;
    }

    public Case findById(String id) {
        Case c = getCase();
        return c;
    }

    public Case findFirstByCaseNumber(String caseNumber) {
        Case c = getCase();
        return c;
    }

    public List<Case> findAllByCause(String cause) {
        List<Case> cases = new ArrayList<>();
        Case c = getCase();
        cases.add(c);
        return cases;
    }

    public List<Case> findAll() {
        List<Case> cases = new ArrayList<>();
        Case c = getCase();
        cases.add(c);
        return cases;
    }

    public void save(Case c) {

    }

    public static Case getCase() {
        String url1 = "/Users/green-cherry/学习/大二暑期/文书/a.xml";//测试已经存在的文书
        String url2 = "/Users/green-cherry/学习/大二暑期/文书/b.xml";//测试未存在的文书
        Case c = null;
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(url2));
            c= ReadXMLHelper.getCase(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return c;
    }
}
