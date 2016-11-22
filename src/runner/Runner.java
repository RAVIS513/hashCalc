package runner;

import javax.swing.SwingUtilities;

import controller.ViewController;

public class Runner {

//	/**
//	 * コンストラクタ
//	 * @param title
//	 */
//	public Runner(String title) {
//		setTitle(title);
//		setSize(500, 300);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JButton btn = new JButton("Calculation");
//		add(btn, BorderLayout.NORTH);
//	}

	/**
	 * 実行
	 * @param args
	 */
	public static void main(String[] args) {
		// イベントディスパッチスレッド
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ViewController view = new ViewController("Hash-Calculation");
				view.setVisible(true);
			}
		});
	}

}
