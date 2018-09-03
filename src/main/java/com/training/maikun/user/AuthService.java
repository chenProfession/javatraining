package com.training.maikun.user;

import com.training.maikun.result.ResultView;

public interface AuthService {
    ResultView register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
