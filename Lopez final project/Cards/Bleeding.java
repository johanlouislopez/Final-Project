package Cards;

import Main.Body;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bleeding extends JFrame {

    public Bleeding() {

        setTitle("Bleeding Guide");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // BACK BUTTON
        JLabel back = new JLabel("← Back to Categories");
        back.setForeground(Color.GRAY);
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setAlignmentX(Component.LEFT_ALIGNMENT);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Body();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setForeground(Color.GRAY);
            }
        });

        mainPanel.add(back);
        mainPanel.add(Box.createVerticalStrut(15));

        // TOP CARD
        JPanel topCard = createCardPanel();
        topCard.setLayout(new BorderLayout(10, 10));

        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(new Color(220, 0, 60)); // RED
        iconPanel.setPreferredSize(new Dimension(40, 40));

        JLabel icon = new JLabel("🩸");
        icon.setForeground(Color.WHITE);
        icon.setFont(new Font("SansSerif", Font.BOLD, 18));
        iconPanel.add(icon);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Bleeding");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel subtitle = new JLabel("Call 911 if bleeding is severe or won’t stop!");
        subtitle.setForeground(Color.RED);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(subtitle);

        topCard.add(iconPanel, BorderLayout.WEST);
        topCard.add(textPanel, BorderLayout.CENTER);

        mainPanel.add(topCard);
        mainPanel.add(Box.createVerticalStrut(15));

        // STEPS
        JPanel stepsPanel = createCardPanel();
        stepsPanel.setLayout(new BoxLayout(stepsPanel, BoxLayout.Y_AXIS));

        JLabel stepsTitle = new JLabel("🩺 Steps");
        stepsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        stepsPanel.add(stepsTitle);
        stepsPanel.add(Box.createVerticalStrut(15));

        addStep(stepsPanel, "1", "Personal Safety",
                "Wear gloves or protection (plastic, clean cloth) before touching blood.");

        addStep(stepsPanel, "2", "Position the Victim",
                "Lay the victim down. If possible, elevate the bleeding area above the heart.");

        addStep(stepsPanel, "3", "Apply Direct Pressure",
                "Press firmly on the wound using a clean cloth for 10–15 minutes.");

        addStep(stepsPanel, "4", "Maintain Pressure",
                "Do not remove cloth even if soaked. Add more cloth on top if needed.");

        addStep(stepsPanel, "5", "Bandage the Wound",
                "Wrap firmly once bleeding slows to keep pressure stable.");

        addStep(stepsPanel, "6", "Monitor",
                "Watch for shock signs like pale skin, dizziness, or cold sweat.");

        mainPanel.add(stepsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // TIPS
        JPanel tipsPanel = createCardPanel();
        tipsPanel.setLayout(new BoxLayout(tipsPanel, BoxLayout.Y_AXIS));

        JLabel tipsTitle = new JLabel("💡 Important Tips");
        tipsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        tipsPanel.add(tipsTitle);
        tipsPanel.add(Box.createVerticalStrut(10));

        addBullet(tipsPanel, "For minor wounds, clean and cover with a bandage");
        addBullet(tipsPanel, "Keep pressure steady without checking too often");
        addBullet(tipsPanel, "Stay calm to avoid increasing blood flow");

        mainPanel.add(tipsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // WARNINGS
        JPanel warningPanel = createCardPanel();
        warningPanel.setLayout(new BoxLayout(warningPanel, BoxLayout.Y_AXIS));

        JLabel warningTitle = new JLabel("❗ Warnings");
        warningTitle.setForeground(Color.RED);
        warningTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        warningPanel.add(warningTitle);
        warningPanel.add(Box.createVerticalStrut(10));

        addBullet(warningPanel, "Bleeding that doesn’t stop after 15 minutes needs medical help");
        addBullet(warningPanel, "Bleeding from nose/ears after head injury is serious");
        addBullet(warningPanel, "Do NOT give aspirin (can worsen bleeding)");

        mainPanel.add(warningPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // EMERGENCY BUTTON
        JButton emergencyBtn = new JButton(
                "<html><center>In case of emergency:<br><b>View Nearest Hospitals</b></center></html>"
        );

        emergencyBtn.setBackground(new Color(255, 0, 60));
        emergencyBtn.setForeground(Color.WHITE);
        emergencyBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        emergencyBtn.setFocusPainted(false);
        emergencyBtn.setBorder(new EmptyBorder(15, 15, 15, 15));

        emergencyBtn.addActionListener(e -> {

            String hospitals =
                    "🏥 Nearest Hospitals in Davao:\n\n" +
                    "1. Southern Philippines Medical Center (SPMC)\n" +
                    "   📞 (082) 227-2731\n\n" +
                    "2. Davao Doctors Hospital\n" +
                    "   📞 (082) 221-2101\n\n" +
                    "3. San Pedro Hospital\n" +
                    "   📞 (082) 222-6100\n\n" +
                    "4. Brokenshire Memorial Hospital\n" +
                    "   📞 (082) 305-1900\n\n" +
                    "5. Adventist Hospital Davao\n" +
                    "   📞 (082) 305-3333";

            JOptionPane.showMessageDialog(
                    this,
                    hospitals,
                    "Nearest Hospitals",
                    JOptionPane.WARNING_MESSAGE
            );
        });

        mainPanel.add(emergencyBtn);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);

        add(scrollPane);
        setVisible(true);
    }

    // CARD STYLE
    static JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }

    // STEP BOX
    static void addStep(JPanel parent, String num, String title, String desc) {

        JPanel stepPanel = new JPanel(new BorderLayout(10, 0));
        stepPanel.setOpaque(false);

        JLabel number = new JLabel(num, SwingConstants.CENTER);
        number.setOpaque(true);
        number.setBackground(new Color(220, 0, 60));
        number.setForeground(Color.WHITE);
        number.setPreferredSize(new Dimension(25, 25));
        number.setFont(new Font("SansSerif", Font.BOLD, 12));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        JLabel descLabel = new JLabel("<html><body style='width:220px'>" + desc + "</body></html>");
        descLabel.setForeground(Color.GRAY);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(3));
        text.add(descLabel);

        stepPanel.add(number, BorderLayout.WEST);
        stepPanel.add(text, BorderLayout.CENTER);

        parent.add(stepPanel);
        parent.add(Box.createVerticalStrut(15));
    }

    // BULLETS
    static void addBullet(JPanel panel, String text) {
        JLabel label = new JLabel("• " + text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        label.setForeground(Color.DARK_GRAY);
        panel.add(label);
    }
}