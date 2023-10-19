package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Test
    void testNotification() {
        MessageService ms = mock(MessageService.class);
        NotificationService nt = new NotificationService(ms);
        ms.sendMessage("Hello", "Artem");
        verify(ms).sendMessage("Hello", "Artem");

    }
}