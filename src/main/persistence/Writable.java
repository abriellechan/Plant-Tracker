package persistence;

import org.json.JSONObject;

//Sources: JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
