/*
 *  Copyright 2010 inaiat.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.digilabs.wicket.component.meiomask;

/**
 *
 * @author inaiat
 */
public enum MeioMaskType {

    FixedPhone("fixed.phone"),
    FixedPhoneUs("fixed.phone-us"),
    FixedCpf("fixed.cpf"),
    FixedCnpj("fixed.cnpj"),
    FixedDate("fixed.date"),
    FixedDateUs("fixed.date-us"),
    FixedCep("fixed.cep"),
    FixedTime("fixed.time"),
    FixedCc("fixed.cc"),
    ReverseInteger("reverse.integer"),
    ReverseDecimal("reverse.decimal"),
    ReverseDecimalUs("reverse.decimal-us"),
    ReverseReais("reverse.reais"),
    ReverseDollar("reverse.dollar"),
    RegexpIp("regexp.ip"),
    RegexpEmail("regexp.email");
    private String mask;

    private MeioMaskType(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }
}
