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
    private double PercentagemWin;
    private double PercentagemL;
    private double PercentagemEmpate;
    private int win;
    private int defeat;
    private int draw;
    private int NumJogos;
    private int NumJogosTotal;

    public Player(String Nome) {
        this.PercentagemWin = 0;
        this.Nome = Nome.toUpperCase();
        this.win = 0;
        this.defeat = 0;
        this.draw = 0;
        this.NumJogos = 0;
        allPlayers.add(this);
    }

    public String getNome() {
        return Nome;
    }

    public int getWin() {
        return win;
    }

    public int getNumJogos() {
        return NumJogos;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDerrota() {
        return defeat;
    }

    public void setDerrota(int Derrota) {
        this.defeat = Derrota;
    }

    public int getEmpate() {
        return draw;
    }

    public void setEmpate(int empate) {
        this.draw = empate;
    }

    public void setNumJogos() {
        this.NumJogos++;
    }

    public String percentagenWin() {
        this.PercentagemWin = ((double) this.win / (double) this.NumJogos) * 100;
        return String.format("%.1f%%", PercentagemWin);
    }

    public String percentagenDerrota() {
        this.PercentagemL = ((double) this.defeat / (double) this.NumJogos) * 100;
        return String.format("%.1f%%", PercentagemL);
    }

    public String percentagenEmpate() {
        this.PercentagemEmpate = ((double) this.draw / (double) this.NumJogos) * 100;
        return String.format("%.1f%%", PercentagemEmpate);
    }

    public String getPerWin() {
        return " - " + this.PercentagemWin + "%";
    }

    public String getPerL() {
        return " - " + this.PercentagemL + "%";
    }

    public String getPerDraw() {
        return " - " + this.PercentagemEmpate + "%";
    }

}

class JogadoresPainel {

    private static JTextArea outputArea;

    public JogadoresPainel() {
        JFrame frame = new JFrame("Ver Jogadores");
        JPanel panel = new JPanel();
        frame.setLocationRelativeTo(null);//Centrar pag
        outputArea = new JTextArea(10, 40);
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
                outputArea.append("Jogador " + i + " - " + p.getNome() + " Vitoria - " + p.getWin() + " " + p.getPerWin() + " Derrota - " + p.getDerrota() + " " + p.getPerL() + " Empate - " + p.getEmpate() + " " + p.getPerDraw() + "\n");
                i++;
            }
        }
    }
}
