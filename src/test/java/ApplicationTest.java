import com.dsa.algorithms.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends IntegrationTest {

    @Test
    void contextLoads() {
        if (isLocalRun()) {
            assertTrue(elasticsearchContainer.isRunning());
            assertTrue(kafkaContainer.isRunning());
        } else {
            assertNull(elasticsearchContainer);
            assertNull(kafkaContainer);
        }
    }
}
