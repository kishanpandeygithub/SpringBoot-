# Spring Boot JPA Practice Task

## Bank Account Management System

### Objective

Build a REST API for a **Bank Account Management System** to practice:

**Controller → Service → Repository → Spring Data JPA → MySQL**

The purpose of this task is to strengthen basic CRUD operations and understand how Controller, Service, Repository,
Entity, JPA, and MySQL interact.

---

## Technology Requirements

Use only:

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- ResponseEntity
- Postman for API testing

Do **NOT** use DTOs, Lombok, Spring Security, JWT, entity relationships, JPQL/custom queries, or advanced exception
handling.

---

## Entity: `BankAccount`

Create a `BankAccount` entity containing:

| Field         | Type    |
|---------------|---------|
| id            | Long    |
| accountNumber | String  |
| holderName    | String  |
| email         | String  |
| phoneNumber   | String  |
| accountType   | String  |
| balance       | Double  |
| branchName    | String  |
| active        | boolean |

### Requirements

- `id` must be the primary key.
- `id` must be automatically generated.
- Data must be stored in MySQL using JPA/Hibernate.

---

## Required REST APIs

| Method | Endpoint                               | Operation                 |
|--------|----------------------------------------|---------------------------|
| POST   | `/api/accounts`                        | Create a new bank account |
| GET    | `/api/accounts`                        | Get all bank accounts     |
| GET    | `/api/accounts/{id}`                   | Get account by ID         |
| PUT    | `/api/accounts/{id}`                   | Update complete account   |
| DELETE | `/api/accounts/{id}`                   | Delete account            |
| PATCH  | `/api/accounts/{id}/deposit/{amount}`  | Deposit money             |
| PATCH  | `/api/accounts/{id}/withdraw/{amount}` | Withdraw money            |
| PATCH  | `/api/accounts/{id}/activate`          | Activate account          |
| PATCH  | `/api/accounts/{id}/deactivate`        | Deactivate account        |

---

## Business Rules

### Account Creation

- Initial balance cannot be negative.
- Account must be stored in MySQL.

### Get Account

- Handle `Optional<BankAccount>` properly.
- Handle the situation where the requested account does not exist.

### Update Account

- Find the existing account first.
- Update its fields.
- Save the updated entity using JPA.

### Delete Account

- Check whether the account exists before deleting it.

### Deposit

- Deposit amount must be greater than `0`.
- Add the amount to the existing balance.
- Save the updated account.

### Withdrawal

- Withdrawal amount must be greater than `0`.
- Withdrawal amount cannot exceed the available balance.
- Withdrawal must not be allowed if the account is inactive.
- Save the updated balance.

### Activate / Deactivate

- `/activate` must set `active = true`.
- `/deactivate` must set `active = false`.

---

## Required Project Structure

```text
src/main/java/...
│
├── controller/
│   └── BankAccountController.java
│
├── service/
│   └── BankAccountService.java
│
├── repository/
│   └── BankAccountRepository.java
│
├── entity/
│   └── BankAccount.java
│
└── BankApplication.java
```

Follow this application flow:

```text
Postman
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Spring Data JPA / Hibernate
   ↓
MySQL
```

**Important:** Controller must communicate with Service. Service must communicate with Repository. Do not directly use
Repository inside Controller.

---

# Final Challenge — Money Transfer

After completing all CRUD operations, implement:

```http
PATCH /api/accounts/{fromId}/transfer/{toId}/{amount}
```

### Example

Before transfer:

```text
Account 1 — Kishan
Balance: ₹10,000

Account 2 — Rahul
Balance: ₹4,000
```

Request:

```http
PATCH /api/accounts/1/transfer/2/2500
```

After transfer:

```text
Kishan: ₹10,000 → ₹7,500
Rahul:  ₹4,000  → ₹6,500
```

### Transfer Rules

- Both accounts must exist.
- Transfer amount must be greater than `0`.
- Sender must have sufficient balance.
- Sender must be active.
- Receiver must be active.
- Deduct money from sender.
- Add money to receiver.
- Save both updated accounts using JPA.

---

## Completion Criteria

The task is complete when all **9 main APIs + 1 transfer API** work correctly through Postman and changes are correctly
reflected in MySQL.

**Main Goal:** Understand and practice the complete Spring Boot CRUD lifecycle rather than copying code.