package com.example.userLogin.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userLogin.Entity.User;
import com.example.userLogin.Util.AuthUtil;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<User> registerUser(User user) {
        String url = "http://localhost:8079/api/users/register";

        HttpHeaders headers = new HttpHeaders();
        String encodedCredentials = AuthUtil.encodeCredentials("admin", "admin");
        headers.set("Authorization", "Basic " + encodedCredentials);
        headers.set("Content-Type", "application/json");

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        return restTemplate.exchange(url, HttpMethod.POST, request, User.class);
    }
}
