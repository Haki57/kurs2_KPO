package sample3.jsonserializer;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample3.jsonserializer.data.Car;

import static org.hamcrest.MatcherAssert.assertThat;

class JsonSerializerTest {
    @Test
    public void serializeNullObjectEnsureNullPointerExceptionThrown() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () ->  new JsonSerializer().serialize(null));
    }

    @Test
    public void serializeCarObjectEnsureCorrectOutputJson() throws Exception {
        JsonSerializer serializer = new JsonSerializer();
        Car testCar = new Car("Ford", "F150", "2018");
        String json = serializer.serialize(testCar);
System.out.println(json);
        assertThat(json, isExpectedCarJson(testCar));
    }

    private static Matcher<String> isExpectedCarJson(Car car) {
        return Matchers.isOneOf(
                "{\"manufacturer\":\"" + car.getMaker() + "\",\"model\":\"" + car.getModel() + "\"}",
                "{\"model\":\"" + car.getModel() + "\",\"manufacturer\":\"" + car.getMaker() + "\"}"
        );
    }
}