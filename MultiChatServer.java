import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MultiChatServer {
	// 서버 소켓 및 클라이언트 연결 소켓
	private ServerSocket ss = null;
	private Socket s = null;
	
	
	// 연결된 클라이언트 스레드를 관리하는 ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	
	// 로거 객체
	Logger logger;
	
	// 멀티 채팅 메인 프로그램 부분
	public void start() {
		logger = Logger.getLogger(this.getClass().getName());
		
		try {
			// 서버 소켓 생성
			ss = new ServerSocket(8888);
			logger.info("MultiChatServer start");
			
			// 무한 루프를 돌면서 클라이언트 연결을 기다린다.
			while(true) {
				s = ss.accept();
				// 연결된 클라이언트에 대해 스레드 클래스 생성
				ChatThread chat = new ChatThread();
				// 클라이언트 리스트 추가
				chatThreads.add(chat);
				chat.start();
			}
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception 발생!!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	class ChatThread extends Thread {
		
	}
}
