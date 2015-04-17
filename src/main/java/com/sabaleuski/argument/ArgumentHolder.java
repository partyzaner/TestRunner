package com.sabaleuski.argument;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.List;

public class ArgumentHolder {

    @Option(name="-browser")
    public static String browser;

    @Option(name="-suite")
    public static String suite;

    @Argument
    private List<String> arguments = new ArrayList<>();

}
