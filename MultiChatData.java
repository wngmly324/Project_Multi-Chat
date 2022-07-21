import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class MultiChatData {
	
	//데이터 제공 객체
	JTextArea msgOut;
	
	// 이모티콘 전송 기능
	ImageIcon smileIcon = new ImageIcon("./smile.jpg");
	Image smileImg = smileIcon.getImage();
	Image changedImg = smileImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icon = new ImageIcon(changedImg);
	
	public void addObj(JComponent comp) {
		this.msgOut = (JTextArea)comp;
	}
	
	public void refreshData(String msg) {
		// JTextArea에 수시된 메시지 추가
		msgOut.append(msg);
	}

}
