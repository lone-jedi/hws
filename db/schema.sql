 CREATE TABLE solution(
   id  SERIAL PRIMARY KEY,
   github_link CHAR(100) NOT NULL,
   author     CHAR(50) NOT NULL,
   comments   TEXT,
   publish_date  TIMESTAMP,
   task_name  CHAR(50) NOT NULL
);