package SubFunctionalities.GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldChangeListener {
    public static void addChangeListener(JTextField textField, Runnable onChangeAction) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChangeAction.run();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChangeAction.run();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChangeAction.run();
            }
        });
    }
}
