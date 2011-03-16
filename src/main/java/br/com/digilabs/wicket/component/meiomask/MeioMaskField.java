/*
 * Copyright 2011 inaiat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.digilabs.wicket.component.meiomask;

import java.text.ParseException;
import java.util.Locale;
import javax.swing.text.MaskFormatter;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converters.AbstractConverter;

/**
 *
 * @author inaiat
 */
public class MeioMaskField<T> extends TextField<T> {

    private MeioMaskType meioMaskType;

    public MeioMaskField(String id, MeioMaskType mask) {
        super(id);
        init(mask,null);

    }

    public MeioMaskField(String id, MeioMaskType mask, IModel<T> model) {
        super(id, model);
        init(mask,null);
    }

    public MeioMaskField(String id, MeioMaskType mask, String options) {
        super(id);
        init(mask, options);
    }

    public MeioMaskField(String id, MeioMaskType mask, String options, IModel<T> model) {
        super(id, model);
        init(mask, options);

    }

    private void init(MeioMaskType mask, String options) {
        this.meioMaskType = mask;
        //setType(String.class);
        add(new MeioMaskBehavior(mask, options));
        setOutputMarkupId(true);
    }

    @Override
    public IConverter getConverter(final Class<?> type) {
        IConverter converter = null;
        if (meioMaskType.getMask().length() > 0 && String.class.isAssignableFrom(type)) {
            final MaskFormatter maskFormatter = new MaskFormatter();
            try {
                maskFormatter.setMask(meioMaskType.getMask());
                maskFormatter.setValueClass(type);
                maskFormatter.setAllowsInvalid(true);
                maskFormatter.setValueContainsLiteralCharacters(false);
            } catch (ParseException ex) {
                throw new WicketRuntimeException(ex);
            }

            converter = new AbstractConverter() {

                @Override
                protected Class<?> getTargetType() {
                    return String.class;
                }

                @Override
                public String convertToString(Object value, Locale locale) {
                    try {
                        String valueToReturn = (String) maskFormatter.stringToValue(value.toString());
                        return valueToReturn;
                        //return super.convertToString(value, locale);
                    } catch (ParseException ex) {
                        throw new WicketRuntimeException(ex);
                    }
                }

                @Override
                public Object convertToObject(String value, Locale locale) {
                    Object objectToReturn;
                    try {
                        objectToReturn = (String) maskFormatter.stringToValue(value.toString());
                    } catch (ParseException ex) {
                        throw new WicketRuntimeException(ex);
                    }
                    System.out.println(">>>>>" + objectToReturn);
                    return objectToReturn;
                }
            };

        } else if (Number.class.isAssignableFrom(type)) {
            converter = new MeioMaskNumberConverter(type);
        } else {
            converter = super.getConverter(type);
        }
        return converter;
    }

    @Override
    protected void convertInput() {
        super.convertInput();
        String input = getInput();
        System.out.println(input);
    }
}
