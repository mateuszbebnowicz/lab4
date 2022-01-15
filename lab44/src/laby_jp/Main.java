package laby_jp;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try{
                Events event = new Events();
                event.mainEvent();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}