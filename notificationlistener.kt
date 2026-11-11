package com.gathee.assistant
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
class NotificationListener : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        // Lets Gathee read WhatsApp / SMS aloud
        sbn?.let {
            val text = it.notification.extras.getCharSequence("android.text")?.toString() ?: return
            val title = it.notification.extras.getString("android.title") ?: "Someone"
            // You can make Gathee speak: "New message from $title: $text"
        }
    }
}
