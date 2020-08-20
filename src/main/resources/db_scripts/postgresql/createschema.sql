CREATE DATABASE juzshop;
CREATE SCHEMA juzshop;
create table IF NOT EXISTS juzshop.PRODUCTS (
    product_id SERIAL PRIMARY KEY,
    product_name varchar,
    selling_price integer,
    MRP integer,
    disc_perc integer,
    supplier_name varchar,
    stock integer
);
create table IF NOT EXISTS juzshop.cart_hdr(
    cart_id serial primary key,
    user_id INTEGER,
    item_count INTEGER,
    cart_amount INTEGER,
    cart_status varchar
);
create table IF NOT EXISTS juzshop.cart_dtl(
    cart_id INTEGER,
    product_id integer,
    quantity integer,
    item_amount INTEGER,
    CONSTRAINT fk_cart FOREIGN KEY(cart_id) REFERENCES cart_hdr(cart_id) ON DELETE CASCADE
);
create table IF NOT EXISTS juzshop.order_hdr(
    order_id serial primary key,
    user_id INTEGER,
    total_item INTEGER,
    bill_amount INTEGER,
    order_status varchar,
    bill_disc INTEGER
);
create table IF NOT EXISTS juzshop.order_dtl(
    order_id INTEGER,
    product_id integer,
    quantity integer,
    item_amount INTEGER,
    disc_perc INTEGER,
    CONSTRAINT fk_order FOREIGN KEY(order_id) REFERENCES order_hdr(order_id) ON DELETE CASCADE
);
create table IF NOT EXISTS juzshop.customer (
    cust_user_id SERIAL PRIMARY KEY,
    cust_user_name varchar,
    shipping_addr VARCHAR,
    mobile_no VARCHAR,
    email_id VARCHAR,
    DOB varchar
);
create table IF NOT EXISTS juzshop.employee (
    emp_user_id SERIAL PRIMARY KEY,
    emp_user_name varchar,
    emp_role VARCHAR,
    mobile_no VARCHAR,
    email_id VARCHAR,
    DOB varchar
);