package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {
    @Test
    void testWeatherReporter(){
        WeatherService service = mock(WeatherService.class);
        WeatherReporter reporter = new WeatherReporter(service);
        when(service.getCurrentTemperature()).thenReturn(25);

        String report = reporter.generateReport();
        verify(service, times(1)).getCurrentTemperature();
        assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }


}