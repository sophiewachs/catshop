package fr.aruku.catshop.api.notifications;

import fr.aruku.catshop.api.resource.NotepadResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sophiewachs on 13/03/2014.
 */

@Component
public class InMemoryRequestNotificationHub implements RequestNotificationHub {


    private List<Notification> notifications = new ArrayList<Notification>();

    @Override
    public void notify(String... args) {
        for(String notificationText : args){
            notifications.add(new Notification(notificationText));
        }
    }

    @Override
    public List<Notification> getNotificationsReceived() {
        return notifications;
    }
}
