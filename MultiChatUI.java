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
	
	// 로그인 패널
	private JPanel loginPanel;
	// 로그인 버튼
	protected JButton loginButton;
	
	// 대화명 라벨
	private JLabel inLabel;
	// 대화명 출력 라벨
	protected JLabel outLabel;
	// 대화명 입력 텍스트 필드
	protected JTextField idInput;
	
	// 로그아웃 패널
	private JPanel logoutPanel;
	// 로그아웃 버튼
	protected JButton logoutButton;
	
	// 메시지 입력 패널
	private JPanel msgPanel;
	// 메시지 입력 텍스트 필드
	protected JTextField msgInput;
	// 종료 버튼
	protected JButton exitButton;
	
	// 메시지 출력창
	protected JTextArea msgOut;
	
	// 화면 구성 전환을 위한 카드레이아웃
	protected Container tab;
	protected CardLayout cardLayout;
	
	// 로그인 아이디 저장 필드
	protected String id;
	
	// 사운드 버튼
	protected JButton soundButton;
	
	// 생성자
	public MultiChatUI() {
		
		// 메인 프레임 구성
		super("::MultiChat::");
		
		// 로그인 패널 화면 구성
		loginPanel = new JPanel();
		
		// 로그인 패널 레이아웃 설정
		loginPanel.setLayout(new BorderLayout());
		
		// 로그인 입력필드/버튼 생성
		idInput = new JTextField(15);
		loginButton = new JButton("Login");
		
		// 로그인 패널에 위젯 구성
		inLabel = new JLabel("NickName ");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// 로그아웃 패널 구성
        logoutPanel = new JPanel();

        // 로그아웃 패널 레이아웃 설정
        logoutPanel.setLayout(new BorderLayout());
        outLabel = new JLabel();
        logoutButton = new JButton("Logout");
        soundButton= new JButton("Sound");

        // 로그아웃 패널에 위젯 구성
        logoutPanel.add(outLabel, BorderLayout.CENTER);
        logoutPanel.add(logoutButton, BorderLayout.EAST);
        logoutPanel.add(logoutButton, BorderLayout.WEST);
		
		// 메시지 입력 패널 구성
		msgPanel = new JPanel();
		// 레이아웃 설정
		msgPanel.setLayout(new BorderLayout());
		msgInput = new JTextField(30);
		
		// 메시지 입력 패널에 위젯 구성
		exitButton = new JButton("Exit");
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		
		// 로그인/로그아웃 패널 선택을 위한 CardLayout 패널
		tab = new JPanel();
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		
		// 메시지 출력 영역 초기화
		msgOut = new JTextArea("", 10, 30);
		// 출력 전용으로 사용하기 위해 내용을 수정하지 못하도록 함
		msgOut.setEditable(false);
		
		// 메시지 출력 영역 스크롤바 구성
		// 수직 스크롤바는 항상 나타내고, 수평 스크롤바는 필요시 나타냄
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// 메인 프레임에 패널 배치
		add(tab, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(msgPanel, BorderLayout.SOUTH);
		
		// 로그인 패널을 우선 보이도록 함
		cardLayout.show(tab, "login");
		
		// 프레임 크기 자동으로 설정
		pack();
		
		// 프레임 크기 조정 불가 설정
		setResizable(false);
		
		// 프레임이 보여지도록 함
		setVisible(true);
		
	}
	
	public void addButtonActionListener(ActionListener listener) {
		// 이벤트 리스너 등록
		loginButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);
		soundButton.addActionListener(listener);
	}

}
