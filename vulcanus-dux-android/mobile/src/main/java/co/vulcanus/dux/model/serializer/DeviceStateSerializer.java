package co.vulcanus.dux.model.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import co.vulcanus.dux.model.DeviceState;
import co.vulcanus.dux.util.Constants;

/**
 * Created by ryan_turner on 10/19/15.
 */
public class DeviceStateSerializer implements JsonSerializer<DeviceState> {
    public JsonElement serialize(final DeviceState deviceState, final Type type, final JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        for(int i = deviceState.getFirstPin(); i < deviceState.getLastPin(); i++) {
            result.add("" + deviceState.getPin(i).getNumber(), new JsonPrimitive(deviceState.getPin(i).isHigh() ^ deviceState.isReverseLogic() ? 1 : 0));
        }
        return result;
    }
}
