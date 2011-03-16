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

import java.util.Locale;
import org.apache.wicket.util.convert.converters.AbstractConverter;

/**
 *
 * @author inaiat
 */
public class MeioMaskConverter extends AbstractConverter {

    private final Class<?> type;

    public MeioMaskConverter(Class<?> type) {
        this.type = type;
    }

    @Override
    protected Class<?> getTargetType() {
        return type;
    }

    public Object convertToObject(String string, Locale locale) {
        return string;
    }
}
