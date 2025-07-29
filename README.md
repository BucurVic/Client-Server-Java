# 🏊‍♂️ Swimming Contest Registration System

## 📘 Overview

This application is used by the organizers of a national swimming contest to register participants from various local offices. It is implemented in two interchangeable versions:

- **Java server + C# clients**
- **C# server + Java clients**

Communication between clients and the server is achieved using **multithreaded TCP sockets**, with optional **gRPC** integration for modern and efficient RPC-based interaction.

---

## 🎯 Core Features

### 🔐 Login
- Office staff log into the system.
- After login, a new window displays all available swimming events (distance & style), including the current number of registered participants per event.

### 🔍 Search Participants
- Staff can search for participants registered in a specific event.
- Displayed info: participant's **name**, **age**, and **number of events** registered for.

### ➕ Register Participant
- A participant can be registered for multiple events.
- Staff enter the participant’s name, age, and select the events.
- All other clients across the country receive **real-time updates** automatically.

### 🚪 Logout
- The user logs out from the system securely.

---

## 🏗️ Architecture

- **Client-Server architecture** using **TCP socket-based communication** (multithreaded)
- **Relational database** for persistent data storage
- Follows the **MVC** pattern with the following layers:
  - **Model:** domain entities (e.g., Participant, Event, Registration)
  - **Repository:** handles database operations using SQL or ORM
  - **Service:** contains the business logic
  - **Controller/UI:** interfaces with the service layer
- Connection settings stored in a **config file**
- Logging implemented in the repository layer

---

## 🔧 Technologies Used

### 🖥️ Back-End

| Feature               | Java Version                | C# Version                   |
|-----------------------|-----------------------------|------------------------------|
| ORM / DB Access       | JDBC / Hibernate            | ADO.NET / Entity Framework   |
| Network Communication | Java Sockets                | .NET Sockets                 |
| Configuration         | Java `.properties` file     | `appsettings.json`           |
| Logging               | SLF4J / Logback             | Serilog / NLog               |

### 🎨 Front-End

| Feature         | Java Client         | C# Client                   |
|-----------------|---------------------|-----------------------------|
| UI Framework    | JavaFX              | Windows Forms / WPF         |
| UI Pattern      | MVC-based Controller| MVVM / MVC                  |

---

## 🌐 Networking

- Low-level **TCP sockets** used for communication
- Server handles **multiple simultaneous clients** via threads
- **Real-time client notification** ensures UI updates automatically when changes occur (e.g., participant registered)

---

## 🔄 gRPC Integration (Bonus)

As a bonus enhancement, **gRPC** is integrated to modernize parts of the communication.

### ✅ Why gRPC?

- Fast, type-safe remote calls using **Protocol Buffers**
- Easy interoperability between **Java** and **C#**
- Better scalability and schema consistency than raw sockets

### 🛠️ Implementation Notes

- `.proto` files define shared services and messages
- At least two domain entities exposed via gRPC (e.g., `ParticipantService`, `InscriereService`)
- Server hosts the gRPC services
- Client consumes those services to:
  - Retrieve events
  - Register participants remotely
- **gRPC complements** the socket-based approach for selected operations
