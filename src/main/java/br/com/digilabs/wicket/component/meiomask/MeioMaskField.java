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
import javax.swing.text.MaskFormatter;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.ConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author inaiat
 */
public class MeioMaskField<T> extends TextField<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeioMaskField.class);
    private final MaskFormatter maskFormatter = new MaskFormatter();

    public MeioMaskField(String id, MaskType mask) {
        super(id);
        initMaskField(mask, null);

    }

    public MeioMaskField(String id, MaskType mask, IModel<T> model) {
        super(id, model);
        initMaskField(mask, null);
    }

    public MeioMaskField(String id, MaskType mask, String options) {
        super(id);
        initMaskField(mask, options);
    }

    public MeioMaskField(String id, MaskType mask, String options, IModel<T> model) {
        super(id, model);
        initMaskField(mask, options);
    }

    public MeioMaskField(String id, MaskType mask, String options, IModel<T> model, Class<T> type) {
        super(id, model, type);
        initMaskField(mask, options);
    }

    private void initMaskField(MaskType mask, String options) {
        try {
            maskFormatter.setMask(mask.getMask());
            maskFormatter.setValueClass(String.class);
            maskFormatter.setAllowsInvalid(true);
            maskFormatter.setValueContainsLiteralCharacters(false);
        } catch (ParseException parseException) {
            throw new WicketRuntimeException(parseException);
        }

        add(new MeioMaskBehavior(mask, options));
        setOutputMarkupId(true);
    }

    @Override
    public String getInput() {
        String input = super.getInput();

        if (input.trim().length() == 0) {
            return input;
        } else {
            try {
                LOGGER.debug("Value to Converter {}", input);
                return (String) maskFormatter.stringToValue(input);
            } catch (ParseException ex) {
                throw newConversionException(input, ex);
            }
        }
    }

    /**
     * I don't know if this is a best place to convert mask (with String type), please if you
     * find other way... talk to me
     * @param value
     * @return
     * @throws ConversionException 
     */
    @Override
    protected T convertValue(String[] value) throws ConversionException {
        if (value != null && value.length > 0 && value[0].trim().length() > 0) {
            try {
                String valueToConverter = value[0];
                LOGGER.debug("Value to Converter {}", valueToConverter);
                value[0] = (String) maskFormatter.stringToValue(valueToConverter);
            } catch (ParseException ex) {    
                throw newConversionException(value[0], ex);
            }
        }
        return super.convertValue(value);
    }
    
    private ConversionException newConversionException(String value, Throwable cause) {
        return new ConversionException(cause)
                .setResourceKey("PatternValidator")
                .setVariable("input", value)
                .setVariable("pattern", maskFormatter.getMask());
    }
}
