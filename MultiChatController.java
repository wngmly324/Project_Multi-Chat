import java.io.IOException;

public class MultiChatController {
	// 뷰 클래스 참조 객체
	private final MultiChatUI v;
	
	// 데이터 클래스 참조 객체
	private final MultiChatData chatData;
	public MultiChatController(MultiChatData chatData, MultiChatUI v) {
		// 로거 객체 초기화
		logger = Logger.getLogger(this.getClass().getName());
		
		// 모델과 뷰 클래스 참조
		this.chatData = chatData;
		this.v = v;
	}
	public void appMain(){
		// 데이터 객체에서 데이터 변화를 처리할 UI 객체 추가
		chatData.addObj(v.msgOut);
		
		v.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object ojb = e.getSource();
				
				// 종료 버튼 처리
				if(obj == v.exitButton) {
					System.exit(0);
				} else if(obj == v.loginButton) {
					v.id = v.idInput.getText();
					v.outLabel.setText(" 대화명 : " + v.id);
					v.cardLayout.show(v.tab, "logout");
					connectServer();
				} else if(obj == v.logoutButton) {
					// 로그아웃 메시지 전송
					outMsg.println(gson.toJson(new Message(v.id, "", "", "logout")));
					// 대화 창 클리어
					v.msgOut.setText("");
					// 로그인 패널로 전환
					v.cardLayout.show(v.tab, "login");
					outMsg.close();
					try {
						inMsg.close();
						spclet.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					status = false;
				} else if(obj == v.msgInput) {
					// 메시지 전송
					outMsg.println(gson.toJson(new Message(v.id, "", v.msgInput.getText(), "msg")));
					// 입력 창 클리어
					v.msgInput.setText("");
				}
			}
		});
	}

	public static void main(String[] args) {
		

	}

}
