/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodogaloteste;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author alex, nagib
 */
public class Player {

    public static ArrayList<Player> allPlayers = new ArrayList<>();
    private String Nome;

    public Player(String Nome) {
        this.Nome = Nome;
        allPlayers.add(this);
    }

    public String getNome() {
        return Nome;
    }

//    public static void verJogadores() {
//        if (allPlayers.isEmpty()) {
//            System.out.println("Não existem Jogadores");
//        } else {
//            int i = 1;
//            for (Player p : allPlayers) {
//
//                System.out.println("Jogador " + i + " - " + p.getNome());
//                i++;
//
//            }
//        }
//
//    }
}

class JogadoresPainel {

    private static JTextArea outputArea;

    public JogadoresPainel() {
        JFrame frame = new JFrame("Ver Jogadores");
        JPanel panel = new JPanel();
        frame.setLocationRelativeTo(null);//Centrar pag
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        verJogadores();
    }

    public static void verJogadores() {
        if (Player.allPlayers.isEmpty()) {
            outputArea.append("Não existem Jogadores\n");
        } else {
            int i = 1;
            for (Player p : Player.allPlayers) {
                outputArea.append("Jogador " + i + " - " + p.getNome() + "\n");
                i++;
            }
        }
    }
}
