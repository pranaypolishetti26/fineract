/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.infrastructure.core.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void nullValuesRemainNull() {
        Assertions.assertNull(StringUtil.maskValue(null));
        Assertions.assertNull(StringUtil.maskValue(null, 4));
    }

    @Test
    void emptyValueUsesPlaceholderWithDefaultLength() {
        Assertions.assertEquals("****", StringUtil.maskValue(""));
    }

    @Test
    void emptyValueUsesPlaceholderWithExplicitLength() {
        Assertions.assertEquals("****", StringUtil.maskValue("", 4));
    }

    @Test
    void nonEmptyValuesKeepExistingMasking() {
        Assertions.assertEquals("****", StringUtil.maskValue("1234"));
        Assertions.assertEquals("1****6789", StringUtil.maskValue("123456789"));
        Assertions.assertEquals("1******89", StringUtil.maskValue("123456789", 2));
    }
}
