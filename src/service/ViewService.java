package service;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ViewService {

	/**
	 * 入力チェック
	 * @param targetText
	 * @param saltText
	 * @param radio
	 * @return
	 */
	public boolean checkInput(JTextField targetText, JTextField saltText, JRadioButton[] radio) {
		if (targetText == null || targetText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Passwordを入力して下さい");
			return false;
		}
		if (saltText == null || saltText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Saltを入力して下さい");
			return false;
		}
		int cnt = 0;
		for (int i = 0; i < radio.length; i++) {
			if (radio[i].isSelected()) {
				cnt++;
			}
		}
		if (cnt == 0) {
			JOptionPane.showMessageDialog(null, "アルゴリズムを選択して下さい");
			return false;
		}
		return true;
	}

	/**
	 * 暗号化
	 * @param targetText
	 * @param saltText
	 * @param radio
	 * @return
	 */
	public String calculation(JTextField targetText, JTextField saltText, JRadioButton[] radio) {
		// アルゴリズム取得
		String algorithm = "";
		for (int i = 0; i < radio.length; i++) {
			if (radio[i].isSelected()) {
				algorithm = radio[i].getText();
			}
		}

		// 暗号化
		return HashCalc.encryption(targetText.getText(), saltText.getText(), algorithm);
	}
}
