package com.sabaleuski;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.Parser;

import javax.management.modelmbean.XMLParseException;
import java.util.List;

public class TestRunner {

    private static final Logger LOGGER = LogManager.getLogger(TestRunner.class);

    public static void runTests(String testngXmlPath, List<Class> listeners) throws XMLParseException{
        List<XmlSuite> xmlSuiteList;
        TestNG testNG = new TestNG();

        testNG.setUseDefaultListeners(false);
        testNG.setListenerClasses(listeners);
        Parser parser = new Parser(testngXmlPath);
        try{
            xmlSuiteList = parser.parseToList();
        }
        catch (Exception e){
            LOGGER.error(e.getMessage());
            throw new XMLParseException(e.getMessage());
        }
        testNG.setXmlSuites(xmlSuiteList);
        testNG.run();
    }
}
