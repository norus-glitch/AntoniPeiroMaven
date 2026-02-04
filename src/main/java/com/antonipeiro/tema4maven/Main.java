package com.antonipeiro.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String texto = "Antoni Peiró";

        //creamos un try para asumir el riesgo de la excepción
        try {
            String banner = FigletFont.convertOneLine(texto);
            System.out.println(banner);
        } catch (IOException e) {
            System.out.println("Error generating ASCII art");
            e.printStackTrace();
        }
    }
}
