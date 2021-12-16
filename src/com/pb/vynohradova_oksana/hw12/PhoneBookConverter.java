package com.pb.vynohradova_oksana.hw12;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

public class PhoneBookConverter implements JsonSerializer<PhoneBook<Contact>>, JsonDeserializer<PhoneBook<Contact>> {

    @Override
    public JsonElement serialize(PhoneBook<Contact> phoneBook, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        for (Contact contact : phoneBook) {
            result.add(contact.getPerson(), context.serialize(contact));
        }

        return result;
    }

    @Override
    public PhoneBook<Contact> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        PhoneBook<Contact> phoneBook = new PhoneBook<>();
        JsonObject jsonObject = json.getAsJsonObject();

        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Contact contact = context.deserialize(entry.getValue(), Contact.class);
            contact.setPerson(entry.getKey(), false);
            phoneBook.add(contact);
        }

        return phoneBook;
    }
}
