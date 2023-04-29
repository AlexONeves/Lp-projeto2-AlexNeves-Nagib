/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogodogaloteste;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author alex, nagib
 */
public class FirstPage extends JFrame {

    //Botões
    JButton btBeginGame = new JButton();
    JButton btMostrarPlayers = new JButton();
    JButton btCriarPlayer = new JButton();

    //Labels
    JLabel placar = new JLabel("<html>Trabalho Realizado por <br> Alexandre Neves e Nagib Camara</html>");
    ImageIcon imageIcon = new ImageIcon("LogoUAfacebook.png");
    JLabel label = new JLabel(imageIcon);
    JLabel CriarJog = new JLabel("Criar Jogadores:");

    //TextFields
    JTextField textField = new JTextField(20);

    //Outros
    JFrame frame = new JFrame("Página Inicial");
    JPanel panel = new JPanel();

    public FirstPage() {
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(3); //Janela irá fechar quando clicarmos no X da janela;
        frame.setLayout(null);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);//Centrar pag
        panel.setOpaque(true);
        frame.add(placar);
        frame.add(btBeginGame);
        frame.add(textField);
        frame.add(label);
        frame.add(btMostrarPlayers);
        frame.add(CriarJog);
        frame.add(btCriarPlayer);
        label.setBounds(5, 5, 125, 128);
        placar.setBounds(5, 430, 300, 30);

        btBeginGame.setBounds(280, 80, 125, 30);
        btBeginGame.setFont(new Font("Arial", Font.BOLD, 10));
        btBeginGame.setText("Começar Jogo");

        btMostrarPlayers.setBounds(275, 130, 135, 30);
        btMostrarPlayers.setFont(new Font("Arial", Font.BOLD, 10));
        btMostrarPlayers.setText("Mostrar Jogadores");

        //Criar Jogadores
        CriarJog.setBounds(280, 250, 125, 30);
        textField.setBounds(280, 280, 125, 30);
        btCriarPlayer.setBounds(282, 315, 120, 40);
        btCriarPlayer.setFont(new Font("Arial", Font.BOLD, 10));
        btCriarPlayer.setText("Criar Jogador");

        //Ações
        btBeginGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Player.allPlayers.isEmpty() || Player.allPlayers.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Erro: Não existem jogadores suficientes para começar o jogo!!!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    new JogoDoGaloTeste();
                    frame.setVisible(false);
                }

            }
        });

        btMostrarPlayers.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JogadoresPainel();

            }
        });

        btCriarPlayer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nome = textField.getText();
                if (Nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum Nome Inserido", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean playerExists = false;
                    for (Player player : Player.allPlayers) {
                        if (player.getNome().equals(Nome)) {
                            playerExists = true;
                            break;
                        }
                    }
                    if (playerExists) {
                        JOptionPane.showMessageDialog(null, "Jogador já existe!!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new Player(Nome);
                        JOptionPane.showMessageDialog(null, "Jogador Criado com Sucesso", "Successo", JOptionPane.INFORMATION_MESSAGE);
                        textField.setText("");
                    }

                }

            }
        });
    }
}
