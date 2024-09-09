# Fault Tolerance Patterns
These patterns ensure that a system can continue to function in the event of failures. Some common patterns include:

1. Retry Pattern: Automatically retry a failed operation a certain number of times before giving up. Useful when failures are transient.

2. Fallback Pattern: Provide a fallback behavior when an operation fails, such as returning a default value or an alternative service.

3. Timeout Pattern: Define a timeout for operations to prevent them from hanging indefinitely and consuming resources.

4. Bulkhead Pattern: Isolate components so that a failure in one doesn’t cascade to others. Think of it as partitioning the system.

5. Rate Limiting: Restrict the number of calls to a service within a certain time window to prevent overloading.

6. Circuit Breaker Pattern: Temporarily stop calls to a failing service to allow it time to recover.