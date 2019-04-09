CREATE TABLE Item (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name                VARCHAR(255) NOT NULL,
  description         VARCHAR(255),
  price               DOUBLE NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT UC_Item_name UNIQUE(name)
);

CREATE TABLE Customer (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  firstName           VARCHAR(255),
  lastName         	  VARCHAR(255),
  PRIMARY KEY (ID),
);

CREATE TABLE OrderSummary (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  price               DOUBLE NOT NULL,
  ownerId 			  BIGINT NOT NULL,
  creationDate 		  DATE NOT NULL,
  status 			  VARCHAR(255),
  PRIMARY KEY (ID),
  FOREIGN KEY (ownerId) references Customer(Id)
);

CREATE TABLE OrderPosition (
  orderId 			  BIGINT NOT NULL,
  itemId 		  	  BIGINT NOT NULL,
  FOREIGN KEY (orderId) references OrderSummary(Id),
  FOREIGN KEY (itemId) references Item(Id)
);