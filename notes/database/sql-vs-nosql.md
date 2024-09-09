# SQL vs NoSQL Databases

- [Properties](#properties-of-sql-and-nosql-databases)
- [Pros and Cons](#advantages--disadvantages)

## Properties of SQL and NoSQL databases
| Property        | SQL                                                                                                                                                                                                                                                                                                      | NoSQL                                                                                                                                                                                                                                                                                                                            |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Structure       | fixed schema                                                                                                                                                                                                                                                                                             | flexible schema                                                                                                                                                                                                                                                                                                                  |
| Data Model      | predefined tables with rows and columns                                                                                                                                                                                                                                                                  | variety of data models - document-based, key-value stores, column-family stores, and graph databases.                                                                                                                                                                                                                            |
| Relational      | YES. Data is related and organized into tables, and relationships between tables are established via keys (e.g., foreign keys)                                                                                                                                                                           | NO. Data is non relational                                                                                                                                                                                                                                                                                                       |
| ACID properties | compliant                                                                                                                                                                                                                                                                                                | NOT compliant                                                                                                                                                                                                                                                                                                                    |
| Examples        | MySQL, PostgreSQL, Oracle Database, Microsoft SQL Server                                                                                                                                                                                                                                                 | Document Stores: MongoDB, CouchDB ; Key-Value Stores: Redis, DynamoDB ; Column-Family Stores: Apache Cassandra, HBase ; Graph Databases: Neo4j, ArangoDB                                                                                                                                                                         |
| Query Language  | Structured Query Language (SQL)                                                                                                                                                                                                                                                                          | many - Redis : simple GET/PUT commands, Cassandra - CQL (Cassandra Query Language), MongoDB - a query language based on JSON-like syntax. Queries are constructed using methods and operators in the MongoDB shell or drivers.                                                                                                   |
| Scalability     | Vertical (increasing the capacity of a single server)                                                                                                                                                                                                                                                    | Horizontal (adding more servers to distribute the load)                                                                                                                                                                                                                                                                          |
| Consistency     | Strong                                                                                                                                                                                                                                                                                                   | Eventual (Often focus on high availability and partition tolerance (as per the CAP theorem) rather than strong consistency)                                                                                                                                                                                                      |
| When to use     | When data integrity and complex transactions are crucial. For applications with structured data and relationships, such as financial systems, customer relationship management (CRM), and enterprise resource planning (ERP). When you need strong consistency and complex queries with JOIN operations. | When dealing with large volumes of unstructured or semi-structured data. For applications requiring high performance and scalability, such as real-time web applications, big data analytics, and content management systems. When the schema is likely to evolve or when working with data that doesn’t fit neatly into tables. |


## Advantages & Disadvantages

| Feature            | SQL                                                 | NoSQL                                 |
|--------------------|-----------------------------------------------------|---------------------------------------|
| Schema Flexibility | ❌ NOT possible, the schema needs to be set in prior | ✅  schema can be adjusted as required |
|                    |                                                     |                                       |