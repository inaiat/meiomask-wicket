package br.com.digilabs.meiomask.examples;

import br.com.digilabs.wicket.component.meiomask.MeioMaskField;
import br.com.digilabs.wicket.component.meiomask.MeioMaskType;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private TestModel testModel = new TestModel();

    public HomePage(final PageParameters parameters) {

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedBack");
        add(feedbackPanel);

        Form<TestModel> form = new Form<TestModel>("form", new CompoundPropertyModel<TestModel>(testModel)) {

            @Override
            protected void onSubmit() {
                String temp = getModelObject().getFixedPhone();
                info("fixed-phone: " + temp);
                info("fixed-phone-us: " + getModelObject().getFixedPhoneUs());

            }
        };

        add(form);

        //form.add(new MeioMaskField<String>("fixed", MeioMaskType.Fixed, "{mask: ':99:99:', autoTab: true}"));
        form.add(new MeioMaskField<Long>("fixedPhoneUs", MeioMaskType.FixedPhoneUs));
        form.add(new MeioMaskField<String>("fixedPhone", MeioMaskType.FixedPhone));

        //form.add(new MeioMaskField<String>("fixedCpf", MeioMaskType.FixedCpf));



    }
}
