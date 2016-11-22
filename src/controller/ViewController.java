package controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.ViewService;

public class ViewController extends JFrame{

	private static final String[] ALGORITHM = {"MD2","MD5","SHA-1","SHA-256","SHA-384","SHA-512"};
	private JRadioButton[] radio;

	/**
	 * 表示設定
	 * @param title
	 */
	public ViewController(String title) {
		// Frame設定
		setTitle(title);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Component設定
		JTextField targetText = new JTextField();
		JTextField saltText = new JTextField();
		JTextArea resultArea = new JTextArea();
		resultArea.setLineWrap(true);

		radio = new JRadioButton[6];
		ButtonGroup group = new ButtonGroup();

		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(ALGORITHM[i]);
			group.add(radio[i]);
		}

		JButton btn = new JButton("Calculation");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewService service = new ViewService();
				if (service.checkInput(targetText, saltText, radio)) {
					String hash = service.calculation(targetText, saltText, radio);
					resultArea.setText(hash);
				}
			}
		});

		// LAYOUT設定
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		setContentPane(masterPanel);

		JPanel inTextPanel = new JPanel();
		inTextPanel.setLayout(new GridLayout(2, 2));
		masterPanel.add(inTextPanel, BorderLayout.NORTH);
		inTextPanel.add(new JLabel("Password", SwingConstants.LEFT));
		inTextPanel.add(targetText);
		inTextPanel.add(new JLabel("Salt", SwingConstants.LEFT));
		inTextPanel.add(saltText);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(2, 3));
		masterPanel.add(radioPanel, BorderLayout.CENTER);
		for (int i = 0; i < radio.length; i++) {
			radioPanel.add(radio[i]);
		}

		JPanel outPanel = new JPanel();
		outPanel.setLayout(new GridLayout(2, 1));
		masterPanel.add(outPanel, BorderLayout.SOUTH);
		outPanel.add(btn);
		outPanel.add(resultArea);
	}
}
