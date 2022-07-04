import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiChatUI extends JFrame {
	
	// 로그인
	private JPanel loginPanel;
	protected JButton loginButton;
	private JLabel inLabel;
	protected JLabel outLabel;
	protected JTextField idInput;
	
	// 로그아웃
	private JPanel logoutPanel;
	protected JButton logoutButton;
	private JPanel msgPanel;
	protected JTextField msgInput;
	protected JButton exitButton;
	
	// 생성자
	public MultiChatUI() {
		
		// 메인 프레임 구성
		super("::멀티챗::");
		
		// 로그인
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		idInput = new JTextField(15);
		loginButton = new JButton("로그인");
		//로그인 패널에 위젯 구성
		inLabel = new JLabel("대화명 ");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// 로그아웃
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		outLabel = new JLabel();
		logoutButton = new JButton("로그아웃");
		//로그아웃 패널에 위젯 구성
		logoutPanel.add(outLabel, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
	}

}
