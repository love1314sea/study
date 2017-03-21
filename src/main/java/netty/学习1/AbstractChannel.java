package netty.学习1;

/**
 * Created by wushang on 17/3/9.
 */
public class AbstractChannel {
	private String eventName;


	public void aa(String eventName){
		AbstractChannel.this.eventName = eventName;
	}
}
