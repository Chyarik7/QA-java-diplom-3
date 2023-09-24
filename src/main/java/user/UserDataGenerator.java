package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {
    public static User getRandomUser(){
        final String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }
    public static User getRandomUserWithWrongPassword(){
        final String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(5);
        final String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }
}