package Cards;

import Main.Body;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Burns extends JFrame {

    public Burns() {

        setTitle("Burns Guide");
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
        iconPanel.setBackground(new Color(255, 120, 0)); // orange
        iconPanel.setPreferredSize(new Dimension(40, 40));

        JLabel icon = new JLabel("🔥");
        icon.setForeground(Color.WHITE);
        icon.setFont(new Font("SansSerif", Font.BOLD, 18));
        iconPanel.add(icon);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Burns");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel subtitle = new JLabel("📞 Call 911 for extensive burns or 3rd degree burns!");
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

        addStep(stepsPanel, "1", "Stop the Heat Source",
                "Move the victim away from heat. Turn off electricity if needed. Do NOT touch electrical burns directly.");

        addStep(stepsPanel, "2", "Cool with Water",
                "Run cool (not ice cold) water over the burn for 10–20 minutes. Do NOT use ice.");

        addStep(stepsPanel, "3", "Remove Accessories",
                "Carefully remove jewelry, belts, or tight clothing before swelling starts. Do not remove stuck clothing.");

        addStep(stepsPanel, "4", "Cover the Burn",
                "Use clean, moist, non-fluffy cloth or sterile gauze. Do not apply cotton directly.");

        addStep(stepsPanel, "5", "Do Not Break Blisters",
                "Do NOT pop blisters. This increases infection risk. Avoid applying butter, toothpaste, or oil.");

        addStep(stepsPanel, "6", "Further Treatment",
                "For minor burns use antiseptic. For severe burns, seek hospital care immediately.");

        mainPanel.add(stepsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // TIPS
        JPanel tipsPanel = createCardPanel();
        tipsPanel.setLayout(new BoxLayout(tipsPanel, BoxLayout.Y_AXIS));

        JLabel tipsTitle = new JLabel("💡 Important Tips");
        tipsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        tipsPanel.add(tipsTitle);
        tipsPanel.add(Box.createVerticalStrut(10));

        addBullet(tipsPanel, "1st degree: redness (like sunburn)");
        addBullet(tipsPanel, "2nd degree: blisters with fluid");
        addBullet(tipsPanel, "3rd degree: white/black skin, numbness");
        addBullet(tipsPanel, "Burns on face, hands, feet, genitals need doctor");

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

        addBullet(warningPanel, "DO NOT use ice — it can damage tissue further");
        addBullet(warningPanel, "DO NOT break blisters — infection risk");
        addBullet(warningPanel, "DO NOT apply butter, oil, or toothpaste");
        addBullet(warningPanel, "Extensive burns (>10% body) need hospital care");

        mainPanel.add(warningPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // EMERGENCY BUTTON
        JButton emergencyBtn = new JButton(
                "<html><center>In case of emergency:<br><b>Call 911 or Nearest Hospital</b></center></html>"
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

    // STEP DESIGN
    static void addStep(JPanel parent, String num, String title, String desc) {

        JPanel stepPanel = new JPanel(new BorderLayout(10, 0));
        stepPanel.setOpaque(false);

        JLabel number = new JLabel(num, SwingConstants.CENTER);
        number.setOpaque(true);
        number.setBackground(new Color(255, 120, 0));
        number.setForeground(Color.WHITE);
        number.setPreferredSize(new Dimension(25, 25));
        number.setFont(new Font("SansSerif", Font.BOLD, 12));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        JLabel descLabel = new JLabel(
                "<html><body style='width:220px'>" + desc + "</body></html>"
        );
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