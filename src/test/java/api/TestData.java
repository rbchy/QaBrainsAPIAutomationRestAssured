package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;

/** Reads src/test/resources/testdata.json once and hands out payloads as maps. */
public final class TestData {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final JsonNode ROOT = load();

    private TestData() {
    }

    private static JsonNode load() {
        try (InputStream in = TestData.class.getClassLoader().getResourceAsStream("testdata.json")) {
            if (in == null) {
                throw new IllegalStateException("testdata.json not found in src/test/resources");
            }
            return MAPPER.readTree(in);
        } catch (Exception e) {
            throw new IllegalStateException("Could not read testdata.json", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> payload(String key) {
        JsonNode node = ROOT.get(key);
        if (node == null) {
            throw new IllegalArgumentException("No test data named '" + key + "' in testdata.json");
        }
        return MAPPER.convertValue(node, Map.class);
    }

    public static int intValue(String key) {
        return ROOT.get(key).asInt();
    }

    public static String text(String key) {
        return ROOT.get(key).asText();
    }
}
