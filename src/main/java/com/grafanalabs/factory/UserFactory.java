package com.grafanalabs.factory;

import com.grafanalabs.enums.UserType;
import com.grafanalabs.exception.GrafanaException;
import com.grafanalabs.factory.impl.CompanyUser;
import com.grafanalabs.factory.impl.NormalUser;

import java.util.Arrays;
import java.util.List;

public class UserFactory {
    private final List<UserProcessor> users = Arrays.asList(new CompanyUser(), new NormalUser());

    public UserProcessor getUser(UserType userType) {
        return users.stream()
                .filter(user -> user.getType() == userType)
                .findFirst()
                .orElseThrow(() -> new GrafanaException(String.format(" Invalid User Type - %s", userType)));
    }
}
