package Cards;

import Main.Body;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tsunami extends JFrame {

    public Tsunami() {

        setTitle("Tsunami Safety Guide");

        // FULL SCREEN
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

        // Top Card
        JPanel topCard = createCardPanel();
        topCard.setLayout(new BorderLayout(10, 10));

        JPanel iconPanel = new JPanel();

        // CYAN COLOR
        iconPanel.setBackground(new Color(0, 255, 255));

        iconPanel.setPreferredSize(new Dimension(40, 40));

        JLabel wave = new JLabel("🌊");
        wave.setForeground(Color.WHITE);
        wave.setFont(new Font("SansSerif", Font.BOLD, 18));
        iconPanel.add(wave);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Tsunami Safety");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));

        // SUBTITLE RED
        JLabel subtitle = new JLabel("⚠ Move to higher ground immediately!");
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

        JLabel stepsTitle = new JLabel("🌊 Safety Steps");
        stepsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        stepsPanel.add(stepsTitle);
        stepsPanel.add(Box.createVerticalStrut(15));

        addStep(stepsPanel, "1", "Move to Higher Ground",
                "Immediately go to elevated areas away from the shore.");

        addStep(stepsPanel, "2", "Follow Evacuation Routes",
                "Use marked evacuation paths and follow authorities.");

        addStep(stepsPanel, "3", "Stay Away from Beaches",
                "Never go near the coast to watch the tsunami.");

        addStep(stepsPanel, "4", "Listen to Alerts",
                "Monitor radio, TV, or emergency announcements.");

        addStep(stepsPanel, "5", "Prepare Emergency Supplies",
                "Bring food, water, medicine, and flashlights.");

        addStep(stepsPanel, "6", "Wait for Official Clearance",
                "Return only when authorities declare it safe.");

        mainPanel.add(stepsPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // TIPS
        JPanel tipsPanel = createCardPanel();
        tipsPanel.setLayout(new BoxLayout(tipsPanel, BoxLayout.Y_AXIS));

        JLabel tipsTitle = new JLabel("💡 Important Tips");
        tipsTitle.setFont(new Font("SansSerif", Font.BOLD, 15));

        tipsPanel.add(tipsTitle);
        tipsPanel.add(Box.createVerticalStrut(10));

        addBullet(tipsPanel, "Keep emergency contacts saved");
        addBullet(tipsPanel, "Prepare a go-bag in advance");
        addBullet(tipsPanel, "Stay calm and help others evacuate");

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

        addBullet(warningPanel, "Do not return after the first wave");
        addBullet(warningPanel, "Avoid flooded roads and bridges");
        addBullet(warningPanel, "Stay away from damaged buildings");

        mainPanel.add(warningPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // EMERGENCY BUTTON (RED)
        JButton emergencyBtn = new JButton(
                "<html><center>In case of emergency:<br><b>View Emergency Hotlines</b></center></html>"
        );

        emergencyBtn.setBackground(Color.RED);
        emergencyBtn.setForeground(Color.WHITE);
        emergencyBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        emergencyBtn.setFocusPainted(false);
        emergencyBtn.setBorder(new EmptyBorder(15, 15, 15, 15));

        emergencyBtn.addActionListener(e -> {

            String hotlines =
                    "🚨 Emergency Hotlines:\n\n" +
                    "1. National Emergency Hotline\n" +
                    "   📞 911\n\n" +
                    "2. Davao City Disaster Office\n" +
                    "   📞 (082) 296-9626\n\n" +
                    "3. Philippine Red Cross Davao\n" +
                    "   📞 (082) 227-6657\n\n" +
                    "4. Bureau of Fire Protection\n" +
                    "   📞 160\n\n" +
                    "5. Davao Rescue 911\n" +
                    "   📞 911";

            JOptionPane.showMessageDialog(
                    this,
                    hotlines,
                    "Emergency Hotlines",
                    JOptionPane.WARNING_MESSAGE
            );
        });

        mainPanel.add(emergencyBtn);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);

        add(scrollPane);
        setVisible(true);
    }

    // CARD DESIGN
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

        // CYAN COLOR
        number.setBackground(new Color(0, 255, 255));

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