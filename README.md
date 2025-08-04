
# 📚 Biblio-App

**Biblio-App** est une API simple pour la gestion des **livres**, **clients** et **emprunts** dans une bibliothèque.

Ce projet a été développé dans le cadre d’un **tutoriel éducatif YouTube** pour démontrer comment :
- Créer une API avec **Spring Boot**
- Connecter une application à une base de données **PostgreSQL**
- Utiliser les **annotations Spring** et les **DTOs**
- Initialiser une base de données avec **CommandLineRunner**
- Tester une API avec **Postman**

## ✨ Fonctionnalités principales
- **Gestion des clients** (CRUD)
- **Gestion des livres** (CRUD)
- **Gestion des emprunts** (CRUD)

---

## 🛠️ Technologies utilisées

### Backend
- **Java**
- **Spring Boot** (3.5.4)
- **Maven**

### Base de données
- **PostgreSQL**
- **Hibernate / JPA**

### Bibliothèques importantes
- **MapStruct** (pour le mapping DTO ↔ Entité)

---

## 🚀 Installation et démarrage

1. **Cloner le dépôt**
   ```bash
   git clone https://github.com/djeffing-dev/biblio-api.git


2. **Se déplacer dans le projet**

   ```bash
   cd biblio-api
   ```
3. **Configurer la base de données**

   * Modifier le fichier `src/main/resources/application.properties` :

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/nom_de_la_base
     spring.datasource.username=utilisateur
     spring.datasource.password=mot_de_passe
     ```
4. **Lancer l’application**

   ```bash
   mvn spring-boot:run
   ```

---

## 📡 Utilisation de l’API

### 📘 Livres

| Méthode  | Endpoint                      | Description               |
| -------- | ----------------------------- | ------------------------- |
| `GET`    | `/api/books`                  | Récupérer tous les livres |
| `POST`   | `/api/books`                  | Créer un livre            |
| `GET`    | `/api/books/findById?id={id}` | Récupérer un livre par ID |
| `PUT`    | `/api/books/update?id={id}`   | Mettre à jour un livre    |
| `DELETE` | `/api/books/delete?id={id}`   | Supprimer un livre        |

### 👥 Clients

| Méthode  | Endpoint                          | Description                |
| -------- | --------------------------------- | -------------------------- |
| `GET`    | `/api/customers`                  | Récupérer tous les clients |
| `POST`   | `/api/customers`                  | Créer un client            |
| `GET`    | `/api/customers/findById?id={id}` | Récupérer un client par ID |
| `PUT`    | `/api/customers/update?id={id}`   | Mettre à jour un client    |
| `DELETE` | `/api/customers/delete?id={id}`   | Supprimer un client        |

### 📄 Emprunts

| Méthode  | Endpoint                      | Description                 |
| -------- | ----------------------------- | --------------------------- |
| `GET`    | `/api/loans`                  | Récupérer tous les emprunts |
| `POST`   | `/api/loans`                  | Créer un emprunt            |
| `GET`    | `/api/loans/findById?id={id}` | Récupérer un emprunt par ID |
| `PUT`    | `/api/loans/update?id={id}`   | Mettre à jour un emprunt    |
| `DELETE` | `/api/loans/delete?id={id}`   | Supprimer un emprunt        |

---

## 📌 Exemple de requête : créer un emprunt

**Requête HTTP :**

```http
POST /api/loans
Content-Type: application/json

{
  "dateRetourEstimer": "2025-08-20",
  "customer": { "id": 54 },
  "book": { "id": 553 }
}
```

---

## 📬 Contact

* **Pseudo** : DJEFFING
* **LinkedIn** : [Jefferson Tsafack](https://linkedin.com/in/jefferson-tsafack-266a30294)
* **Email** : [deffing.dev@gmail.com](mailto:deffing.dev@gmail.com)
