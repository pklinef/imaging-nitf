/*
 * Copyright (c) Codice Foundation
 *
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 *
 */
package org.codice.imaging.nitf.fluent.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.codice.imaging.nitf.core.common.impl.NitfInputStreamReader;
import org.codice.imaging.nitf.fluent.NitfParserInputFlow;
import org.codice.imaging.nitf.fluent.NitfParserParsingFlow;

/**
 * The NitfParserInputFlow represents the start of the builder pattern for the
 * NITF parser.
 */
public class NitfParserInputFlowImpl implements NitfParserInputFlow {
    private static final long DEFAULT_SKIP_TIMEOUT = 0;

    /**
     * Constructor.
     */
    public NitfParserInputFlowImpl() {
        // Intentionally Empty
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final NitfParserParsingFlow file(final File inputFile) throws FileNotFoundException {
        return file(inputFile, DEFAULT_SKIP_TIMEOUT);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final NitfParserParsingFlow file(final File inputFile, final long skipTimeout)
        throws FileNotFoundException {
        NitfInputStreamReader nitfReader = new NitfInputStreamReader(new FileInputStream(inputFile));
        nitfReader.setSkipTimeout(skipTimeout);
        return new NitfParserParsingFlowImpl(nitfReader);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final NitfParserParsingFlow inputStream(final InputStream inputStream) {
        return inputStream(inputStream, DEFAULT_SKIP_TIMEOUT);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final NitfParserParsingFlow inputStream(final InputStream inputStream, final long skipTimeout) {
        NitfInputStreamReader nitfReader = new NitfInputStreamReader(inputStream);
        nitfReader.setSkipTimeout(skipTimeout);
        return new NitfParserParsingFlowImpl(nitfReader);
    }
}
