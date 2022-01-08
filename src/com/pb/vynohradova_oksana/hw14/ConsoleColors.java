package com.pb.vynohradova_oksana.hw14;

public class ConsoleColors {
    private static final String[] colors = {
            "\033[0;31m", //RED
            "\033[0;32m", //GREEN
            "\033[0;33m", //YELLOW
            "\033[0;34m", //BLUE
            "\033[0;35m", //PURPLE
            "\033[0;36m", //CYAN
            "\033[0;91m", //RED_BRIGHT
            "\033[0;92m", //GREEN_BRIGHT
            "\033[0;93m", //YELLOW_BRIGHT
            "\033[0;94m", //BLUE_BRIGHT
            "\033[0;95m", //PURPLE_BRIGHT
            "\033[0;96m" //CYAN_BRIGHT
    };

    public static String getColor(int i) {
        while (i > 12) {
            i /= 2;
        }
        return colors[i-1];
    }
}
