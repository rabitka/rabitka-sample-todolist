
CREATE TABLE TodoItem
(
  id_value             CHAR(100) NOT NULL,
  title                CHAR(100),
  priority                INTEGER,
  completed            BOOLEAN,
  creationDate          DATE

);
CREATE UNIQUE INDEX TodoItem_id_uindex
  ON TodoItem (id_value);
