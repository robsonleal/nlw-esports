package com.nlw.server.helpers;

public class Conversor {
    public static String minutosParaHoras(int min) {
        int h = min / 60;
        int m = min % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static int horasParaMinutos(String horario) {
        String[] horarios = horario.split(":");
        int minutos = Integer.parseInt(horarios[0]) * 60 + Integer.parseInt(horarios[1]);
        return minutos;
    }
}
