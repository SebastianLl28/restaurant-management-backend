CREATE TABLE customer
(
    id     BIGINT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(255) NOT NULL,
    email  VARCHAR(255) NOT NULL,
    phone  VARCHAR(255) NOT NULL,
    status TINYINT(1)   NOT NULL DEFAULT 1
);

CREATE TABLE user
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    customer_id BIGINT       NOT NULL,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_customer_fk FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE category
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    status    TINYINT(1)   NOT NULL DEFAULT 1
);

CREATE TABLE product
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(255)   NOT NULL,
    description  TEXT           NOT NULL,
    price        DECIMAL(10, 2) NOT NULL,
    card_image   VARCHAR(255)   NOT NULL,
    status       TINYINT(1)     NOT NULL DEFAULT 1,
    detail_image VARCHAR(255)   NOT NULL,
    rating       DECIMAL(2, 1)  NOT NULL
);

CREATE TABLE product_category
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id  BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT product_category_product_fk FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT product_category_category_fk FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE product_gallery
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT       NOT NULL,
    image_url  VARCHAR(255) NOT NULL,
    CONSTRAINT product_gallery_product_fk FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE district
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE location
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    longitude   VARCHAR(255) NOT NULL,
    latitude    VARCHAR(255) NOT NULL,
    district_id BIGINT       NOT NULL,
    address     VARCHAR(255) NOT NULL,
    phone       VARCHAR(255) NOT NULL,
    image_url   VARCHAR(255) NOT NULL,
    status      TINYINT(1)   NOT NULL DEFAULT 1,
    FOREIGN KEY (district_id) REFERENCES district (id)
);

CREATE TABLE product_location_stock
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id  BIGINT NOT NULL,
    location_id BIGINT NOT NULL,
    quantity    INT    NOT NULL,
    CONSTRAINT product_location_stock_product_fk FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT product_location_stock_location_fk FOREIGN KEY (location_id) REFERENCES location (id)
);

CREATE TABLE customer_address
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    customer_id BIGINT       NOT NULL,
    district_id BIGINT       NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (district_id) REFERENCES district (id)
);

CREATE TABLE location_delivery
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    location_id BIGINT NOT NULL,
    district_id BIGINT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location (id),
    FOREIGN KEY (district_id) REFERENCES district (id),
    UNIQUE (location_id, district_id)
);

# TODO: Add delivery ( logica de que si es un monto mayor a tanto, delivery free, precio por diferentes distritos ), order box ( product + soda + cremas, etc )
