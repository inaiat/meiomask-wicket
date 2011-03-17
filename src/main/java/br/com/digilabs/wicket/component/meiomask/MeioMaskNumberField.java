/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.digilabs.wicket.component.meiomask;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

/**
 *
 * @author inaiat
 */
public class MeioMaskNumberField<T extends Number> extends TextField<T> {

    private final MeioMaskType maskType;
    
    public MeioMaskNumberField(String id, MeioMaskType mask, IModel<T> model) {
        super(id, model);
        this.maskType = mask;
        add(new MeioMaskBehavior(mask));
        setOutputMarkupId(true);
    }

    public MeioMaskNumberField(String id, MeioMaskType mask) {
        this(id, mask, null);
    }

    @Override
    public IConverter getConverter(final Class<?> type) {
        return new MeioMaskNumberConverter(type,maskType);
    }
}
