package com.example.win.newintern3.Utils;

import android.util.Log;

import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAO_SX on 2016/6/28/028.
 */
public class JsonUtils {
    public static <T> T getPerson(String jsonString, Class<T> cls) {
        T t = null;

        try {
//            Gson gson = new Gson();
            Gson gson  = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return t;
    }

    public static <T> ServiceListEntity<T> getServiceListEntity(String jsonString, Class<T> cls) {
        ServiceListEntity<T> listEntity = new ServiceListEntity<T>();

        try {

            JsonObject jsonObjects = new Gson().fromJson(jsonString, JsonObject.class);
            String code = jsonObjects.get("code").getAsString();
            jsonObjects.get("list").getAsJsonArray();

            List<T> arrayList = new ArrayList<T>();
            for (JsonElement jsonObject : jsonObjects.get("list").getAsJsonArray())
            {
                arrayList.add(new Gson().fromJson(jsonObject, cls));
            }
            listEntity.setList(arrayList);
            listEntity.setCode(code);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return listEntity;
    }

    public static <T> ServiceEntity<T> getServiceEntity(String jsonString, Class<T> cls) {
        ServiceEntity<T> entity = new ServiceEntity<T>();

        try {

            JsonObject jsonObjects = new Gson().fromJson(jsonString, JsonObject.class);
            String code = jsonObjects.get("code").getAsString();            ;
            T info = new Gson().fromJson(jsonObjects.get("entity").getAsJsonObject(), cls);

            entity.setEntity(info);
            entity.setCode(code);
        } catch (Exception e) {
            Log.e("json_error:",e.toString());
        }

        return entity;
    }

    public static <T> ArrayList<T> getEntityArrayList(String jsonString, Class<T> cls){
        Type type = new TypeToken<ArrayList<JsonObject>>() {}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(jsonString, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects)
        {
            arrayList.add(new Gson().fromJson(jsonObject, cls));
        }
        return arrayList;
    }
//    public static String  toJson( Class<T>  cls,Class<T>  cls2) {
//        String t = null;
//
//        try {
////            Gson gson = new Gson();
//            Gson gson  = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//            t = gson.toJson(cls);
//        } catch (Exception e) {
//            Log.e("json_error:",e.toString());
//        }
//
//        return t;
//    }
//

    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }
    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            // TODO Auto-generated method stub
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            // TODO Auto-generated method stub
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
