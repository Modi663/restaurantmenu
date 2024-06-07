## API Документация для Restaurant Menu

### Базовый URL
`http://localhost:8080`

### Публичные эндпоинты

#### 1. Получить меню

**URL:** `/menu`

**Метод:** `GET`

**Описание:** Возвращает список всех доступных товаров (меню).

**Пример запроса:**
```sh
GET /menu
```

**Пример ответа:**
```json
[
  {
    "id": 1,
    "name": "Spaghetti Carbonara",
    "description": "Classic Italian pasta dish with eggs, cheese, pancetta, and pepper.",
    "price": 12.99,
    "imageUrl": "https://example.com/images/carbonara.jpg"
  },
  {
    "id": 2,
    "name": "Margherita Pizza",
    "description": "Pizza with tomato, mozzarella, and basil.",
    "price": 9.99,
    "imageUrl": "https://example.com/images/margherita.jpg"
  }
]
```

#### 2. Получить контактную информацию

**URL:** `/contact`

**Метод:** `GET`

**Описание:** Возвращает контактную информацию ресторана.

**Пример запроса:**
```sh
GET /contact
```

**Пример ответа:**
```json
{
  "address": "Musterstraße 1, 12345 Musterstadt",
  "phone": "01234 / 567890",
  "email": "info@restaurant.de"
}
```

### Эндпоинты админ-панели

#### 1. Получить список товаров

**URL:** `/admin/items`

**Метод:** `GET`

**Описание:** Возвращает список всех товаров для администрирования.

**Пример запроса:**
```sh
GET /admin/items
```

**Пример ответа:**
```json
[
  {
    "id": 1,
    "name": "Spaghetti Carbonara",
    "description": "Classic Italian pasta dish with eggs, cheese, pancetta, and pepper.",
    "price": 12.99,
    "imageUrl": "https://example.com/images/carbonara.jpg"
  },
  {
    "id": 2,
    "name": "Margherita Pizza",
    "description": "Pizza with tomato, mozzarella, and basil.",
    "price": 9.99,
    "imageUrl": "https://example.com/images/margherita.jpg"
  }
]
```

#### 2. Добавить новый товар

**URL:** `/admin/items/add`

**Метод:** `POST`

**Описание:** Добавляет новый товар в меню.

**Параметры:**

- `name` (string): Название товара.
- `description` (string): Описание товара.
- `price` (double): Цена товара.
- `imageUrl` (string): URL изображения товара.

**Пример запроса:**
```sh
POST /admin/items/add
Content-Type: application/x-www-form-urlencoded

name=New+Dish&description=Delicious+new+dish&price=15.99&imageUrl=https://example.com/images/newdish.jpg
```

**Пример ответа:**
```json
{
  "id": 3,
  "name": "New Dish",
  "description": "Delicious new dish",
  "price": 15.99,
  "imageUrl": "https://example.com/images/newdish.jpg"
}
```

#### 3. Редактировать товар

**URL:** `/admin/items/edit/{id}`

**Метод:** `POST`

**Описание:** Редактирует информацию о существующем товаре.

**Параметры:**

- `id` (long): Идентификатор товара.
- `name` (string): Название товара.
- `description` (string): Описание товара.
- `price` (double): Цена товара.
- `imageUrl` (string): URL изображения товара.

**Пример запроса:**
```sh
POST /admin/items/edit/1
Content-Type: application/x-www-form-urlencoded

name=Updated+Dish&description=Updated+description&price=17.99&imageUrl=https://example.com/images/updateddish.jpg
```

**Пример ответа:**
```json
{
  "id": 1,
  "name": "Updated Dish",
  "description": "Updated description",
  "price": 17.99,
  "imageUrl": "https://example.com/images/updateddish.jpg"
}
```

#### 4. Удалить товар

**URL:** `/admin/items/delete/{id}`

**Метод:** `GET`

**Описание:** Удаляет товар из меню.

**Пример запроса:**
```sh
GET /admin/items/delete/1
```

**Пример ответа:**
```json
{
  "message": "Item with id 1 has been deleted."
}
```

### Авторизация и аутентификация

#### Логин

**URL:** `/login`

**Метод:** `POST`

**Описание:** Страница логина для администраторов.

**Параметры:**

- `username` (string): Имя пользователя.
- `password` (string): Пароль.

**Пример запроса:**
```sh
POST /login
Content-Type: application/x-www-form-urlencoded

username=admin&password=admin_password
```

**Пример ответа:**
```json
{
  "message": "Login successful"
}
```

#### Логаут

**URL:** `/logout`

**Метод:** `GET`

**Описание:** Выполняет выход пользователя из системы.

**Пример запроса:**
```sh
GET /logout
```

**Пример ответа:**
```json
{
  "message": "You have been logged out."
}
```