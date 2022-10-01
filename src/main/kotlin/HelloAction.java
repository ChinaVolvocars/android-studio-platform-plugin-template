import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;

public class HelloAction extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {
    NotificationGroup notificationGroup = new NotificationGroup("test_id", NotificationDisplayType.BALLOON, false);
    /**
     * content :  通知内容
     * type  ：通知的类型，warning,info,error
     */
    Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
    Notifications.Bus.notify(notification);
  }
}
