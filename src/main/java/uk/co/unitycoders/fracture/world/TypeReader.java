package uk.co.unitycoders.fracture.world;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by webpigeon on 18/01/14.
 */
public class TypeReader {

    public static Map<Integer, Item> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readItemArray(reader);
        } finally {
            reader.close();
        }
    }

    public static Map<Integer, Item> readItemArray(JsonReader reader) throws IOException {
        Map<Integer,Item> messages = new TreeMap<Integer,Item>();

        reader.beginArray();
        while (reader.hasNext()) {
            Item item = readItem(reader);
            messages.put(item.getType(), item);
        }
        reader.endArray();
        return messages;
    }

    public static Item readItem(JsonReader reader) throws IOException {
        int id = -1;
        String name = null;
        Boolean walkable = false;
        Boolean gettable = false;

        reader.beginObject();
        while (reader.hasNext()) {
            String tokenName = reader.nextName();
            if (tokenName.equals("id")) {
                id = reader.nextInt();
            } else if (tokenName.equals("name")) {
                name = reader.nextString();
            } else if (tokenName.equals("walkable") && reader.peek() != JsonToken.NULL) {
                walkable = reader.nextBoolean();
            } else if (tokenName.equals("gettable")) {
                gettable = reader.nextBoolean();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Item(id, walkable, gettable);
    }


}
