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
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converters.AbstractNumberConverter;

/**
 *
 * @author inaiat
 *
 *
 */
public class MeioMaskNumberConverter extends AbstractNumberConverter {

    private final Class<?> type;
    private final MeioMaskType maskType;
    private final MaskFormatter maskFormatter;

    public MeioMaskNumberConverter(Class<?> type, MeioMaskType maskType) {
        this.type = type;
        this.maskType = maskType;

        try {
            this.maskFormatter = new MaskFormatter();
            maskFormatter.setMask(maskType.getMask());
            maskFormatter.setValueClass(type);
            maskFormatter.setAllowsInvalid(true);
            maskFormatter.setValueContainsLiteralCharacters(false);
        } catch (ParseException ex) {
            throw new WicketRuntimeException(ex);
        }

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
        try {
            return maskFormatter.stringToValue(value);
        } catch (ParseException ex) {
            throw new ConversionException(ex);
        }

    }
}
