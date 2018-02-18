CREATE TABLE contact
(
  contact_id BIGINT auto_increment PRIMARY KEY,
  name VARCHAR(255)
);

ALTER TABLE contact ALTER COLUMN contact_id SET NOT NULL;
ALTER TABLE contact ALTER COLUMN name  SET NOT NULL;


CREATE TABLE application
(
  application_id BIGINT auto_increment PRIMARY KEY,
  contact_id     BIGINT,
  dt_created TIMESTAMP,
  product_name VARCHAR(255),
  FOREIGN KEY(contact_id) REFERENCES contact(contact_id) ON UPDATE CASCADE ON DELETE CASCADE
);

ALTER TABLE application ALTER COLUMN application_id SET NOT NULL;
ALTER TABLE application ALTER COLUMN contact_id  SET NOT NULL;
ALTER TABLE application ALTER COLUMN dt_created SET NOT NULL;
ALTER TABLE application ALTER COLUMN product_name SET NOT NULL;

CREATE INDEX application_contact_id_i ON application(contact_id);
CREATE INDEX application_dt_created_i ON application(dt_created);

