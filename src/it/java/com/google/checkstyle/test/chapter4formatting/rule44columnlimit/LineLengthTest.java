////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2015 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.google.checkstyle.test.chapter4formatting.rule44columnlimit;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.sizes.LineLengthCheck;

public class LineLengthTest extends BaseCheckTestSupport {

    private static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/it/"));
    }

    @Test
    public void lineLengthTest() throws Exception {

        final String[] expected = {
            "5: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 112),
            "29: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 183),
            "46: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 131),
            "47: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 124),
            "48: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 113),
            "50: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 116),
            "53: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 131),
            "57: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 116),
        };

        final Configuration checkConfig = builder.getCheckConfig("LineLength");
        final String filePath = builder.getFilePath("InputLineLength");

        final Integer[] warnList = builder.getLinesWithWarn(filePath);
        verify(checkConfig, filePath, expected, warnList);
    }
}
