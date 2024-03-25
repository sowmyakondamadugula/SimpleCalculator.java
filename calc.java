import java.awt.*;
import java.awt.event.*;

public class calc implements ActionListener {
	Frame f = new Frame("calculator");
	Button b[] = new Button[10];
	Panel p = new Panel();
	GridLayout g = new GridLayout(5, 5, 15, 15);
	TextField t = new TextField(22);
	String s1, s2, s4;
	char s3;
	double c;

	// -----------creating buttons and adding action listener------------------
	calc() {

		for (int i = 0; i < 10; i++) {
			b[i] = new Button(i + "");
			b[i].setPreferredSize(new Dimension(48, 40));
			b[i].addActionListener(this);
		}
		Button badd = new Button("+");
		badd.addActionListener(this);
		Button bsub = new Button("-");
		bsub.addActionListener(this);
		Button bmul = new Button("x");
		bmul.addActionListener(this);
		Button bdiv = new Button("/");
		bdiv.addActionListener(this);
		Button bmod = new Button("%");
		bmod.addActionListener(this);
		Button beql = new Button("=");
		beql.setBackground(Color.orange);
		beql.addActionListener(this);
		Button bpoi = new Button(".");
		bpoi.addActionListener(this);
		Button bclr = new Button("clr");
		bclr.setBackground(Color.orange);
		bclr.addActionListener(this);

		// --------setting buttons to panel-----------

		p.add(bclr);
		p.add(beql);
		p.setVisible(true);
		for (int i = 0; i < 10; i++) {
			p.add(b[i]);
			b[i].setBackground(Color.gray);
		}
		p.add(badd);
		p.add(bsub);
		p.add(bmul);
		p.add(bdiv);
		p.add(bmod);
		p.add(bpoi);
		// ----------setting the panels and frame accordingly.------------

		p.setLayout(g);
		f.setLayout(new FlowLayout());
		f.setSize(300, 380);
		f.setVisible(true);
		f.setBackground(Color.darkGray);
		f.add(t);
		f.add(p);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
	// ------------setting action for the buttons--------------

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			s1 = t.getText() + s;
			t.setText(s1);
		}
		if (s.charAt(0) == '+') {
			s2 = t.getText();
			t.setText("");
			s3 = '+';
		}
		if (s.charAt(0) == '-') {
			s2 = t.getText();
			t.setText("");
			s3 = '-';
		}
		if (s.charAt(0) == 'x') {
			s2 = t.getText();
			t.setText("");
			s3 = 'x';
		}
		if (s.charAt(0) == '/') {
			s2 = t.getText();
			t.setText("");
			s3 = '/';
		}
		if (s.charAt(0) == '%') {
			s2 = t.getText();
			t.setText("");
			s3 = '%';
		}
		// -----preforming arithmetic operations---------
		if (s.charAt(0) == '=') {
			s4 = t.getText();
			if (s3 == '+') {
				c = Double.parseDouble(s2) + Double.parseDouble(s4);
			}
			if (s3 == '-') {
				c = Double.parseDouble(s2) - Double.parseDouble(s4);
			}
			if (s3 == 'x') {
				c = Double.parseDouble(s2) * Double.parseDouble(s4);
			}
			if (s3 == '/') {
				c = Double.parseDouble(s2) / Double.parseDouble(s4);
			}
			if (s3 == '%') {
				c = Double.parseDouble(s2) % Double.parseDouble(s4);
			}
			// ----showing result on the text field.---------
			t.setText(s2 + s3 + s4 + " = " + String.valueOf(c));
		}
		if (s.equals("clr")) {
			t.setText("");
		}
	}

	// ------main method---------
	public static void main(String[] args) {
		calc c = new calc();
	}
}