to run the project run:
    .\mvnw spring-boot:run
For testing:
    .\mvnw test










## Task 3 - JDBC vs JdbcClient

With raw JDBC I have to open/close the Connection, PreparedStatement and
ResultSet myself, copy every column into the record by hand, and handle the
checked SQLException. JdbcClient does resource handling, row mapping
(columns → record fields) and exception translation for me.

### Duplicate product name
**Where the translation happens:** inside Spring's `JdbcTemplate`, which `JdbcClient`
uses internally. It catches the vendor-specific, checked `SQLException` and uses an
`SQLExceptionTranslator` to map the error code to Spring's unchecked
`DataAccessException` hierarchy (here `DuplicateKeyException`). My code therefore
doesn't depend on H2-specific classes and doesn't have to catch `SQLException`.

