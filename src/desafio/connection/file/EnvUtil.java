package desafio.connection.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvUtil {

    private static final String ENV_FILE_PATH = ".env";

    public static String get(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(ENV_FILE_PATH)) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar variável de ambiente: " + key, e);
        }
    }
}
