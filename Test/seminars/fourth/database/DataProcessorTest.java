package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void processorTest() {
        Database db = mock(Database.class);
        DataProcessor processor = new DataProcessor(db);

        when(db.query("query")).thenReturn(Arrays.asList("D1", "D2", "D3"));
        List<String> result = processor.processData("query");
        verify(db).query("query");
        assertThat(db.query("query")).isNotEmpty()
                .hasSize(3)
                .isEqualTo(result);

    }

}