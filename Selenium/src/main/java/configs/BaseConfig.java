package configs;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    /**
     * Метод возвращает параметр url из config.properties
     *
     * @return параметр строки поиска
     */
    String url();
}