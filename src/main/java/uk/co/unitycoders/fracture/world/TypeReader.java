package uk.co.unitycoders.fracture.world;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.w3c.dom.Attr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
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
        Set<Attribute> attrs = EnumSet.noneOf(Attribute.class);

        reader.beginObject();
        while (reader.hasNext()) {
            String tokenName = reader.nextName();
            if (tokenName.equals("id")) {
                id = reader.nextInt();
            } else if (tokenName.equals("name")) {
                name = reader.nextString();
            } else if (tokenName.equals("attrs") && reader.peek() != JsonToken.NULL) {
                attrs = getAttributes(reader);
            } else {
                System.out.println("unknown value: "+tokenName);
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Item(id, attrs);
    }

    public static Set<Attribute> getAttributes(JsonReader reader) throws IOException {
        EnumSet<Attribute> attributes = EnumSet.noneOf(Attribute.class);

        reader.beginArray();
        while(reader.hasNext()) {
            String name = reader.nextString();
            for (Attribute attr : Attribute.values()) {
                if (attr.name().equalsIgnoreCase(name)) {
                    attributes.add(attr);
                    break;
                }
            }
        }
        reader.endArray();

        return attributes;
    }


}
