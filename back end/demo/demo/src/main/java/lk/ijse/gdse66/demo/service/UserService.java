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
        String json = "{\n" +
                "    \"uid\": \"user78090\",\n" +
                "    \"email\": \"jane.doe@example.com\",\n" +
                "    \"given_name\": \"Jane\",\n" +
                "    \"middle_name\": \"Elizabeth\",\n" +
                "    \"name\": \"Jane Elizabeth Smith\",\n" +
                "    \"family_name\": \"Smith\",\n" +
                "    \"nickname\": \"Janie\",\n" +
                "    \"phone_number\": \"+0987654321\",\n" +
                "    \"comment\": \"Account created for new project development.\",\n" +
                "    \"picture\": \"https://example.com/profile-pic-jane.jpg\",\n" +
                "    \"directory\": \"project-team\",\n" +
                "    \"metadata\": {\n" +
                "        \"color\": \"red\",\n" +
                "        \"size\": \"M\"\n" +
                "    },\n" +
                "    \"tags\": [\"developer\", \"team-lead\"],\n" +
                "    \"is_suspended\": true,\n" +
                "    \"is_bot\": true\n" +
                "}\n";

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {

            return response.body().string();
        }
    }

    public String getUser(String uid) throws IOException {
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
