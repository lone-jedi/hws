CREATE TABLE solution(
     id  SERIAL PRIMARY KEY,
     github_link CHAR(100) NOT NULL,
     author     CHAR(50) NOT NULL,
     comments   TEXT,
     publish_date  TIMESTAMP,
     task_id  int NOT NULL
);

CREATE TABLE task(
     id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     description TEXT,
     deadline DATE,
     -- Update to false if need to delete task or hide or something else
     is_active BOOLEAN DEFAULT true,
     publish_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Add foreign key to solution.task_id
ALTER TABLE solution ADD CONSTRAINT fk_solution_task
    FOREIGN KEY (task_id)
    REFERENCES task(id)
    ON DELETE CASCADE ;