package br.com.digilabs.meiomask.examples;

import br.com.digilabs.wicket.component.meiomask.MeioMaskBehavior;
import br.com.digilabs.wicket.component.meiomask.MeioMaskType;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    // TODO Add any page properties or variables here
    /**
     * Constructor that is invoked when page is invoked without a session.
     * 
     * @param parameters
     *            Page parameters
     */
    public HomePage(final PageParameters parameters) {


        TextField<String> fixedMask = new TextField<String>("change-mask-input");
        fixedMask.add(new MeioMaskBehavior(MeioMaskType.Fixed,"{mask: ':99:99:', autoTab: true}"));
        add(fixedMask);

        TextField<String> fixedPhone = new TextField<String>("fixed-phone");
        fixedPhone.add(MeioMaskType.FixedPhone.getBehavior());
        add(fixedPhone);

        TextField<String> fixedPhoneUs = new TextField<String>("fixed-phone-us");
        fixedPhoneUs.add(MeioMaskType.FixedPhoneUs.getBehavior());
        add(fixedPhoneUs);

        TextField<String> fixedCpf = new TextField<String>("fixed-cpf");
        fixedCpf.add(MeioMaskType.FixedCpf.getBehavior());
        add(fixedCpf);

    }
}
