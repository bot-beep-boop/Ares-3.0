package com.aresclient.utils.notification;

import java.util.concurrent.LinkedBlockingQueue;

public class NotificationManager {
   private static Notification currentNotification = null;
   private static LinkedBlockingQueue<Notification> pendingNotifications = new LinkedBlockingQueue();

   public static void render() {
      update();
      if (currentNotification != null) {
         currentNotification.render();
      }

   }

   public static void show(Notification var0) {
      pendingNotifications.add(var0);
   }

   public static void update() {
      if (currentNotification != null && !currentNotification.isShown()) {
         currentNotification = null;
      }

      if (currentNotification == null && !pendingNotifications.isEmpty()) {
         currentNotification = (Notification)pendingNotifications.poll();
         currentNotification.show();
      }

   }
}
