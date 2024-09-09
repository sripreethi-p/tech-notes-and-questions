# Master-Slave Architecture

In database terminology, master-slave architecture (now often referred to as primary-replica or leader-follower) is a replication model where one database instance (the master) serves as the authoritative source, while one or more secondary instances (the slaves) are copies of the master database.

## Master (Primary):
- This is the main database where all write operations (insert, update, delete) are performed.
- The master instance handles all changes and propagates these changes to the slave instances.

## Slave (Replica):
- The slave databases replicate data from the master.
- They are typically used for read-only operations to reduce the load on the master.
- Slaves do not accept write operations (though there are configurations where limited writes can be enabled).
- If the master fails, a slave can sometimes be promoted to act as the new master.

## Use Cases:
### Scalability:
By offloading read queries to slave databases, the load on the master can be reduced, allowing better performance.
### Fault Tolerance: 
If the master fails, the system can switch to a slave to ensure continuity.
### Backup: 
Slave databases can be used to perform backups without affecting the master’s performance.

## Example:
- In a MySQL replication setup:
  - The master handles both read and write requests.
  - The slave databases replicate the data from the master and primarily handle read requests.

This architecture has become less popular due to the naming convention and the shift towards more modern, distributed database systems. Many systems now use terms like primary-replica to describe the same concept.