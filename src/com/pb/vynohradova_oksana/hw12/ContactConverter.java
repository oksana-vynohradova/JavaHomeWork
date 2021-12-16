package com.pb.vynohradova_oksana.hw12;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ContactConverter implements JsonSerializer<Contact>, JsonDeserializer<Contact> {

    @Override
    public JsonElement serialize(Contact contact, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("phoneNumbers", contact.getPhoneNumbers().toString());

        if (contact.getDateOfBirth() != null) {
            result.addProperty("dateOfBirth", contact.getDateOfBirth().toString());
        }

        if (contact.getAddress() != null) {
            result.addProperty("address", contact.getAddress());
        }

        result.addProperty("editing", contact.getEditing().toString());

        return result;
    }

    @Override
    public Contact deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
//java.lang.ClassCastException: com.google.gson.JsonPrimitive cannot be cast to com.google.gson.JsonArray
        JsonObject jsonObject = json.getAsJsonObject();

        ArrayList<String> numbs = new ArrayList<>();
        if (jsonObject.get("phoneNumbers").isJsonPrimitive()) {
            String[] numbers1 = jsonObject
                    .get("phoneNumbers")
                    .getAsString()
                    .replaceAll("\\[|\\]", "")
                    .split(", ");
            numbs.addAll(Arrays.asList(numbers1));
        } else {
            JsonArray numbers2 = jsonObject.getAsJsonArray("phoneNumbers");
            for (JsonElement number : numbers2) {
            numbs.add(number.getAsString());
            }
        }

        Contact contact = new Contact(null, numbs);

        if (jsonObject.has("address")) {
            contact.setAddress(jsonObject.get("address").getAsString());
        }

        if (jsonObject.has("dateOfBirth")) {
            contact.setDateOfBirth(LocalDate.parse(jsonObject.get("dateOfBirth").getAsString()));
        }

        contact.setEditing(LocalDateTime.parse(jsonObject.get("editing").getAsString()));

        return contact;
    }
}
