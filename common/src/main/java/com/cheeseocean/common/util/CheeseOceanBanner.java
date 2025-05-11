package com.cheeseocean.common.util;

import java.io.PrintStream;
import java.util.Arrays;

import com.cheeseocean.common.CheeseOceanVersion;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;

public class CheeseOceanBanner implements Banner {

//    private static final String[] BANNER = {
//            "   ██████  ██                                          ███████                                     ",
//            "  ██░░░░██░██                                         ██░░░░░██                                    ",
//            " ██    ░░ ░██████   █████   █████   ██████  █████    ██     ░░██  █████   █████   ██████   ███████ ",
//            "░██       ░██░░░██ ██░░░██ ██░░░██ ██░░░░  ██░░░██  ░██      ░██ ██░░░██ ██░░░██ ░░░░░░██ ░██░░░██",
//            "░██       ░██  ░██░███████░███████░░█████ ░███████  ░██      ░██░██  ░░ ░███████  ███████ ░██  ░██",
//            "░░██    ██░██  ░██░██░░░░ ░██░░░░  ░░░░░██░██░░░░   ░░██     ██ ░██   ██░██░░░░  ██░░░░██ ░██  ░██",
//            " ░░██████ ░██  ░██░░██████░░██████ ██████ ░░██████   ░░███████  ░░█████ ░░██████░░███████ ░██  ░██",
//            "  ░░░░░░  ░░   ░░  ░░░░░░  ░░░░░░ ░░░░░░   ░░░░░░     ░░░░░░░    ░░░░░   ░░░░░░  ░░░░░░░  ░░   ░░ "};
//
    private static final String[] BANNER = {
            " ██████╗██╗  ██╗███████╗███████╗███████╗███████╗     ██████╗  ██████╗███████╗ █████╗ ███╗   ██╗",
            "██╔════╝██║  ██║██╔════╝██╔════╝██╔════╝██╔════╝    ██╔═══██╗██╔════╝██╔════╝██╔══██╗████╗  ██║",
            "██║     ███████║█████╗  █████╗  ███████╗█████╗      ██║   ██║██║     █████╗  ███████║██╔██╗ ██║",
            "██║     ██╔══██║██╔══╝  ██╔══╝  ╚════██║██╔══╝      ██║   ██║██║     ██╔══╝  ██╔══██║██║╚██╗██║",
            "╚██████╗██║  ██║███████╗███████╗███████║███████╗    ╚██████╔╝╚██████╗███████╗██║  ██║██║ ╚████║",
            " ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝╚══════╝     ╚═════╝  ╚═════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝"};

    private static final String CHEESE_OCEAN = " :: Cheese Ocean :: ";
    private static final String SPRING_BOOT = " :: Spring Boot :: ";

    private static final int STRAP_LINE_SIZE = Arrays.stream(BANNER).mapToInt(String::length).max().orElse(96);

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        // Print banner lines
        for (String line : BANNER) {
            printStream.println(AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, center(line, STRAP_LINE_SIZE)));
        }

        // Print version information
        String springVersion = SpringBootVersion.getVersion();
        String appVersion = CheeseOceanVersion.getVersion();
        springVersion = " (v" + springVersion + ")";
        appVersion = " (v" + appVersion + ")";

        String padding = String.join("", Arrays.stream(new String[STRAP_LINE_SIZE]).map(s -> " ").toList());

        printStream.println(AnsiOutput.toString(
                AnsiColor.YELLOW, CHEESE_OCEAN,
                AnsiColor.DEFAULT, padding,
                AnsiStyle.FAINT, appVersion)
        );
        printStream.println(AnsiOutput.toString(
                AnsiColor.GREEN, SPRING_BOOT,
                AnsiColor.DEFAULT, padding,
                AnsiStyle.FAINT, springVersion)
        );
        printStream.println();
    }

    private String center(String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        int leftPadding = (length - text.length()) / 2;
        int rightPadding = length - text.length() - leftPadding;
        return repeat(" ", leftPadding) + text + repeat(" ", rightPadding);
    }

    private String repeat(String str, int times) {
        return String.join("", Arrays.asList(new String[times]).stream().map(s -> str).toList());
    }
}