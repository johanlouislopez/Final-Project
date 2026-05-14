package Main;


import javax.swing.*;
import javax.swing.border.LineBorder;

import Cards.Bleeding;
import Cards.Burns;
import Cards.CPR;
import Cards.Choking;
import Cards.Drought;
import Cards.Drowning;
import Cards.Earthquake;
import Cards.EyeInjuries;
import Cards.Flood;
import Cards.Fractures;
import Cards.HeatStroke;
import Cards.Hypothermia;
import Cards.Landslide;
import Cards.Poisoning;
import Cards.Seizures;
import Cards.Shock;
import Cards.Tornado;
import Cards.Tsunami;
import Cards.Typhoon;
import Cards.VolcanicEruption;
import Cards.Wildfire;

import java.awt.*;
import java.util.ArrayList;

public class Body {

    static JTextField search;
    static ArrayList<Card> cards = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("LifeAid");
        frame.setSize(750, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));

        // Logo
        JLabel logo = new JLabel("LifeAid");
        logo.setFont(new Font("Arial", Font.BOLD, 36));
        logo.setForeground(Color.RED);
        logo.setBounds(20, 10, 200, 40);
        panel.add(logo);

        JLabel subtitle = new JLabel("First aid app");
        subtitle.setBounds(70, 45, 120, 20);
        panel.add(subtitle);

        // Emergency Banner
        JPanel emergency = new JPanel();
        emergency.setLayout(null);
        emergency.setBackground(new Color(255, 20, 60));
        emergency.setBounds(20, 75, 680, 60);

        JLabel emergencyText = new JLabel(
                "Emergency Numbers  |  911 - Emergency | 911 - Fire | 911 - Police");
        emergencyText.setForeground(Color.WHITE);
        emergencyText.setFont(new Font("Arial", Font.BOLD, 18));
        emergencyText.setBounds(20, 15, 650, 30);

        emergency.add(emergencyText);
        panel.add(emergency);

        // SEARCH BAR (WORKING)
        search = new JTextField(" Search for first aid");
        search.setBounds(80, 160, 550, 35);
        search.setFont(new Font("Arial", Font.PLAIN, 16));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                filter(search.getText());
            }
        });

        panel.add(search);

        // CARDS (REGISTERED FOR SEARCH)
        JPanel cprCard = addCard(panel, "CPR & Cardiac Arrest", 25, 220, new Color(178, 34, 34));
        cprCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override  
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new CPR();
            }
        });
        JPanel chokingCard = addCard(panel, "Choking", 255, 220, new Color(0, 188, 212));
        chokingCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override  
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Choking();
            }
        });
        JPanel bleedingCard = addCard(panel, "Bleeding", 485, 220, new Color(139, 0, 0));
        bleedingCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Bleeding();
            }
        });

        JPanel burnsCard = addCard(panel, "Burns", 25, 300, new Color(255, 140, 0));
        burnsCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Burns();
            }
        });
        JPanel fracturesCard = addCard(panel, "Fractures", 255, 300, new Color(120, 120, 120));
        fracturesCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Fractures();
            }
        });
        JPanel shockCard = addCard(panel, "Shock", 485, 300, new Color(255, 193, 7));
        shockCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Shock();
            }
        });

        JPanel poisoningCard = addCard(panel, "Poisoning", 25, 380, new Color(186, 85, 211));
        poisoningCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Poisoning();
            }
        });
        JPanel seizuresCard = addCard(panel, "Seizures", 255, 380, new Color(255, 192, 203));
        seizuresCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Seizures();
            }
        });
        JPanel heatStrokeCard = addCard(panel, "Heat Stroke", 485, 380, new Color(255, 0, 0));
        heatStrokeCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new HeatStroke();
            }
        });

        JPanel hypothermiaCard = addCard(panel, "Hypothermia", 25, 460, new Color(0, 255, 255));
        hypothermiaCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Hypothermia();
            }
        });
        JPanel drowningCard = addCard(panel, "Drowning", 255, 460, new Color(0, 0, 255));
        drowningCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Drowning();
            }
        });
        JPanel eyeInjuriesCard = addCard(panel, "Eye Injuries", 485, 460, new Color(0, 255, 0));
        eyeInjuriesCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new EyeInjuries();
            }
        });

        JPanel earthquakeCard = addCard(panel, "Earthquake", 25, 540, new Color(255, 0, 0));
        earthquakeCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Earthquake();
            }
        });

        JPanel floodCard = addCard(panel, "Flood", 255, 540, new Color(0, 0, 255));
        floodCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Flood();
            }
        });
        JPanel typhoonCard = addCard(panel, "Typhoon", 485, 540, new Color(128, 128, 128));
        typhoonCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Typhoon();
            }
        });

        JPanel volcanicEruptionCard = addCard(panel, "Volcanic Eruption", 25, 620, new Color(255, 165, 0));
        volcanicEruptionCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new VolcanicEruption();
            }
        });
        JPanel landslideCard = addCard(panel, "Landslide", 255, 620, new Color(45, 45, 45));
        landslideCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Landslide();
            }
        });
        JPanel tsunamiCard = addCard(panel, "Tsunami", 485, 620, new Color(0, 255, 255));
        tsunamiCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Tsunami();
            }
        });

        JPanel droughtCard = addCard(panel, "Drought", 25, 700, new Color(255, 255, 0));
        droughtCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Drought();
            }
        });
        JPanel tornadoCard = addCard(panel, "Tornado", 255, 700, new Color(255, 0, 255));
        tornadoCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Tornado();
            }
        });
        JPanel wildfireCard = addCard(panel, "Wildfire", 485, 700, new Color(255, 0, 0));
        wildfireCard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new Wildfire();
            }
        });

        // Bottom Warning
        JPanel warning = new JPanel();
        warning.setBackground(new Color(255, 235, 210));
        warning.setBorder(new LineBorder(Color.ORANGE));
        warning.setBounds(20, 760, 680, 35);

        JLabel warningText = new JLabel(
                "Important: This guide is for learning basic first aid.");
        warning.add(warningText);

        panel.add(warning);

        frame.add(panel);
        frame.setVisible(true);
    }

    // CARD METHOD (UPDATED TO SUPPORT SEARCH)
    static JPanel addCard(JPanel panel, String title, int x, int y, Color color) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(new Color(245, 220, 220));
        card.setBorder(new LineBorder(Color.GRAY));
        card.setBounds(x, y, 215, 55);

        JPanel icon = new JPanel();
        icon.setBackground(color);
        icon.setBounds(10, 10, 40, 35);

        JLabel text = new JLabel(title);
        text.setFont(new Font("Arial", Font.BOLD, 15));
        text.setBounds(60, 10, 150, 20);

        card.add(icon);
        card.add(text);

        panel.add(card);

        // STORE FOR SEARCH
        cards.add(new Card(title, card));

        return card;
    }

    // SEARCH FILTER (MAIN FUNCTION)
    static void filter(String query) {
        String q = query.toLowerCase().trim();

        for (Card c : cards) {
            if (q.equals("") || c.title.toLowerCase().contains(q)) {
                c.panel.setVisible(true);
            } else {
                c.panel.setVisible(false);
            }
        }
    }

    // HELPER CLASS
    static class Card {
        String title;
        JPanel panel;

        Card(String title, JPanel panel) {
            this.title = title;
            this.panel = panel;
        }
    }
}