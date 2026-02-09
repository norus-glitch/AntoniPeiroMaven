package com.antonipeiro.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> guion = new ArrayList<>();

        String banner = FigletFont.convertOneLine("ANTONI P.");
        String[] bannerLines = banner.split("\n");

        for (String l : banner.split("\n")) {
            guion.add(l);
        }

        guion.add(""); // separación

        // CV
        guion.add("Nombre: Antoni Peiró Tarrazona");
        guion.add("Perfil: Estudiante DAM");
        guion.add("Lenguajes: Java, HTML, CSS, JS");
        guion.add("Frameworks: Maven, Git");
        guion.add("IDEs: IntelliJ, Eclipse");
        guion.add("Experiencia: Proyectos académicos");
        guion.add("Idiomas: Español, Valenciano");
        guion.add("Disponibilidad para prácticas");

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        screen.setCursorPosition(null);

        TerminalSize size = screen.getTerminalSize();
        int height = size.getRows();

        int yOffset = height;

        while (yOffset > -guion.size()) {
            drawFrame(screen, guion, yOffset);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }

            yOffset--;
        }

        screen.readInput();
        screen.stopScreen();
    }


    private static void drawFrame(Screen screen, List<String> lines, int yOffset)
            throws IOException {

        TerminalSize size = screen.getTerminalSize();
        int width = size.getColumns();
        int height = size.getRows();

        screen.clear();
        TextGraphics tg = screen.newTextGraphics();

        for (int i = 0; i < lines.size(); i++) {
            int y = yOffset + i;
            if (y < 0 || y >= height) continue;

            String line = lines.get(i);
            int x = Math.max(0, (width - line.length()) / 2);

            String visible = (line.length() > width)
                    ? line.substring(0, width)
                    : line;

            tg.putString(x, y, visible);
        }

        screen.refresh();
    }
}