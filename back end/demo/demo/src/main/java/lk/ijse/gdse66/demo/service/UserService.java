package lk.ijse.gdse66.demo.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private static final String API_URL = "https://88586822b4ba4bbe858cac2aa6e0cb9c.weavy.io/api/users";
    private static final String API_KEY = "wys_i8fQLwiXHNXQfJnjZq7jPCclFiiZaG3QNGCK";

    private final OkHttpClient client = new OkHttpClient();

    public String createUser() throws IOException {
        // Request body
        String json = "{\n" +
                "    \"id\": 2,\n" +
                "    \"uid\": \"user78990\",\n" +
                "    \"display_name\": \"Jane Elizabeth Smith\",\n" +
                "    \"email\": \"jane.doe@example.com\",\n" +
                "    \"given_name\": \"Jane\",\n" +
                "    \"middle_name\": \"Elizabeth\",\n" +
                "    \"name\": \"Jane Elizabeth Smith\",\n" +
                "    \"family_name\": \"Smith\",\n" +
                "    \"nickname\": \"Janie\",\n" +
                "    \"phone_number\": \"+0987654321\",\n" +
                "    \"comment\": \"Account created for new project development.\",\n" +
                "    \"metadata\": {\n" +
                "        \"color\": \"red\",\n" +
                "        \"size\": \"M\"\n" +
                "    },\n" +
                "    \"tags\": [\n" +
                "        \"developer\",\n" +
                "        \"team-lead\"\n" +
                "    ],\n" +
                "    \"directory\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"project-team\"\n" +
                "    },\n" +
                "    \"created_at\": \"2024-08-25T04:13:21.4566667Z\",\n" +
                "    \"is_bot\": true,\n" +
                "    \"is_suspended\": true\n" +
                "}";

        // Request
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        // Execute request
        try (Response response = client.newCall(request).execute()) {

            return response.body().string();
        }
    }

    public String getUser(String uid) throws IOException {
        // Request
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .get()
                .build();

        // Execute request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
