### 1.1 Контрольні питання

1. **Призначення JFC фреймворку і його архітектура.**
    - JFC (Java Foundation Classes) - це набір бібліотек і фреймворків для розробки графічних інтерфейсів користувача (GUI) у Java.
    - Архітектура JFC включає Swing, Java 2D, Drag and Drop, і підтримку міжнародних різниць (Internationalization).

2. **Які переваги графічної бібліотеки Swing у порівнянні з бібліотекою AWT.**
    - Swing є наступником AWT і надає більш розширені можливості для створення користувацьких інтерфейсів.
    - Swing є легше розширюваним, більш гнучким і забезпечує більшу кросплатформенність.
    - В Swing доступні розширені компоненти, такі як таблиці, списки, дерева тощо.

3. **Навести приклад структури GUI програми на Java і пояснити призначення її елементів.**
    - Структура GUI програми може включати основне вікно (frame), панелі (panels), кнопки (buttons), текстові поля (text fields), мітки (labels) і т. д. Елементи призначені для відображення і взаємодії з користувачем.

4. **Пояснити призначення Containers в AWT/Swing. Що може використовуватися в якості Containers?**
    - Контейнери (Containers) в AWT/Swing використовуються для організації компонентів GUI. Наприклад, JFrame, JPanel, JWindow в Swing або Frame, Panel в AWT можуть використовуватися як контейнери.

5. **Навести приклади основних методів з класу Frame, що використовуються для розроблення GUI Java додатків.**
    - Деякі основні методи класу Frame включають `setSize(int width, int height)`, `setTitle(String title)`, `setVisible(boolean visible)`.

6. **Пояснити призначення об'єкта Panel. Як додати Components до Panel?**
    - Панель (Panel) є контейнером для групування і розміщення компонентів. Щоб додати компоненти до панелі, можна використати методи `add(Component comp)` або `setLayout(LayoutManager mgr)` для встановлення менеджера розміщення (Layout Manager).

7. **Пояснити призначення об'єктів типу event в пакеті java.awt.event. Як працює механізм оброблення подій в AWT / Swing?**
    - Об'єкти типу event представляють події, що виникають під час взаємодії користувача з програмою (наприклад, клік мишею, натискання клавіші тощо). Механізм оброблення подій в AWT/Swing базується на паттерні Observer, де компоненти реєструють слухачів подій, які реагують на події, коли вони виникають.

8. **Призначення інтерфейсів.**
    - Інтерфейси в Java визначають поведінку об'єктів і не містять реалізації методів. Вони використовуються для структуризації коду, реалізації поліморфізму і забезпечення абстракції. Наприклад, в AWT/Swing інтерфейси використовуються для реалізації обробників подій.