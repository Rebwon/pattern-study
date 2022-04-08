package com.rebwon.refactoring.splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public final class CountOrder {

    private record Order(String status) {

    }

    public static void main(String[] args) {
        try {
            System.out.println(run(args));
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    record CommandLine(boolean onlyCountReady, String fileName) {

    }

    private static long run(String[] args) throws IOException {
        CommandLine commandLine = parseCommandLine(args);
        return countOrder(commandLine);
    }

    private static CommandLine parseCommandLine(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("파일 명을 입력하세요");
        }
        String fileName = args[args.length - 1];
        boolean onlyCountReady = Arrays.asList(args).contains("-r");
        return new CommandLine(onlyCountReady, fileName);
    }

    private static long countOrder(CommandLine commandLine) throws IOException {
        File input = Paths.get(commandLine.fileName()).toFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);
        if (commandLine.onlyCountReady()) {
            return Arrays.stream(orders)
                .filter(o -> "ready".equals(o.status))
                .count();
        } else
            return orders.length;
    }
}
