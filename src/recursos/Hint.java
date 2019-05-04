package recursos;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
/**
 *
 * @author campu
 */
public class Hint extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public Hint(final String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
        this.setForeground(new Color(204, 204, 204));
    }
  
    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
            setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
            setForeground(new Color(204, 204, 204));
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();

    }
}