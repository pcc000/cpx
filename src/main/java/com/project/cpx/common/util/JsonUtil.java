package com.project.cpx.common.util;

import com.google.gson.*;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/21 22:35
 * @Description:
 */
public class JsonUtil {
    public JsonUtil() {
    }

    public static String toJson(Object src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        Gson gson = new Gson();
        return gson.toJson(src, typeOfSrc);
    }

    public static void toJson(Object src, Appendable writer) throws Exception {
        Gson gson = new Gson();
        gson.toJson(src, writer);
    }

    public static void toJson(Object src, Type typeOfSrc, Appendable writer) throws Exception {
        Gson gson = new Gson();
        gson.toJson(src, typeOfSrc, writer);
    }

    public static String toJson(JsonElement jsonElement) {
        Gson gson = new Gson();
        return gson.toJson(jsonElement);
    }

    public static <T> T fromJson(String src, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(src, type);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(String json, Class<T> classOfT, JsonDeserializer<T> deserializer) {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(classOfT, deserializer).create();
        return gson.fromJson(json, classOfT);
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        Gson gson = new Gson();
        List<T> list = new ArrayList();
        JsonArray array = (new JsonParser()).parse(json).getAsJsonArray();
        Iterator var5 = array.iterator();

        while(var5.hasNext()) {
            JsonElement elem = (JsonElement)var5.next();
            list.add(gson.fromJson(elem, clazz));
        }

        return list;
    }
}
