package javafxapplication;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button_Math;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_otvet;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Button button_Clear;
    @FXML
    private Button button_Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void buttonMathAction(ActionEvent event) {
        double a = 0, b = 0, x = 0, y;
        try {
            try {
                a = Double.parseDouble(textField_A.getText());
            } catch (Exception ex) {
                textField_A.requestFocus();
                textField_A.setText("???");
                label_otvet.setText("Ошибка в переменной A");
                return;
            }
            
            try {
                b = Double.parseDouble(textField_B.getText());
            } catch (Exception ex) {
                textField_B.requestFocus();
                textField_B.setText("???");
                label_otvet.setText("Ошибка в переменной B");
                return;
            }
            
            try {
                x = Double.parseDouble(textField_X.getText());
            } catch (Exception ex) {
                textField_X.requestFocus();
                textField_X.setText("???");
                label_otvet.setText("Ошибка в переменной X");
                return;
            }
            
            if (x <= 7) {
                y = (x + 4) / (a * a + b * b);
                //label_otvet.setText("Ответ: " + String.format("%.2f",y));
            } else {
                y = x * (a + b) * (a + b);
                //label_otvet.setText("Ответ: " + String.format("%.2f",y));
            }
            
            if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
                label_otvet.setText("Ответ: " + String.format("%.2f", y));
            } else {
                label_otvet.setText("Нет ответа");
            }
            
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_A.requestFocus();
            label_otvet.setText("В введенных значениях допущены ошибки");
            return;
        }
        
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }

}
