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
    JButton btComeçarJogo = new JButton();

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
                    new ComeçarJogoJanela();
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
                        if (player.getNome().equals(Nome.toUpperCase())) {
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

class ComeçarJogoJanela {

    JButton btComeçarJogo = new JButton();
    JLabel InsiraX = new JLabel("Insira o Jogador X:");
    JLabel InsiraO = new JLabel("Insira o Jogador O:");

    JTextField jogadorxNome = new JTextField(20);
    JTextField jogadorONome = new JTextField(20);
    JFrame frame = new JFrame("Escolher Jogadores");

    public ComeçarJogoJanela() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3); //Janela irá fechar quando clicarmos no X da janela;
        frame.setLayout(null);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);//Centrar pag
        frame.add(btComeçarJogo);
        frame.add(jogadorxNome);
        frame.add(jogadorONome);
        frame.add(InsiraX);
        frame.add(InsiraO);

        btComeçarJogo.setBounds(180, 200, 125, 30);
        btComeçarJogo.setFont(new Font("Arial", Font.BOLD, 10));
        btComeçarJogo.setText("Começar Jogo");

        jogadorxNome.setBounds(180, 60, 125, 30);
        jogadorONome.setBounds(180, 120, 125, 30);

        InsiraX.setBounds(180, 30, 125, 30);
        InsiraO.setBounds(180, 90, 125, 30);

        btComeçarJogo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NomeX = jogadorxNome.getText();
                String NomeO = jogadorONome.getText();

                if (NomeX.isEmpty() || NomeO.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Escolha os dois jogadores antes de começar!!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean playerXExists = false;
                    boolean playerOExists = false;
                    Player JogadorXSelecionado = null;
                    Player JogadorOSelecionado = null;
                    for (Player player : Player.allPlayers) {
                        if (player.getNome().equals(NomeX.toUpperCase())) {
                            playerXExists = true;
                            JogadorXSelecionado = player;
                            break;
                        }

                    }
                    for (Player player : Player.allPlayers) {
                        if (player.getNome().equals(NomeO.toUpperCase())) {
                            playerOExists = true;
                            JogadorOSelecionado = player;
                            break;
                        }

                    }
                    if (JogadorXSelecionado.getNome() == JogadorOSelecionado.getNome()) {
                        JOptionPane.showMessageDialog(null, "Não podem ser os mesmos jogadores!!", "Erro", JOptionPane.ERROR_MESSAGE);

                    } else {
                        if (playerXExists == true && playerOExists == true) {

                            new JogoDoGaloTeste(JogadorXSelecionado, JogadorOSelecionado);
                            JogadorXSelecionado.setNumJogos();
                            JogadorOSelecionado.setNumJogos();
                            frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Escolha corretamente os jogadores!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        });

    }
}
