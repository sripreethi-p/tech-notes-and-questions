# Designing RESTful APIs

Designing RESTful APIs involves creating a stateless, client-server architecture that adheres to a set of principles for web services. Here’s an overview of the key principles and best practices:

## 1. Use Meaningful Resource URIs
Use nouns (not verbs) in the endpoint paths to represent resources.

```java
GET /users          // Retrieves a list of users
POST /users         // Creates a new user
GET /users/{id}     // Retrieves a specific user by ID
PUT /users/{id}     // Updates an existing user by ID
DELETE /users/{id}  // Deletes a user by ID
```


## 2. HTTP Methods
Use the appropriate HTTP methods:
- GET: Retrieve resources.
- POST: Create new resources.
- PUT: Update existing resources.
- PATCH: Partially update resources.
- DELETE: Remove resources.

## 3. Statelessness
Each request from a client to a server must contain all the information the server needs to fulfill the request. 
No client context is stored on the server between requests.

## 4. Versioning
Use versioning in your API to avoid breaking changes:
- Example: `/v1/users`

## 5. Content Negotiation
Use HTTP headers to handle content negotiation (e.g., `Accept`, `Content-Type`) to specify response formats (`JSON`, `XML`, etc.).

## 6. HATEOAS (Hypermedia as the Engine of Application State)
Provide links in the response that allow the client to navigate the API. This helps with discoverability and user experience.

- Example :
```json
{
  "id": 123,
  "name": "John Doe",
  "links": {
    "self": "/users/123",
    "orders": "/users/123/orders"
  }
}
```

## 7. Proper Use of Status Codes
Use appropriate HTTP status codes to indicate the result of the API request:
* 200 OK: Success
* 201 Created: Resource successfully created
* 204 No Content: Successful request, but no response body
* 400 Bad Request: Invalid input
* 401 Unauthorized: Authentication failure
* 403 Forbidden: Authorization failure
* 404 Not Found: Resource not found
* 500 Internal Server Error: Server encountered an unexpected condition

## 8. Error Handling
Provide meaningful error messages in the response body to help clients understand the error.
- Example : 
```json
{
  "error": "Invalid input",
  "details": "The 'email' field must be a valid email address."
}
```

## 9. Security
* Use HTTPS to encrypt communications.
* Implement authentication (e.g., OAuth 2.0, JWT).
* Enforce authorization to ensure users can only access permitted resources.

## 10. Rate Limiting
Implement rate limiting to prevent abuse and ensure that the service can scale effectively.

## 11. Pagination, Filtering, and Sorting
Use query parameters for pagination (`?page=1&limit=20`), filtering (`?status=active`), and sorting (`?sort=createdAt&order=desc`).
- Example:
```text
GET /users?page=1&limit=10&sort=name&order=asc
```

## 12. Caching
Leverage caching headers (e.g., `ETag`, `Cache-Control`) to reduce server load and improve response times.

## 13. Documentation
Provide thorough and user-friendly API documentation (e.g., Swagger, Postman collections) to help developers understand how to use the API.
