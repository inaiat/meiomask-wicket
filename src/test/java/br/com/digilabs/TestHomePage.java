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
        tester.startPage(HomePage.class);
        tester.assertRenderedPage(HomePage.class);
    }

    public void testFormValuesOK() {
        tester.startPage(HomePage.class);
        FormTester formTester = tester.newFormTester("form");
        formTester.setValue("fixedPhoneUs", "(123) 456-7890");
        formTester.setValue("fixedPhone", "(12) 3456-7890");
        formTester.submit();
        tester.assertRenderedPage(HomePage.class);
        tester.assertNoErrorMessage();
    }

    public void testFormValuesFail() {
        tester.startPage(HomePage.class);
        FormTester formTester = tester.newFormTester("form");
        formTester.setValue("fixedPhoneUs", "(23) 456-7890");
        formTester.setValue("fixedPhone", "3456-7890");
        formTester.submit();
        tester.assertRenderedPage(HomePage.class);
        tester.assertNoInfoMessage();
    }
}
