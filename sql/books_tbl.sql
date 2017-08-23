CREATE TABLE books_tbl (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NULL,
  isbn VARCHAR(45) NULL,
  authors VARCHAR(4000) NULL,
  publish_date DATE NULL,
  page_count INT NULL,
  genre VARCHAR(45) NULL,
  publishing_house VARCHAR(255) NULL,
  PRIMARY KEY (id)
);
