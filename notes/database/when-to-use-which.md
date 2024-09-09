# When to use which DB

|                         | PostgreSQL                                                                                                               | Oracle DB                                                                                                      | Cassandra DB                                                                                                                          | Mongo DB                                                                                                      | Elasticsearch                                                                                                                                         | Redis                                                                                    |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| Use Case                | Traditional relational database requirements with ACID compliance, complex queries, and support for advanced data types. | Large-scale enterprise applications that require high availability, scalability, and robust security features. | Distributed NoSQL database designed for handling large amounts of data across many commodity servers with no single point of failure. | Document-based NoSQL database suited for applications requiring flexible schemas and fast development cycles. | Search and analytics engine optimized for full-text search, data indexing, and real-time data exploration.                                            | In-memory key-value store used for caching, real-time analytics, and session management. |
| Transaction Requirement | Transactions with complex joins & aggregations                                                                           | Transactions with high data volumes                                                                            | Faster 'WRITE' transactions like time-series data, logging, IoT, and real-time analytics.                                             | Large scale transactions                                                                                      | Full-text search functionality with fast search and filtering capabilities                                                                            | Fast read and write operations with data persistence options                             |
| Schema Flexibility      | Strict pre decided schemas                                                                                               | Fixed schema                                                                                                   | Flexible schema                                                                                                                       | Best for cases of rapidly changing schema requirements                                                        | Flexible till a certain level                                                                                                                         | Schema is usually KEY-VALUE pairs, while VALUE can have any data structure               |
| Examples                | Financial systems, complex enterprise applications, and geographic data handling                                         | Large financial institutions, telecom, ERP systems, and complex legacy applications.                           | Social media platforms, IoT applications, and real-time data analytics.                                                               | Content management systems, real-time analytics, mobile applications, and catalogs.                           | Search engines for websites, log/metrics monitoring (e.g., using ELK stack: Elasticsearch, Logstash, and Kibana), and product recommendation engines. | Caching for web applications, real-time gaming leaderboards, and session storage.        |

## Choosing the Right Database

- **Relational Data:** Use PostgreSQL or Oracle DB for structured data that requires ACID compliance and complex transactions.  


- **High-Volume, Distributed Data:** Use Cassandra for highly scalable and available solutions where eventual consistency is acceptable.  


- **Semi-Structured Data:** Use MongoDB for applications where flexible schema and rapid development are priorities.  


- **Search and Analytics:** Use Elasticsearch for applications requiring fast full-text search and data analytics.  


- **In-Memory Data:** Use Redis for caching, session management, and real-time data access where speed is crucial.  

## Example Scenarios

### 1. E-Commerce Web Application
- **Problem:** You need a reliable relational database for handling transactions, user information, and product catalog. The application requires strong ACID (Atomicity, Consistency, Isolation, Durability) properties to ensure the consistency of financial transactions.
- **Suitable Database: PostgreSQL**
  - **Why:** PostgreSQL is a powerful, open-source relational database with full ACID compliance. It’s ideal for structured data with complex queries, transactional consistency, and integration with various ORM frameworks.
  - **Example:** An e-commerce platform like Etsy could use PostgreSQL for maintaining its user accounts, order histories, and transactional records due to the need for strong consistency.

### 2. Large-Scale Enterprise Financial System
- **Problem:** You need a database to manage a large volume of complex transactions across multiple branches globally, with built-in support for advanced features like partitioning, clustering, and high-availability setups.
- **Suitable Database: Oracle DB**
  - **Why:** Oracle DB is designed for large enterprises that need a robust, feature-rich relational database with advanced security, scalability, and performance optimization for financial systems. It also offers strong support for distributed transactions.
  - **Example:** A multinational bank might use Oracle DB to handle financial transactions, customer data, and reporting needs across its global network.

### 3. Social Media Platform with Massive Data Scale
- **Problem:** You need a database capable of handling large volumes of data distributed across multiple servers with high write throughput and horizontal scalability. The data is time-series based, such as user posts, likes, and comments.
- **Suitable Database: Cassandra**
  - **Why:** Cassandra is a distributed NoSQL database optimized for high write throughput, horizontal scalability, and fault tolerance. It is perfect for handling large volumes of data with high availability across multiple data centers.
  - **Example:** Instagram uses Cassandra to manage billions of user interactions (likes, comments, posts) efficiently across its distributed architecture.

### 4. Content Management System for Blogs/Media
- **Problem:** You need a flexible database to store semi-structured or unstructured data like blog posts, comments, images, and metadata. The schema may evolve over time, and you prefer a JSON-like document structure.
- **Suitable Database: MongoDB**
  - **Why:** MongoDB is a NoSQL document-oriented database that stores data in flexible, JSON-like documents. It’s great for handling semi-structured data and can scale horizontally. It also supports features like indexing and rich queries.
  - **Example:** Content management system like WordPress could use MongoDB to store blog posts, user profiles, and media files, allowing easy schema changes as content types evolve.

### 5. Search Engine for a Website
- **Problem:** You need a search engine capable of indexing large amounts of text data and providing fast full-text search capabilities with support for ranking, filtering, and aggregations.
- **Suitable Database: Elasticsearch**
  - **Why:** Elasticsearch is a distributed search and analytics engine built on top of Apache Lucene. It excels at full-text search, complex queries, and real-time analytics across large data sets.
  - **Example:** A job search platform like LinkedIn could use Elasticsearch to allow users to quickly search for jobs, filter results, and rank them based on relevance.

### 6. Real-Time Analytics and Caching
- **Problem:** You need a high-performance in-memory database for caching frequently accessed data and performing real-time analytics. The application requires low latency and high throughput.
- **Suitable Database: Redis**
  - **Why:** Redis is an in-memory key-value store known for its ultra-fast performance, making it ideal for use cases like caching, session management, real-time analytics, and leaderboards.
  - **Example:** A real-time bidding system in online advertising could use Redis to cache bidding data and compute auction results with sub-millisecond latency.