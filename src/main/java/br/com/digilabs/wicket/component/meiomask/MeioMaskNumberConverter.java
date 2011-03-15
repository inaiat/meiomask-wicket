/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.digilabs.wicket.component.meiomask;

import java.text.NumberFormat;
import java.util.Locale;
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

    public Object convertToObject(String string, Locale locale) {
        return string;
    }
}
