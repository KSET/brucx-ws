CREATE TABLE IF NOT EXISTS TICKET_TYPE (
  ID                SERIAL PRIMARY KEY,
  NAME              VARCHAR(50) NOT NULL,
  DEFAULT_PRICE     FLOAT       NULL,
  ACTIVE_FROM       DATE,
  ACTIVE_TO         DATE,
  REQUIRED_IN_TABLE VARCHAR(80) NULL
);