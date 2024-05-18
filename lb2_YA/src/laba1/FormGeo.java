package laba1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormGeo extends JFrame {
    private JPanel mainPanel;
    private JLabel LabelpointA;
    private JTextField textFieldAlon;
    private JTextField textFieldAlat;
    private JLabel LabelpointB;
    private JTextField textFieldBLon;
    private JTextField textFieldBlot;
    private JButton buttonSolve;
    private JButton buttonclear;
    private JTextField textFieldresult;

    public FormGeo (){

       setContentPane(mainPanel);
        setTitle("Distance Calculator");
        setSize(600,600);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        textFieldresult.setEditable(false);
        setVisible(true);






        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(2);
            }
        });


        buttonSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double lat1 = Double.parseDouble(textFieldAlat.getText());
                    double lon1 = Double.parseDouble(textFieldAlon.getText());
                    double lat2 = Double.parseDouble(textFieldBlot.getText());
                    double lon2 = Double.parseDouble(textFieldBLon.getText());
                    double R = 6371e3; // Earth radius in meters

                    double phi1 = Math.toRadians(lat1);
                    double phi2 = Math.toRadians(lat2);
                    double deltaPhi = Math.toRadians(lat2 - lat1);
                    double deltaLambda = Math.toRadians(lon2 - lon1);

                    double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                            Math.cos(phi1) * Math.cos(phi2) *
                                    Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);

                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

                    double distance = (R * c);

                    textFieldresult.setText(String.format("%.2f m", distance));
                }catch (NumberFormatException ex) { textFieldresult.setText("Invalid input");}}

        });






        buttonclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              textFieldAlat.setText("");
               textFieldAlon.setText("");
               textFieldBlot.setText("");
                textFieldBLon.setText("");
              textFieldresult.setText("");
            }
        });
    }




    public static void main(String[] args) {
        FormGeo obj = new FormGeo();
    }


}
