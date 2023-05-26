package ru.anton.springinactionbootmvc.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.anton.springinactionbootmvc.services.LoggedUserManagementService;
import ru.anton.springinactionbootmvc.services.LoginCountService;

//Процесс авторизации делается через Spring Security, пока делаем вручную
//@RequestScope ограничена областью видимости конкретного запроса
@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private String userName;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    //Должны обращаться к БД, пока хардкодим
    //Возвращает результат аутентификации
    public boolean login() {
        loginCountService.increment();

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
