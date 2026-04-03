# SimplePlugin (Minecraft / Paper)

Готовый стартовый плагин для Minecraft (Paper/Spigot API), который добавляет 2 команды:

- `/hello` — отправляет приветственное сообщение.
- `/heal` — полностью лечит игрока.

## Структура

- `src/main/java/com/mrbrek/simpleplugin/SimplePlugin.java` — основной класс плагина.
- `src/main/resources/plugin.yml` — описание плагина, команд и прав.
- `pom.xml` — Maven-конфигурация для сборки `.jar`.

## Сборка

Требования:

- Java 17+
- Maven 3.9+

Команда сборки:

```bash
mvn clean package
```

После сборки `.jar` будет в папке:

```text
target/simpleplugin-1.0.0.jar
```

## Установка

1. Останови сервер Minecraft.
2. Скопируй `target/simpleplugin-1.0.0.jar` в папку `plugins`.
3. Запусти сервер.

## Проверка

В игре выполни:

- `/hello`
- `/heal`

Если захочешь, я могу в следующем шаге добавить:

- собственный конфиг (`config.yml`),
- кулдаун на команды,
- GUI-меню,
- систему пермишенов по группам.
