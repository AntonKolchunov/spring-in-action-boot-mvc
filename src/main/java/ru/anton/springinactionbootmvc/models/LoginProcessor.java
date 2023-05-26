package ru.anton.springinactionbootmvc.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.anton.springinactionbootmvc.services.LoggedUserManagementService;

//Процесс авторизации делается через Spring Security, пока делаем вручную
//@RequestScope ограничена областью видимости конкретного запроса
@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private String userName;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    //Должны обращаться к БД, пока хардкодим
    //Возвращает результат аутентификации
    public boolean login() {
        String username = this.getUserName();
        String password = this.getPassword();

        boolean loginResult = false;

        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
