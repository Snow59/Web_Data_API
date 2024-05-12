import com.example.demo.beans.Invocation;
import com.example.demo.beans.Monster;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvocationTest {

    @Test
    public void testLootRate() throws IOException {
        Invocation invocation = new Invocation();
        List<Monster> monsters = loadMonstersFromJson();

        Map<Integer, Double> expectedLootRates = new HashMap<>();
        for (Monster monster : monsters) {
            expectedLootRates.put(monster.get_id(), monster.getLootRate() * 100);
        }

        int totalInvocations = 10000;
        double marginOfError = 1;

        for (int monsterId : expectedLootRates.keySet()) {
            double expectedRate = expectedLootRates.get(monsterId);
            double actualRate = calculateLootRate(invocation, monsterId, totalInvocations);
            double lowerBound = expectedRate - marginOfError;
            double upperBound = expectedRate + marginOfError;

            String message = "Lootrate pour le monstre " + monsterId + " ==> Expected : " +
                    expectedRate + " ± " + marginOfError +
                    ", Actual : " + actualRate;

            assertEquals(expectedRate, actualRate, marginOfError, message);
            System.out.println(message);
        }
    }

    private double calculateLootRate(Invocation invocation, int monsterId, int totalInvocations) {
        int count = 0;
        for (int i = 0; i < totalInvocations; i++) {
            Monster monster = invocation.getRandomMonster();
            if (monster.get_id() == monsterId) {
                count++;
            }
        }
        return count * 100.0 / totalInvocations;
    }

    private List<Monster> loadMonstersFromJson() throws IOException {
        InputStream inputStream = new ClassPathResource("monstres.json").getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, new TypeReference<List<Monster>>() {});
    }
}
