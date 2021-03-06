package ch.cyberduck.cli;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.DelimiterPathKindDetector;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.HostParser;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathKindDetector;
import ch.cyberduck.core.ProtocolFactory;

import org.apache.commons.cli.CommandLine;

import java.util.EnumSet;

public class CommandLinePathParser {

    private final PathKindDetector detector
            = new DelimiterPathKindDetector();

    private final CommandLine input;

    private final ProtocolFactory factory;

    public CommandLinePathParser(final CommandLine input) {
        this(input, ProtocolFactory.global);
    }

    public CommandLinePathParser(final CommandLine input, final ProtocolFactory factory) {
        this.input = input;
        this.factory = factory;
    }

    public Path parse(final String uri) {
        final Host host = new HostParser(factory).get(uri);
        switch(host.getProtocol().getType()) {
            case s3:
            case googlestorage:
            case swift:
                final PathAttributes attributes = new PathAttributes();
                if(input.hasOption(TerminalOptionsBuilder.Params.region.name())) {
                    attributes.setRegion(input.getOptionValue(TerminalOptionsBuilder.Params.region.name()));
                }
        }
        return new Path(host.getDefaultPath(), EnumSet.of(detector.detect(host.getDefaultPath())));
    }
}
