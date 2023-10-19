package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void testBooking(){
        int room = 24;
        HotelService service = mock(HotelService.class);
        BookingService booking = new BookingService(service);
        when(service.isRoomAvailable(room)).thenReturn(true);
        boolean check = booking.bookRoom(room);

        verify(service).isRoomAvailable(room);
        assertThat(check).isEqualTo(true);

    }
}