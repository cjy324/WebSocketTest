import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

// WebSocket의 호스트 주소 설정
@ServerEndpoint("/websocket")
public class WebSocket {
	
	// WebSocket으로 브라우저가 접속하면 요청되는 함수
	@OnOpen
	public void handleOpen() {
		// 콘솔에 접속 로그 출력
		System.out.println("client is now connected...");
	}
	
	// WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
		// 메시지 내용을 콘솔에 출력
		System.out.println("Receive From Client : " + message);
		// 응답 메시지 작성
		String replymessage = "Server Response : " + message;
		// 응답 메시지 콘솔에 출력
		System.out.println("Send To Client : " + replymessage);
		// 응답 메시지를 브라우저로 리턴
		return replymessage;
	}
	
	// WebSocket과 브라우저가 접속이 끊기면 요청되는 함수
	@OnClose
	public void handleClose() {
		// 콘솔에 접속 끊김 로그 출력
		System.out.println("client is now disconnected...");
	}
	
	// WebSocket과 브라우저 간에 통신 에러가 발생하면 요청되는 함수.
	@OnError
		public void handleError(Throwable t) {
		// 콘솔에 에러 출력
		t.printStackTrace();
	}
}