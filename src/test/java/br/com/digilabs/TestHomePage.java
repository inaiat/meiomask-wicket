package br.com.digilabs;

import br.com.digilabs.meiomask.examples.HomePage;
import br.com.digilabs.meiomask.examples.WicketApplication;
import junit.framework.TestCase;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase {

    private WicketTester tester;

    @Override
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    public void testRenderMyPage() {
        //start and render the test page
        tester.startPage(HomePage.class);

        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);

        //assert rendered label component
        //tester.assertLabel("message", "If you see this message wicket is properly configured and running");
    }

    public void testFormOk() {
        tester.startPage(HomePage.class);
        FormTester formTester = tester.newFormTester("form");
        formTester.setValue("fixedPhoneUs", "(12) 456-7890");
        formTester.setValue("fixedPhone", "(12) 3456-7890");
        formTester.submit();
        tester.assertRenderedPage(HomePage.class);        

        

        
        //tester.assertInfoMessages(new String[]{"124567890","1234567890"});
    }
}
