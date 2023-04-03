package com.procemetrix.tasks.infrastructure.adapters;

import com.procemetrix.tasks.domain.models.AdditionalTaskInfo;
import com.procemetrix.tasks.domain.ports.out.ExternalServicePort;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> responseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo jsonPlaceHolderTodo = responseEntity.getBody();
        if (jsonPlaceHolderTodo == null) return null;

        apiUrl = "https://jsonplaceholder.typicode.com/users/"+jsonPlaceHolderTodo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseEntityUser = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser jsonPlaceHolderUser = responseEntityUser.getBody();
        if (jsonPlaceHolderUser == null) return null;

        return new AdditionalTaskInfo(jsonPlaceHolderUser.getId(), jsonPlaceHolderUser.getName(), jsonPlaceHolderUser.getEmail());
    }

    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
