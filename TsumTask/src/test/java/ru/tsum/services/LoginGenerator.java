package ru.tsum.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class LoginGenerator {
    public static String getNewLogin() throws IOException {
        Path userIdFilePath = new File("src/test/resources/UserName.txt").toPath();
        int id = Integer.parseInt(Files.readAllLines(userIdFilePath).get(0));
        Files.write(userIdFilePath, Collections.singletonList("" + (id + 1)), StandardOpenOption.CREATE);
        return "TestLogin" + id + "@mail.ru";
    }
}
