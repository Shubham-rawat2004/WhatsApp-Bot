
# WhatsApp Bot Backend Simulation

A simple Spring Boot REST API that simulates the backend of a WhatsApp chatbot. The application accepts incoming messages through a webhook-style endpoint, applies predefined reply logic, and returns a structured JSON response.

This project is designed as a clean starter backend for chatbot workflows, demos, and Spring Boot learning.

## Features

- REST API endpoint for chatbot messages
- JSON request and response handling
- Predefined chatbot replies for common messages
- Validation for null or empty input
- Structured error responses
- SLF4J logging for request processing and validation events

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Validation
- Maven
- SLF4J with Spring Boot logging

## Project Structure

```text
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
src/
  main/
    java/com/example/whatsappbot/
      controller/
      model/
      service/
    resources/
<<<<<<< HEAD
API Endpoint
POST /webhook
Receives a message payload and returns a chatbot reply in JSON format.

Base URL

http://localhost:8081
Full URL

POST http://localhost:8081/webhook
Request Headers
Content-Type: application/json
Request Body
=======
```

## API Endpoint

### `POST /webhook`

Receives a message payload and returns a chatbot reply in JSON format.

**Base URL**

```text
http://localhost:8081
```

**Full URL**

```text
POST http://localhost:8081/webhook
```

### Request Headers

```http
Content-Type: application/json
```

### Request Body

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "message": "Hi",
  "sender": "Alice"
}
<<<<<<< HEAD
Success Response
Status: 200 OK

=======
```

### Success Response

Status: `200 OK`

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "reply": "Hello",
  "status": "success"
}
<<<<<<< HEAD
Supported Message Mapping
Incoming Message	Reply
Hi	Hello
Bye	Goodbye
Any other value	Sorry, I don't understand
Validation Error Response
If message is null, missing, or empty, the API returns:

Status: 400 Bad Request

{
  "error": "message must not be null or empty"
}
Sample Requests and Responses
Example 1: Greeting
Request:

=======
```

### Supported Message Mapping

| Incoming Message | Reply |
| --- | --- |
| `Hi` | `Hello` |
| `Bye` | `Goodbye` |
| Any other value | `Sorry, I don't understand` |

### Validation Error Response

If `message` is null, missing, or empty, the API returns:

Status: `400 Bad Request`

```json
{
  "error": "message must not be null or empty"
}
```

## Sample Requests and Responses

### Example 1: Greeting

Request:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "message": "Hi",
  "sender": "Alice"
}
<<<<<<< HEAD
Response:

=======
```

Response:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "reply": "Hello",
  "status": "success"
}
<<<<<<< HEAD
Example 2: Farewell
Request:

=======
```

### Example 2: Farewell

Request:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "message": "Bye",
  "sender": "Bob"
}
<<<<<<< HEAD
Response:

=======
```

Response:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "reply": "Goodbye",
  "status": "success"
}
<<<<<<< HEAD
Example 3: Unknown Message
Request:

=======
```

### Example 3: Unknown Message

Request:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "message": "What can you do?",
  "sender": "Charlie"
}
<<<<<<< HEAD
Response:

=======
```

Response:

```json
>>>>>>> b03db9b (Built Whatsapp Chatbot with specified requirement)
{
  "reply": "Sorry, I don't understand",
  "status": "success"
}
<<<<<<< HEAD
cURL Examples
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"Hi\",\"sender\":\"Alice\"}"
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"Bye\",\"sender\":\"Bob\"}"
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"\",\"sender\":\"David\"}"
How to Run Locally
Prerequisites
Java 17 or higher
Maven 3.8 or higher
Steps
Clone the repository or open the project folder.
Navigate to the project root.
Start the application:
mvn spring-boot:run
The API will be available at:
http://localhost:8080
Build the Project
mvn clean package
Logging
The project uses SLF4J with Spring Boot's default logging setup. Incoming requests, outgoing responses, and validation failures are logged to help with debugging and observability.

Future Improvements
Add unit and integration tests
Add Swagger/OpenAPI documentation
Add Docker support
Add environment-based configuration
Add database integration for chat history
Add richer intent handling and NLP integration
Add authentication and webhook verification
License
=======
```

## cURL Examples

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"Hi\",\"sender\":\"Alice\"}"
```

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"Bye\",\"sender\":\"Bob\"}"
```

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"\",\"sender\":\"David\"}"
```

## How to Run Locally

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher

### Steps

1. Clone the repository or open the project folder.
2. Navigate to the project root.
3. Start the application:

```bash
mvn spring-boot:run
```

4. The API will be available at:

```text
http://localhost:8081
```

### Build the Project

```bash
mvn clean package
```

## Logging

The project uses SLF4J with Spring Boot's default logging setup. Incoming requests, outgoing responses, and validation failures are logged to help with debugging and observability.

## Future Improvements

- Add unit and integration tests
- Add Swagger/OpenAPI documentation
- Add Docker support
- Add environment-based configuration
- Add database integration for chat history
- Add richer intent handling and NLP integration
- Add authentication and webhook verification

