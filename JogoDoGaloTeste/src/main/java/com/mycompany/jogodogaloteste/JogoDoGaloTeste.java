package com.mycompany.jogodogaloteste;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author alex, nagib
 */
public class JogoDoGaloTeste extends JFrame {

    private Player X;
    private Player O;

    JButton[] bt = new JButton[9];
    JButton btExit = new JButton();
    JLabel placar = new JLabel("Placar");
    JLabel px = new JLabel("X 0");
    JLabel po = new JLabel("O 0");
    int PWinX = 0;
    int PWinO = 0;
    int PEmpateX = 0;
    int PEmpateO = 0;
    int PDerrotaX = 0;
    int PDerrotaO = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];
    JLabel NumeroDeJogosTotal = new JLabel("Numero de Jogos: ");

    public JogoDoGaloTeste(Player X, Player O) {

        this.O = O;
        this.X = X;
        this.PWinX = X.getWin();
        this.PWinO = O.getWin();
        this.PDerrotaO = O.getDerrota();
        this.PDerrotaX = X.getDerrota();
        this.PEmpateO = O.getEmpate();
        this.PEmpateX = X.getEmpate();

        setVisible(true);
        setTitle("Jogo do Galo");
        setDefaultCloseOperation(3); //Janela irá fechar quando clicarmos no X da janela;
        setLayout(null);
        setBounds(0, 0, 700, 500); //Janela no canto superior esquerdo com 700px de largura e 500 px de altura;
        setLocationRelativeTo(null);//Centrar pag
        add(placar);
        add(px);
        add(po);
        add(btExit);
        add(NumeroDeJogosTotal);
        placar.setBounds(350, 50, 100, 30);
        px.setText(X.getNome() + " Vitorias: " + PWinX + X.getPerWin() + " Derrotas: " + PDerrotaX + X.getPerL() + " Empates: " + PEmpateX + X.getPerDraw());
        po.setText(O.getNome() + " Vitorias: " + PWinO + O.getPerWin() + " Derrotas: " + PDerrotaO + O.getPerL() + " Empates: " + PEmpateO + O.getPerDraw());
        px.setBounds(350, 75, 320, 30);
        po.setBounds(350, 95, 320, 30);
        NumeroDeJogosTotal.setBounds(350, 115, 200, 30);
        NumeroDeJogosTotal.setText("Numero de Jogos já jogados: " + NumJogos.JogosTotal);
        btExit.setBounds(50, 400, 125, 30);
        btExit.setText("Ecrã Principal");
        // criar os botões;
        int cont = 0; //contador
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
                cont++;
            }
        }

        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }

        // ação dos botões;
        btExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FirstPage();
                setVisible(false);
            }
        });

        bt[0].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[0] == false) {
                    click[0] = true;
                    mudar(bt[0]);
                }
            }
        });
        bt[1].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[1] == false) {
                    click[1] = true;
                    mudar(bt[1]);
                }
            }
        });
        bt[2].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[2] == false) {
                    click[2] = true;
                    mudar(bt[2]);
                }
            }
        });
        bt[3].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[3] == false) {
                    click[3] = true;
                    mudar(bt[3]);
                }
            }
        });
        bt[4].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[4] == false) {
                    click[4] = true;
                    mudar(bt[4]);
                }
            }
        });
        bt[5].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[5] == false) {
                    click[5] = true;
                    mudar(bt[5]);
                }
            }
        });
        bt[6].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[6] == false) {
                    click[6] = true;
                    mudar(bt[6]);
                }
            }
        });
        bt[7].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[7] == false) {
                    click[7] = true;
                    mudar(bt[7]);
                }
            }
        });
        bt[8].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[8] == false) {
                    click[8] = true;
                    mudar(bt[8]);
                }
            }
        });
    }

    public void mudar(JButton btn) {
        if (xo) {
            btn.setText("O");
            xo = false;

        } else {
            btn.setText("X");
            xo = true;
        }
        ganhou();
    }

    public void atualizar() {

        X.setWin(PWinX);
        O.setWin(PWinO);
        X.setEmpate(PEmpateX);
        O.setEmpate(PEmpateO);
        X.setDerrota(PDerrotaX);
        O.setDerrota(PDerrotaO);
        NumJogos.JogosTotal++;
        X.setNumJogos();
        O.setNumJogos();

        px.setText(X.getNome() + " Vitorias: " + PWinX + " - " + X.percentagenWin() + " Derrotas: " + PDerrotaX + " - " + X.percentagenDerrota() + " Empates: " + PEmpateX + " - " + X.percentagenEmpate());
        po.setText(O.getNome() + " Vitorias: " + PWinO + " - " + O.percentagenWin() + " Derrotas: " + PDerrotaO + " - " + O.percentagenDerrota() + " Empates: " + PEmpateO + " - " + O.percentagenEmpate());

        NumeroDeJogosTotal.setText("Numero de Jogos já jogados: " + NumJogos.JogosTotal);

    }

    public void ganhou() {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (click[i] == true) {
                cont++;
            }
        }
        if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
                || (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
                || (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
                || (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
                || (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
                || (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
            JOptionPane.showMessageDialog(null, X.getNome() + " Ganhou");

            PWinX++;
            PDerrotaO++;

            atualizar();
            limpar();
        } else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
                || (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
                || (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
                || (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
                || (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
                || (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
            JOptionPane.showMessageDialog(null, O.getNome() + " Ganhou");
            PWinO++;
            PDerrotaX++;

            atualizar();
            limpar();
        } else if (cont == 9) {
            JOptionPane.showMessageDialog(null, "Empate");
            PEmpateX++;
            PEmpateO++;

            limpar();
            atualizar();
        }
    }

    public void limpar() {
        for (int i = 0; i < 9; i++) {
            bt[i].setText("");
            click[i] = false;
        }
    }

    public static void main(String[] args) {
        new FirstPage();
    }
}
