CREATE TABLE IF NOT EXISTS Ingredient (
    id VARCHAR(4) PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);
CREATE TABLE IF NOT EXISTS Taco (
    id IDENTITY,
    name VARCHAR(50) NOT NULL,
    createdAT timestamp NOT NULL
);
CREATE TABLE IF NOT EXISTS Taco_Ingredients (
    taco BIGINT NOT NULL,
    ingredient VARCHAR(4) NOT NULL
);
ALTER TABLE Taco_Ingredients
ADD FOREIGN KEY (taco) REFERENCES Taco (id);
ALTER TABLE Taco_Ingredients
ADD FOREIGN KEY (ingredient) REFERENCES Ingredient (id);
CREATE TABLE IF NOT EXISTS Taco_Order (
    id IDENTITY,
    deliveryName VARCHAR(50) NOT NULL,
    deliveryStreet VARCHAR(50) NOT NULL,
    deliveryCity VARCHAR(50) NOT NULL,
    deliveryState VARCHAR(2) NOT NULL,
    deliveryZip VARCHAR(10) NOT NULL,
    ccExpiration VARCHAR(16) NOT NULL,
    ccCVV VARCHAR(3) NOT NULL,
    placedAt TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS Taco_Order_Tacos (
    tacoOrder BIGINT NOT NULL,
    taco BIGINT NOT NULL
);
alter table Taco_Order_Tacos
add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
add foreign key (taco) references Taco(id);