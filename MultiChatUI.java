import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatUI extends JFrame {
	
	// 로그인
	private JPanel loginPanel;
	protected JButton loginButton;
	
	// 대화명
	private JLabel inLabel;
	protected JLabel outLabel;
	protected JTextField idInput;
	
	// 로그아웃
	private JPanel logoutPanel;
	protected JButton logoutButton;
	
	// 메시지 입력
	private JPanel msgPanel;
	protected JTextField msgInput;
	protected JButton exitButton;
	
	// 화면 구성 전환을 위한 카드 레이아웃
	protected Container tab;
	protected CardLayout cardLayout;
	
	// 메시지 출력 창
	protected JTextArea msgOut;
	
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
		
		// 메시지 입력 패널에 위젯 구성
		exitButton = new JButton("종료");
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		
		// 로그인/로그아웃 패널 중 하나를 선택하는 카드 레이아웃 패널
		tab = new JPanel();
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		
		// 메시지 출력 영역 초기화
		// 세로와 가로에 입력할 수 있는 입력 글자 수를 지정하여 생성
		msgOut = new JTextArea("", 10, 30);
		// 충력 창의 용도로 사용해야 하므로 입력을 방지
		msgOut.setEditable(false);
		
		// 메시지 출력 영역 스코롤 바 구성
		// 수직 스크롤 바는 항상 나타내고, 수평 스크롤 바는 필요할 때 나타내도록 설정
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	}
	
	public void addButtonActionListener(ActionListener listener) {
		// 이벤트 리스너 등록
		loginButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);
	}

}
