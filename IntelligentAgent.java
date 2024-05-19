import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntelligentAgent extends JFrame {
    private JTextField weatherField;
    private JTextField timeField;
    private JTextArea resultArea;
    private JButton evaluateButton;

    public IntelligentAgent() {
        setTitle("Agente Inteligente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        weatherField = new JTextField(10);
        timeField = new JTextField(10);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        evaluateButton = new JButton("Evaluar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Clima:"));
        inputPanel.add(weatherField);
        inputPanel.add(new JLabel("Hora del día:"));
        inputPanel.add(timeField);

        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateAgent();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        panel.add(evaluateButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void evaluateAgent() {
        String weather = weatherField.getText().toLowerCase();
        String timeOfDay = timeField.getText().toLowerCase();

        StringBuilder result = new StringBuilder("Recomendación:\n");

        if (weather.equals("soleado") && timeOfDay.equals("mañana")) {
            result.append("Ve a correr\n");
        } else if (weather.equals("soleado") && timeOfDay.equals("tarde")) {
            result.append("Haz un picnic\n");
        } else if (weather.equals("soleado") && timeOfDay.equals("noche")) {
            result.append("Mira el atardecer\n");
        } else if (weather.equals("lluvioso") && timeOfDay.equals("mañana")) {
            result.append("Lee un libro\n");
        } else if (weather.equals("lluvioso") && timeOfDay.equals("tarde")) {
            result.append("Visita un museo\n");
        } else if (weather.equals("lluvioso") && timeOfDay.equals("noche")) {
            result.append("Mira una película\n");
        } else if (weather.equals("nublado") && timeOfDay.equals("mañana")) {
            result.append("Ve al gimnasio\n");
        } else if (weather.equals("nublado") && timeOfDay.equals("tarde")) {
            result.append("Da un paseo\n");
        } else if (weather.equals("nublado") && timeOfDay.equals("noche")) {
            result.append("Cena con amigos\n");
        } else {
            result.append("No hay recomendaciones disponibles para esas condiciones.\n");
        }

        resultArea.setText(result.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IntelligentAgent().setVisible(true);
            }
        });
    }
}
