import javax.swing.JComponent;
import javax.swing.JTextArea;

public class MultiChatData {
	
	//데이터 제공 객체
	JTextArea msgOut;
	
	public void addObj(JComponent comp) {
		this.msgOut = (JTextArea)comp;
	}
	
	public void regreshData(String msg) {
		// JTextArea에 수시된 메시지 추가
		msgOut.append(msg);
	}

}
