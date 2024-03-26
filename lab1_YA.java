import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab1_YA extends JFrame {

    private JPanel Panel1;
    private JLabel Label_Misto;
    private JLabel Label_Tochka;
    private JTextField Field_Misto_X;
    private JTextField Field_Misto_Y;
    private JTextField Field_Tochka_X;
    private JTextField Field_Tochka_Y;
    private JButton Button_Count;
    private JButton Button_Clear;
    private JTextField Field_Result;

    public lab1_YA() {
        Button_Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Field_Result.setText("");
                Field_Misto_X.setText("");
                Field_Misto_Y.setText("");
                Field_Tochka_X.setText("");
                Field_Tochka_Y.setText("");
            }
        });

        Button_Count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Field_Misto_X.getText().matches("^[0-9.]+$") && Field_Misto_Y.getText().matches("^[0-9.]+$") && Field_Tochka_X.getText().matches("^[0-9.]+$") && Field_Tochka_Y.getText().matches("^[0-9.]+$")) {
                    double a = Double.parseDouble(Field_Misto_X.getText());
                    double b = Double.parseDouble(Field_Misto_Y.getText());
                    double c = Double.parseDouble(Field_Tochka_X.getText());
                    double d = Double.parseDouble(Field_Tochka_Y.getText());

                    double R = (6371 * Math.pow(10,3));
                    double fi1 = ((a)*(Math.PI/180));
                    double fi2 = ((c)*(Math.PI/180));
                    double delta_fi = ((c-a)*(Math.PI/180));
                    double delta_gamma = ((d-b)*(Math.PI/180));
                    double alfa = ((Math.pow(Math.sin(delta_fi/2),2)) + (Math.cos(fi1) * Math.cos(fi2) * Math.pow(Math.sin(delta_gamma/2),2)));
                    double si = (2 * (Math.atan2(Math.sqrt(alfa),Math.sqrt(1-alfa))));
                    double di = (R * si);
                    Field_Result.setText(String.valueOf(di + " м"));

                } else {
                    JOptionPane.showMessageDialog(null,"Можна вводити лише числа");
                }

            }
        });

        Field_Result.setEditable(false);

    }

    public static void main(String[] args) {
        lab1_YA frame = new lab1_YA();
        frame.setSize(1200,500);
        frame.setContentPane(frame.Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Coordinates Counter");
    }

}
