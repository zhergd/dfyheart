package com.dfy.heart.service.impl;

import java.awt.*;
import javax.swing.*;


class HeartLine extends JFrame {
    public static void main(String[] args) {
        HeartLine frame = new HeartLine("HeartLine");

        SwingUtilities.invokeLater(() -> {
            frame.init();
            try {
                for (int i = 1; i <= 2000; i++) {
                    frame.drawHeartLine(2000, i, 50);
                    Thread.sleep(3);
                }

            } catch (InterruptedException e) {
            }
            frame.drawHeartLine(2000, 0, 50);
        });
    }

    private JFrame frame;
    private int width;
    private int height;
    private Graphics graphics;
    private final double PI = Math.PI;

    public HeartLine(String title) {
        super(title);
        JLabel label = new JLabel("test");
        getContentPane().add(label);
        setVisible(true);
        setSize(440, 440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());

    }

    void init() {
        width = getSize().width;
        height = getSize().height;
        graphics = this.getGraphics();
        Image img = new ImageIcon("winSmile.jpg").getImage();
        setIconImage(img);
    }

    void drawHeartLine(int n, int k, double r) {
        if (k == n) return;
//        double x0 = 2 * r * (Math.sin(k * 2 * PI / n) - 0.5 * Math.sin(k * 4 * PI / n)) + 220;
//        double y0 = -2 * r * (Math.cos(k * 2 * PI / n) - 0.5 * Math.cos(k * 4 * PI / n)) + 220;
        double x0 = 2 * r * (Math.sin(k * 2 * PI / n) - 0.5 * Math.sin(k * 4 * PI / n)) + 220;
        double y0 = -2 * r * (Math.cos(k * 2 * PI / n) - 0.5 * Math.cos(k * 4 * PI / n)) + 220;
        drawOval(x0, y0, 1, 1);

    }

    void drawOval(double x0, double y0, int width, int height) {
        graphics.drawOval((int) x0, (int) y0, width, height);
    }
}

