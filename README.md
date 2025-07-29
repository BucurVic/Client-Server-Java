# Registration System For Swimming Contest

## 📘 Overview

This system helps organize and manage a **national swimming contest**, enabling local offices to:

- Register participants
- View and search events
- Monitor live participant data

The project supports **multiple client-server configurations**:

- **Java server** + **C# clients**
- **C# server** + **Java clients**
- **React Web client** (with REST API and JWT authentication)

Communication is primarily handled via **TCP multithreaded sockets**, with support for:
- **gRPC** for high-performance RPC
- **Custom Protocol Buffers sync** for lightweight structured data exchange

---

## 🎯 Features

### 🔐 Authentication & Authorization
- JWT-based login system
- Secure role-based access for office staff
- Sessions maintained via tokens (used by both REST and Web client)

### 🏁 Event & Participant Management
- **View all events** (with current participant counts)
- **Search participants** by event
- **Register new participants** (multi-event registration allowed)
- **Real-time updates**: all clients reflect new registrations immediately

### 🚪 Logout
- Ends the current session and revokes access

---

## 🧱 Architecture

### 🧭 Pattern
Follows a **layered MVC architecture**:
- **Model**: Participant, Event, Registration, etc.
- **Repository**: SQL/ORM-based data access
- **Service**: Application logic
- **Controller/UI**: Handles user interactions and triggers services

### 🖧 Communication
- **TCP Sockets (Multithreaded)**: Core message passing
- **REST API**: For React web client
- **gRPC Services**: For efficient RPCs
- **Custom Protobuf Sync**: For lightweight updates between clients

### 💾 Persistence
- Relational database used across all versions
- Data loaded, saved, and synced via repositories

---

## 🖥️ Technologies

### 🧩 Back-End

| Feature                 | Java                     | C#                           |
|-------------------------|--------------------------|-------------------------------|
| ORM / DB Access         | JDBC / Hibernate         | ADO.NET / Entity Framework   |
| Network Communication   | Java Sockets             | .NET Sockets                 |
| REST API                | Spring Boot (if used)    | ASP.NET Core Web API         |
| gRPC / Protobuf         | grpc-java                | grpc-dotnet                  |
| Configuration           | `.properties` files      | `appsettings.json`           |
| Logging                 | SLF4J / Logback          | Serilog / NLog               |
| Authentication          | JWT via Spring Security  | JWT via ASP.NET Auth         |

### 🎨 Front-End

| Feature         | Java Client         | C# Client             | Web Client       |
|-----------------|---------------------|------------------------|------------------|
| UI Framework    | JavaFX              | Windows Forms / WPF   | React + Vite     |
| UI Pattern      | MVC                 | MVVM / MVC            | REST API Driven  |
| Auth Flow       | Manual login logic  | Manual login logic    | JWT login flow   |

---

## 🌐 Networking

- Multi-threaded TCP server
- Each client handled in a separate thread
- Updates about participant registration pushed to all clients
- Lightweight **Protocol Buffers** used for custom sync layer
- **gRPC** supports structured, versioned, and language-agnostic services

---

## 🔄 gRPC & Protobuf Integration

### ✅ gRPC Highlights
- Efficient binary RPC via **Protocol Buffers**
- Shared `.proto` contracts between Java and C#
- Used for:
  - Fetching events
  - Registering participants
- Enables tight schema versioning & backward compatibility

### 🔁 Custom Protobuf Sync (Bonus)
- Lightweight synchronization using raw protobuf messages
- Used as an alternative to gRPC when performance or manual control is desired
- Reduces overhead compared to traditional serialization

---

## 🚀 Running the System

### 🧪 Local Setup

1. Clone the repository
2. Launch the **server application** (Java or C#)
3. Run the **client application** (Java, C#, or Web)
4. For the React Web Client:
   ```bash
   cd react-client
   npm install
   npm run dev
