/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.digilabs.wicket.component.meiomask;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.text.MaskFormatter;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.util.convert.converters.AbstractNumberConverter;

/**
 *
 * @author inaiat
 *
 *
 */
public class MeioMaskNumberConverter extends AbstractNumberConverter {

    private final Class<?> type;

    public MeioMaskNumberConverter(Class<?> type) {
        this.type = type;
    }

    @Override
    public NumberFormat getNumberFormat(Locale locale) {
        NumberFormat format = NumberFormat.getInstance(locale);
        format.setGroupingUsed(false);
        return format;
    }

    @Override
    protected Class<?> getTargetType() {
        return type;
    }

    @Override
    public String convertToString(Object value, Locale locale) {
        return super.convertToString(value, locale);
    }

    public Object convertToObject(String value, Locale locale) {
        final MaskFormatter maskFormatter = new MaskFormatter();
        try {
            maskFormatter.setMask(meioMaskType.getMask());
            maskFormatter.setValueClass(type);
            maskFormatter.setAllowsInvalid(true);
            maskFormatter.setValueContainsLiteralCharacters(false);
        } catch (ParseException ex) {
            throw new WicketRuntimeException(ex);
        }

        return maskFormatter.valueToString(value);
    }
}
