-- *** User ***
CREATE TABLE User (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  username            VARCHAR(255) NOT NULL,
  password	          VARCHAR(255) NOT NULL,
  authorities	          VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID),
);