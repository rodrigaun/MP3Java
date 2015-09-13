package center.rodrigo.main;

import center.rodrigo.core.Mp3;

public class Main {

    public static void main(String[] args) {

        //precisa instalar o Java Media Framework API (Oracle)
        Mp3 mp3 = new Mp3("sounds/musica.mp3");
        mp3.start();

    }
}
