package fr.aruku.catshop.api.notifications;

import java.util.List;


public interface RequestNotificationHub {

    void notify(String... args);

    List<Notification> getNotificationsReceived();

    class Notification {
        private String name;

        public Notification(String name) {
            this.name = name;
        }
    }
}
